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
 *
 */
package com.aplana.dmsi.card.handling;

import java.math.BigInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.aplana.dbmi.model.Attribute;
import com.aplana.dbmi.model.IntegerAttribute;
import com.aplana.dbmi.service.client.DataServiceFacade;

class IntegerAttributeHandler extends AttributeHandler {

    private Log logger = LogFactory.getLog(getClass());

    public IntegerAttributeHandler(Attribute attribute,
    		DataServiceFacade serviceBean) {
	super(attribute, serviceBean);
    }

    @Override
    public Object getAttributeValue() {
	return BigInteger.valueOf(((IntegerAttribute) getAttribute())
		.getValue());
    }

    @Override
    public void setAttributeValue(Object value) {
	if (value instanceof Integer) {
	    ((IntegerAttribute) getAttribute()).setValue((Integer) value);
	} else if (value instanceof BigInteger) {
	    ((IntegerAttribute) getAttribute()).setValue(((BigInteger) value)
		    .intValue());
	} else {
	    logger.error(String.format(
		    "Incorrect type '%s' of integer value: %s", value
			    .getClass(), value));
	}
    }
}