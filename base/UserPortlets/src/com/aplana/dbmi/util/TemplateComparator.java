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
package com.aplana.dbmi.util;

import java.util.Comparator;

import com.aplana.dbmi.model.Template;

/**
 * Comparator used to sort templates by their names
 * Code was taken from CardPortlet
 * @author DSultanbekov
 */
public class TemplateComparator implements Comparator<Template> {
	public int compare(Template obj1, Template obj2) {
		if (obj1 == null || obj1.getName() == null)
			return (obj2 == null || obj2.getName() == null) ? 0 : -1;
		if (obj2 == null || obj2.getName() == null)
			return 1;
		return obj1.getName().compareTo(obj2.getName() );
	}
}
