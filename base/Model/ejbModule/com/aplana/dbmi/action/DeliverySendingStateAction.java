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

import com.aplana.dbmi.model.Card;
import com.aplana.dbmi.model.ObjectId;

public class DeliverySendingStateAction implements Action<Void> {

	private static final long serialVersionUID = 1L;
	
	// �������� ��
	private Card card;
	// ������� � �� �� �������� �������� (ELM_SENDING_STATUS)
	private ObjectId sendingStateId;
	// ������� � �� �� ������� �����������, �� ������� ���� �������/��������� ��������� �������� (JBR_DIST_CREATE_LIST)
	private ObjectId unservedAttr;
	
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public ObjectId getSendingStateId() {
		return sendingStateId;
	}

	public void setSendingStateId(ObjectId sendingStateId) {
		this.sendingStateId = sendingStateId;
	}

	public ObjectId getUnservedAttr() {
		return unservedAttr;
	}

	public void setUnservedAttr(ObjectId unservedAttr) {
		this.unservedAttr = unservedAttr;
	}

	@Override
	public Class<?> getResultType() {
		return null;
	}

}
