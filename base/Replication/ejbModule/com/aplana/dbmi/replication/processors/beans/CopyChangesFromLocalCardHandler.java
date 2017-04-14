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
package com.aplana.dbmi.replication.processors.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.aplana.dbmi.model.Card;
import com.aplana.dbmi.model.ObjectId;
import com.aplana.dbmi.service.DataException;
import com.aplana.dbmi.service.impl.DatabaseClient;

public abstract class CopyChangesFromLocalCardHandler {
	public static String BEAN_PREFIX = "updateByLocalCopy";
	
	public abstract void cardCreated(Card card) throws DataException;
	
	public abstract void cardChanged(Card card) throws DataException;
	
	public abstract ObjectId getDestinationCardId();

	public static CopyChangesFromLocalCardHandler createHandler(Card card, BeanFactory beanFactory, JdbcTemplate jdbc) {
		final String requiredBeanName = CopyChangesFromLocalCardHandler.BEAN_PREFIX + card.getTemplate().getId();
		if (beanFactory.containsBean(requiredBeanName)) {
			CopyChangesFromLocalCardHandler handler = (CopyChangesFromLocalCardHandler) beanFactory.getBean(
					requiredBeanName);
			if (handler instanceof DatabaseClient) {
				((DatabaseClient) handler).setJdbcTemplate(jdbc);
			}
			return handler;
		}
		return null;
	}
}