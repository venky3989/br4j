/**
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to you under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
/**
 * Licensed under the Artistic License; you may not use this file
 * except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://displaytag.sourceforge.net/license.html
 *
 * THIS PACKAGE IS PROVIDED "AS IS" AND WITHOUT ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, WITHOUT LIMITATION, THE IMPLIED
 * WARRANTIES OF MERCHANTIBILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 */
package org.displaytag.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.displaytag.Messages;


/**
 * Base runtime exception: extendes RuntimeException providing logging and exception nesting functionalities.
 * @author Fabrizio Giustina
 * @version $Revision: 720 $ ($Author: fgiust $)
 */
public abstract class BaseNestableRuntimeException extends RuntimeException
{

    /**
     * Class where the exception has been generated.
     */
    private final Class sourceClass;

    /**
     * previous exception.
     */
    private Throwable nestedException;

    /**
     * Instantiate a new BaseNestableRuntimeException.
     * @param source Class where the exception is generated
     * @param message message
     */
    public BaseNestableRuntimeException(Class source, String message)
    {
        super(message);
        this.sourceClass = source;

        // log exception
        Log log = LogFactory.getLog(source);

        // choose appropriate logging method
        if (getSeverity() == SeverityEnum.DEBUG)
        {
            log.debug(toString());
        }
        else if (getSeverity() == SeverityEnum.INFO)
        {
            log.info(toString());
        }
        else if (getSeverity() == SeverityEnum.WARN)
        {
            log.warn(toString());
        }
        else
        {
            // error - default
            log.error(toString());
        }

    }

    /**
     * Instantiate a new BaseNestableRuntimeException.
     * @param source Class where the exception is generated
     * @param message message
     * @param cause previous Exception
     */
    public BaseNestableRuntimeException(Class source, String message, Throwable cause)
    {
        super(message);
        this.sourceClass = source;
        this.nestedException = cause;

        // log exception
        Log log = LogFactory.getLog(source);

        // choose appropriate logging method
        if (getSeverity() == SeverityEnum.DEBUG)
        {
            log.debug(toString(), cause);
        }
        else if (getSeverity() == SeverityEnum.INFO)
        {
            log.info(toString(), cause);
        }
        else if (getSeverity() == SeverityEnum.WARN)
        {
            log.warn(toString(), cause);
        }
        else
        {
            // error - default
            log.error(toString(), cause);
        }

    }

    /**
     * returns the previous exception.
     * @return Throwable previous exception
     */
    public Throwable getCause()
    {
        return this.nestedException;
    }

    /**
     * basic toString. Returns the message plus the previous exception (if a previous exception exists).
     * @return String
     */
    public String toString()
    {
        String className = this.sourceClass.getName();
        className = className.substring(className.lastIndexOf(".")); //$NON-NLS-1$

        if (this.nestedException == null)
        {
            return Messages.getString("NestableException.msg", //$NON-NLS-1$
                new Object[]{className, getMessage()});
        }

        return Messages.getString("NestableException.msgcause", //$NON-NLS-1$
            new Object[]{className, getMessage(), this.nestedException.getMessage()});
    }

    /**
     * subclasses need to define the getSeverity method to provide correct severity for logging.
     * @return SeverityEnum exception severity
     * @see org.displaytag.exception.SeverityEnum
     */
    public abstract SeverityEnum getSeverity();

}