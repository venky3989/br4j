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

import org.displaytag.Messages;


/**
 * Runtime exception thrown for problems in loading the (standard or user defined) property file.
 * @author Fabrizio Giustina
 * @version $Revision: 720 $ ($Author: fgiust $)
 */
public class TablePropertiesLoadException extends BaseNestableRuntimeException
{

    /**
     * D1597A17A6.
     */
    private static final long serialVersionUID = 899149338534L;

    /**
     * Constructor for TablePropertiesLoadException.
     * @param source Class where the exception is generated
     * @param propertiesFileName properties file name
     * @param cause previous Exception
     */
    public TablePropertiesLoadException(Class source, String propertiesFileName, Throwable cause)
    {
        super(source, Messages.getString("TablePropertiesLoadException.msg", //$NON-NLS-1$
            new Object[]{propertiesFileName}), cause);
    }

    /**
     * @return SeverityEnum.ERROR
     * @see org.displaytag.exception.BaseNestableRuntimeException#getSeverity()
     * @see org.displaytag.exception.SeverityEnum
     */
    public SeverityEnum getSeverity()
    {
        return SeverityEnum.ERROR;
    }

}