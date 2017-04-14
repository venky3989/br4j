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
package com.aplana.ireferent.actions;

import java.util.Collection;

import com.aplana.dbmi.model.Card;
import com.aplana.dbmi.model.WorkflowMove;
import com.aplana.dbmi.service.DataServiceBean;
import com.aplana.ireferent.IReferentException;
import com.aplana.ireferent.types.WSObject;

public class ChangeStateReportsFromParentTaskAction extends ChangeStateAction {
	
	 public static final String PARENT_TASK = "parentTask";
	 
	 WSObject parentTask;
	 @Override
	 public void setParameter(String key, Object value) {
		 if (PARENT_TASK.equals(key)) {
			 parentTask = (WSObject)value;
		 } 
		 else {
			 super.setParameter(key, value);
		}
	 }
	 
	 @Override
	 public void doAction(DataServiceBean serviceBean, WSObject object)
			    throws IReferentException {
		 if (null != parentTask) {
		 	object = parentTask;
			Collection<Card> cards = getFilteredCards(serviceBean, object);

			if (!isOptional && cards.isEmpty()) {
			    throw new IReferentException("Cards for processing were not found");
			}

			for (Card card : cards) {
			    WorkflowMove workflowMove = calculateWorkflowMove(serviceBean, card);
			    if (workflowMove == null) {
				throw new IReferentException(
					"It is impossible to change state of card "
						+ card.getId().getId());
			    }
			    changeState(serviceBean, card, workflowMove);
			}
		 }
	 }
}
