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
package com.aplana.dbmi.numerator.query;

import com.aplana.dbmi.model.Card;
import com.aplana.dbmi.model.ObjectId;
import com.aplana.dbmi.model.Person;
import com.aplana.dbmi.model.PersonAttribute;
import com.aplana.dbmi.model.StringAttribute;
import com.aplana.dbmi.service.DataException;

public class NumeratorPartExecIF extends NumeratorPart {	
	final String ATTR_OUTSIGNER = "jbr.resolutionExecutor";
	final String ATTR_PERS_NAME = "jbr.person.firstName";
	final String ATTR_PERS_SNAME = "jbr.person.lastName";
	final ObjectId EXT_SIGNER = ObjectId.predefined(PersonAttribute.class, ATTR_OUTSIGNER);
	final ObjectId FNAME = ObjectId.predefined(StringAttribute.class, ATTR_PERS_NAME);
	final ObjectId SNAME = ObjectId.predefined(StringAttribute.class, ATTR_PERS_SNAME);
		
	public NumeratorPartExecIF(DoSetRegistrationNumber cardnum) {
		super(cardnum);		
	}

	public String getValue() throws DataException{
		String result = "";			
			Card card;
			try {
				PersonAttribute persAttr = ((PersonAttribute)cardNumerationObj.getContextCard()
						   .getAttributeById(EXT_SIGNER));
				Person pers = null;
				// ���� ������������� ���������, �� ����� �������
				if (persAttr.isMultiValued())
					pers = (Person)persAttr.getValues().toArray()[0];
				else
					pers = persAttr.getPerson();				
					
				card = cardNumerationObj.getCard(pers.getCardId());
					String firstName = ((StringAttribute)card.
							getAttributeById(FNAME)).getStringValue();
					String lastName = ((StringAttribute)card.
							getAttributeById(SNAME)).getStringValue();
					if(firstName.length() >= 1) firstName = firstName.substring(0, 1);
					if(lastName.length() >= 1) lastName = lastName.substring(0, 1);
					result = firstName + lastName;	
			} catch (NullPointerException e) {
				throw new DataException
				(
						"numerator.attributeNotSet", 
						new Object[] {cardNumerationObj.getAttributeNameById(EXT_SIGNER)}
				);
			}
		return result;
	}
}
