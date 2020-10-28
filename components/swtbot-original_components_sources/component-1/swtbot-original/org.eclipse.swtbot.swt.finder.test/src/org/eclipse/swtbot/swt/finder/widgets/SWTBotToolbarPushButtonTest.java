/*******************************************************************************
 * Copyright (c) 2008 Ketan Padegaonkar and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ketan Padegaonkar - initial API and implementation
 *******************************************************************************/
package org.eclipse.swtbot.swt.finder.widgets;

import static org.eclipse.swtbot.swt.finder.SWTBotTestCase.assertNotSameWidget;
import static org.eclipse.swtbot.swt.finder.SWTBotTestCase.assertTextContains;
import static org.eclipse.swtbot.swt.finder.SWTBotTestCase.pass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.finders.AbstractSWTTestCase;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.junit.Test;

/**
 * @author Ketan Padegaonkar &lt;KetanPadegaonkar [at] gmail [dot] com&gt;
 * @version $Id$
 */
public class SWTBotToolbarPushButtonTest extends AbstractSWTTestCase {

	private SWTBot	bot;

	@Test
	public void findsToolBarPushButtons() throws Exception {
		bot.toolbarButton("Push");
	}

	@Test
	public void findsToolBarButtonWithIndex() throws Exception {
		SWTBotToolbarButton button0 = bot.toolbarButton("Push");
		SWTBotToolbarButton button1 = bot.toolbarButton("Push", 1);
		assertNotSameWidget(button0.widget, button1.widget);
	}

	@Test
	public void doesNotFindToolBarRadioButtons() throws Exception {
		try {
			bot.toolbarButton("Radio");
			fail("Expecting an exception");
		} catch (WidgetNotFoundException e) {
			pass();
		}
	}

	@Test
	public void doesNotFindToolBarCheckButtons() throws Exception {
		try {
			bot.toolbarButton("Check");
			fail("Expecting an exception");
		} catch (WidgetNotFoundException e) {
			pass();
		}
	}

	@Test
	public void clicksToolBarButton() throws Exception {
		try {
			bot.checkBox("Listen").select();
			SWTBotToolbarButton button = bot.toolbarButtonWithTooltip("SWT.PUSH");
			button.click();
			assertTextContains("Selection [13]: SelectionEvent{ToolItem ", bot.textInGroup("Listeners").widget);
		} finally {
			bot.checkBox("Listen").deselect();
		}
	}

	@Test
	public void isEnabled() throws Exception {
		final SWTBotToolbarButton button = bot.toolbarButton("Push");
		assertTrue(button.isEnabled());
		try {
			UIThreadRunnable.syncExec(display, new VoidResult() {
				public void run() {
					button.widget.setEnabled(false);
				}
			});
			assertFalse(button.isEnabled());
		} finally {
			UIThreadRunnable.syncExec(display, new VoidResult() {
				public void run() {
					button.widget.setEnabled(true);
				}
			});
		}
	}

	public void setUp() throws Exception {
		super.setUp();
		bot = new SWTBot();
		bot.tabItem("ToolBar").activate();
	}
}
