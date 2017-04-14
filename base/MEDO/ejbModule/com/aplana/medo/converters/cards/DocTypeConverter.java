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
package com.aplana.medo.converters.cards;

import java.util.Properties;

import com.aplana.medo.cards.CardException;
import com.aplana.medo.cards.DocType;
import com.aplana.medo.converters.ConverterException;

public class DocTypeConverter extends CardConverter {

    public DocTypeConverter(Properties properties, String name) {
	super(properties, name);
    }

    @Override
    protected long processValues() throws ConverterException {
	String docTypeName = getValueOfTagByKey("document.docType");
	try {
	    return new DocType(docTypeName).getCardId();
	} catch (CardException ex) {
	    throw new ConverterException("jbr.medo.converter.docType.find",
		    new Object[] { name }, ex);
	}
    }

}