package org.jacorb.config;

/*
 *        JacORB - a free Java ORB
 *
 *   Copyright (C) 1997-2009 Gerald Brose.
 *
 *   This library is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Library General Public
 *   License as published by the Free Software Foundation; either
 *   version 2 of the License, or (at your option) any later version.
 *
 *   This library is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *   Library General Public License for more details.
 *
 *   You should have received a copy of the GNU Library General Public
 *   License along with this library; if not, write to the Free
 *   Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

/**
 * Used to report errors in the JacORB configuration, such as missing
 * attributes or illegal attribute values.
 * @author Andre Spiegel <spiegel@gnu.org>
 * @version $Id: ConfigurationException.java,v 1.1 2009-04-25 10:01:23 andre.spiegel Exp $
 */
public class ConfigurationException extends RuntimeException
{
    public ConfigurationException (String message)
    {
        super (message);
    }
    
    public ConfigurationException (String message, Throwable cause)
    {
        super (message, cause);
    }
        
}
