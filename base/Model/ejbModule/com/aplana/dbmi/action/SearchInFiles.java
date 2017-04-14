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

import java.util.Collection;

import com.aplana.dbmi.model.Card;
import com.aplana.dbmi.model.ObjectId;

/**
 * Action used to search for given string in files attached to cards.
 * Expected result is a collection of {@link Card cards} {@link ObjectId identifiers}.
 * @author DSultanbekov
 */
public class SearchInFiles implements Action {
	private static final long serialVersionUID = 1L;
	private String words;
	
	/**
	 * Returns string pattern to be looked up for in cards files
	 * @return words search pattern 
	 */
	public String getWords() {
		return words;
	}

	/**
	 * Sets string pattern to be looked up for in cards files
	 * @param words search pattern
	 */
	public void setWords(String words) {
		this.words = words;
	}

	public Class getResultType() {
		return Collection.class;
	}
}