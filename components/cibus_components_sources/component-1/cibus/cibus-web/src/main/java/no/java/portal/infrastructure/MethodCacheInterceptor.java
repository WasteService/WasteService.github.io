/*
 * Copyright 2002-2004 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package no.java.portal.infrastructure;

import java.io.Serializable;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import no.java.portal.domain.Identifiable;

/**
 * Fetched from
 * http://opensource.atlassian.com/confluence/spring/display/DISC/Caching
 * +the+result+of+methods+using+Spring+and+EHCache
 * 
 * @author <a href="mailto:irbouh@gmail.com">Omar Irbouh</a>
 * @since 2004.10.07
 */
public class MethodCacheInterceptor implements MethodInterceptor,
		InitializingBean {
	private static final Log logger = LogFactory
			.getLog(MethodCacheInterceptor.class);

	private Cache cache;

	/**
	 * sets cache name to be used
	 */
	public void setCache(Cache cache) {
		this.cache = cache;
	}

	/**
	 * Checks if required attributes are provided.
	 */
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(cache,
				"A cache is required. Use setCache(Cache) to provide one.");
	}

	/**
	 * main method caches method result if method is configured for caching
	 * method results must be serializable
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String targetName = invocation.getThis().getClass().getName();
		String methodName = invocation.getMethod().getName();
		Object[] arguments = invocation.getArguments();
		Object result;

		logger.debug("looking for method result in cache");
		String cacheKey = getCacheKey(targetName, methodName, arguments);
		Element element = cache.get(cacheKey);
		if (element == null) {
			// call target/sub-interceptor
			logger.debug("calling intercepted method");
			result = invocation.proceed();

			// cache method result
			logger.debug("caching result " + cacheKey);
			element = new Element(cacheKey, (Serializable) result);
			cache.put(element);
		}
		return element.getValue();
	}

	/**
	 * Creates cache key: targetName.methodName.argument0.argument1...
	 * <p>
	 * Relies on the interface {@link Identifiable} in order to create a good
	 * key for an argument. If not; it will use {@link Object#toString()}.
	 * <p>
	 * PS: Ehcache (de)serialise objects which means you do not get the same
	 * object.
	 */
	private String getCacheKey(String targetName, String methodName,
			Object[] arguments) {
		StringBuffer sb = new StringBuffer();
		sb.append(targetName).append(".").append(methodName);
		if ((arguments != null) && (arguments.length != 0)) {
			for (int i = 0; i < arguments.length; i++) {
				sb.append(".");
				if (arguments[i] instanceof Identifiable) {
					sb.append(((Identifiable) arguments[i]).getId());
				} else {
					sb.append(arguments[i]);
				}
			}
		}

		return sb.toString();
	}

}
