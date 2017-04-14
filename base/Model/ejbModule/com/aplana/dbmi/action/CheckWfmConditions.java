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

import java.util.Map;

import com.aplana.dbmi.model.Card;
import com.aplana.dbmi.model.ObjectId;
import com.aplana.dbmi.model.WorkflowMove;

public class CheckWfmConditions implements Action {
	private Card card;
	private ObjectId wfm;
	Map<String,Boolean> preEvaluatedValues;
	
	public Map<String, Boolean> getPreEvaluatedValues() {
		return preEvaluatedValues;
	}

	public void setPreEvaluatedValues(Map<String, Boolean> preEvaluatedValues) {
		this.preEvaluatedValues = preEvaluatedValues;
	}

	public ObjectId getWfm() {
		return wfm;
	}

	public void setWfm(ObjectId wfm) {
		this.wfm = wfm;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public Class getResultType() {
		return this.getClass();
	}
	
}
