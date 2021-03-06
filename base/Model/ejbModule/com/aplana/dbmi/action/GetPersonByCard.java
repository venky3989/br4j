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
package com.aplana.dbmi.action;

import com.aplana.dbmi.model.ObjectId;
import com.aplana.dbmi.model.Person;

/**
 * {@link Action} used to get {@link Person} object by card ID.
 *
 * @author Vlad Alexandrov
 *
 */
public class GetPersonByCard implements Action<Person> {
    private static final long serialVersionUID = 1L;

	public GetPersonByCard(ObjectId cardId) {
		this.cardId = cardId;
	}

	/**
     *card ID
     */

    private ObjectId cardId;

    public ObjectId getCardId() {
        return cardId;
    }

    public void setCardId(ObjectId cardId) {
        this.cardId = cardId;
    }

	public Class<?> getResultType() {
		return Person.class;
	}
}
