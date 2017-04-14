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
package com.aplana.dbmi.card.hierarchy.util;

import java.util.Iterator;

import com.aplana.dbmi.model.Attribute;
import com.aplana.dbmi.model.Card;
import com.aplana.dbmi.model.CardLinkAttribute;
import com.aplana.dbmi.model.DataObject;
import com.aplana.dbmi.model.ObjectId;
import com.aplana.dbmi.model.util.ObjectIdUtils;
import com.aplana.dbmi.service.DataServiceBean;

public class CardLinkAttributeHandler extends AttributeHandler {
	public CardLinkAttributeHandler(String value, Class clazz) {
		super(value, clazz);
	}
	public Object stringToValue(String st, DataServiceBean serviceBean) {
		if (st == null || "".equals(st)) {
			return null;
		}
		ObjectId cardId = ObjectIdUtils.getObjectId(Card.class, st, true);
		return DataObject.createFromId(cardId);
	}
	public boolean matchValue(Attribute attr, Object value) {
		final CardLinkAttribute a = (CardLinkAttribute)attr;
		final Card card = (Card) value;
		if (value == null)
			return attr.isEmpty();
		return a.getIdsLinked().contains( card.getId() );
	}
}
