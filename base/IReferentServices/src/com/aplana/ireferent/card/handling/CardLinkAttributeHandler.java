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
package com.aplana.ireferent.card.handling;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.aplana.dbmi.model.Attribute;
import com.aplana.dbmi.model.CardLinkAttribute;
import com.aplana.dbmi.model.ObjectId;

class CardLinkAttributeHandler extends AttributeHandler {
    private Log logger = LogFactory.getLog(getClass());

    public CardLinkAttributeHandler(Attribute attribute) {
	super(attribute);
    }

    @Override
    public Object getAttributeValue() {
	return ((CardLinkAttribute) attribute).getIdsArray();
    }

    @Override
    public void setAttributeValue(Object value) {
	if (value instanceof ObjectId) {
	    ((CardLinkAttribute) attribute).addLinkedId((ObjectId) value);
	} else if (value instanceof Long) {
	    ((CardLinkAttribute) attribute).addLinkedId((Long) value);
	} else if (value instanceof ObjectId[]) {
	    ((CardLinkAttribute) attribute).addIdsLinked(Arrays
		    .asList((ObjectId[]) value));
	} else {
	    logger.error(String.format(
		    "Incorrect type '%s' of cardlink value: %s", value
			    .getClass(), value));
	}
    }
}