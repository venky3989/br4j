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

import org.apache.commons.lang.ArrayUtils;
import org.displaytag.Messages;


/**
 * Exception thrown when a required attribute is not set. This is thrown when the user is required to set at least one
 * of multiple attributes and the check can't be enforced by the tld.
 * @author Fabrizio Giustina
 * @version $Revision: 720 $ ($Author: fgiust $)
 */
public class MissingAttributeException extends BaseNestableJspTagException
{

    /**
     * D1597A17A6.
     */
    private static final long serialVersionUID = 899149338534L;

    /**
     * list of tag attributes.
     */
    private final String[] attributes;

    /**
     * Constructor for MissingAttributeException.
     * @param source Class where the exception is generated
     * @param attributeNames String attribute name
     */
    public MissingAttributeException(Class source, String[] attributeNames)
    {
        super(source, Messages.getString("MissingAttributeException.msg", //$NON-NLS-1$
            new Object[]{ArrayUtils.toString(attributeNames)}));

        // copy attributes to allow them to be retrieved using getAttributeNames()
        this.attributes = (String[]) ArrayUtils.clone(attributeNames);
    }

    /**
     * @return SeverityEnum.ERROR
     * @see org.displaytag.exception.BaseNestableJspTagException#getSeverity()
     * @see org.displaytag.exception.SeverityEnum
     */
    public SeverityEnum getSeverity()
    {
        return SeverityEnum.ERROR;
    }

    /**
     * returns an array containing the names of missing attributes.
     * @return String[] array of missing attributes
     */
    public String[] getAttributeNames()
    {
        return (String[]) ArrayUtils.clone(this.attributes);
    }

}