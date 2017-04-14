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
package com.aplana.dbmi.card.displaytag.comp;

import java.util.Comparator;

import org.displaytag.model.DefaultComparator;

import com.aplana.dbmi.model.Attribute;
import com.aplana.dbmi.model.IntegerAttribute;

/**
 * �����-�������. ���������� ����� �����������, ������� ������� ������������ ��� ����������
 * ������� display:column (���������� ����� displaytag.tld)
 *  
 * @author dstarostin
 *
 */
public class DisplayTagComparatorFactory {

	public static Class<? extends Comparator> getComparatorClass(Attribute attr) {
		if (attr instanceof IntegerAttribute) {
			return IntegerAttributeComparator.class;
		} else {
			return StringRemoveTagsAttributeComparator.class;
		}
	}
}
