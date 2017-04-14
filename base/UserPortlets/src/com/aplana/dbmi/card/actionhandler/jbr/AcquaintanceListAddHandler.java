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
package com.aplana.dbmi.card.actionhandler.jbr;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.aplana.dbmi.action.CreateCard;
import com.aplana.dbmi.action.Search;
import com.aplana.dbmi.action.UnlockObject;
import com.aplana.dbmi.card.PortletForm;
import com.aplana.dbmi.card.PortletFormManager;
import com.aplana.dbmi.card.PortletFormManagerAware;
import com.aplana.dbmi.card.actionhandler.CardPortletAttributeEditorActionHandler;
import com.aplana.dbmi.gui.FilteredCards;
import com.aplana.dbmi.gui.IListEditor;
import com.aplana.dbmi.gui.LinkChooser;
import com.aplana.dbmi.model.Attribute;
import com.aplana.dbmi.model.Card;
import com.aplana.dbmi.model.CardLinkAttribute;
import com.aplana.dbmi.model.DataObject;
import com.aplana.dbmi.model.DateAttribute;
import com.aplana.dbmi.model.ObjectId;
import com.aplana.dbmi.model.Person;
import com.aplana.dbmi.model.PersonAttribute;
import com.aplana.dbmi.model.Template;
import com.aplana.dbmi.service.DataException;
import com.aplana.dbmi.service.ServiceException;
import com.aplana.dbmi.service.AsyncDataServiceBean.ExecuteOption;

public class AcquaintanceListAddHandler extends CardPortletAttributeEditorActionHandler
		implements PortletFormManagerAware
{
	private static final ObjectId TEMPLATE_LIST =
		ObjectId.predefined(Template.class, "jbr.acquaintanceList");
	private static final ObjectId ATTR_RECIPIENTS =
		ObjectId.predefined(PersonAttribute.class, "jbr.acquaintanceList.recipients");
	
	private static final ObjectId TEMPLATE_ELEMENT =
		ObjectId.predefined(Template.class, "jbr.inform");
	private static final ObjectId ATTR_PERSON =
		ObjectId.predefined(PersonAttribute.class, "jbr.information.person");
	private static final ObjectId ATTR_DATE =
		ObjectId.predefined(DateAttribute.class, "jbr.information.term");
	
	private PortletFormManager manager;
	
	protected void process(Attribute attr, List cardIds, ActionRequest request,
			ActionResponse response) throws DataException {
		manager.openForm(new ListChooseForm((CardLinkAttribute) attr));
	}

	public void setPortletFormManager(PortletFormManager manager) {
		this.manager = manager;
	}
	
	public class ListChooseForm implements PortletForm
	{
		private CardLinkAttribute attr;
		private LinkChooser chooser;
		
		public ListChooseForm(CardLinkAttribute attr) {
			this.attr = attr;
			this.chooser = new LinkChooser();

			try {
				Search filter = new Search();
				filter.setByAttributes(true);
				filter.setTemplates(Collections.singletonList(DataObject.createFromId(TEMPLATE_LIST)));
				filter.setWords("");
				chooser.setDataProvider(new FilteredCards(serviceBean, filter, "***** Acquantance list"));
			} catch (Exception e) {
				logger.error("Error retrieving list of acquantance lists", e);
			}
		}
		
		public void doFormView(RenderRequest request, RenderResponse response)
				throws IOException, PortletException {
	    	request.setAttribute(LinkChooser.ATTR_INSTANCE, chooser);
			if (!chooser.doView(request, response))
				manager.closeForm();
		}

		public void processFormAction(ActionRequest request, ActionResponse response)
				throws IOException, PortletException {
			if (!chooser.processAction(request, response))
				manager.closeForm();

			String action = request.getParameter(IListEditor.FIELD_ACTION);
			if (IListEditor.ACTION_SAVE.equals(action)) {
				List selected = chooser.getDataProvider().getSelectedListData();
				if (selected == null || selected.size() == 0)
					return;
				
				try {
					ObjectId listId = (ObjectId) selected.iterator().next();
					Card list = (Card) serviceBean.getById(listId);
					PersonAttribute recipients = (PersonAttribute) list.getAttributeById(ATTR_RECIPIENTS);
					for (Iterator itr = recipients.getValues().iterator(); itr.hasNext(); ) {
						Person recipient = (Person) itr.next();
						addListElement(recipient);	//*****
					}
				} catch (Exception e) {
					getCardPortletSessionBean().setMessage(e.getMessage());
				}
				manager.closeForm();
			}
		}
		
		private void addListElement(Person recipient) throws DataException, ServiceException {
			CreateCard create = new CreateCard(TEMPLATE_ELEMENT);
			Card element = (Card) serviceBean.doAction(create);
			PersonAttribute cAttr = (PersonAttribute) element.getAttributeById(ATTR_PERSON);
			cAttr.setPerson(recipient);
			DateAttribute dAttr = (DateAttribute) element.getAttributeById(ATTR_DATE);
			dAttr.setValue(null);
			ObjectId elementId = serviceBean.saveObject(element, ExecuteOption.SYNC);
			attr.addLinkedId(elementId);
			
			//���������, ���� CreateCard ��������� ��������������� ��������� ��������.
			UnlockObject unlock = new UnlockObject();
			unlock.setId(elementId);
			serviceBean.doAction(unlock);
		}
	}
}