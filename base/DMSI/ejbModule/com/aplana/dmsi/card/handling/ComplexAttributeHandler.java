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
package com.aplana.dmsi.card.handling;

import java.util.Collection;

import com.aplana.dmsi.DMSIException;
import com.aplana.dmsi.value.controllers.ValueController;
import com.aplana.dmsi.value.controllers.ValuePart;

public class ComplexAttributeHandler extends AttributeHandlerExtension {

    private ValueController valueController;

    public ComplexAttributeHandler(ValueController valueController) {
	this.valueController = valueController;
    }

    @Override
    public void setAttributeValue(Object value) throws DMSIException {
	Object oldValue = super.getAttributeValue();
	valueController.setValue(oldValue);
	if (value instanceof ValuePart) {
	    valueController.appendValue((ValuePart) value);
	} else if (value instanceof Collection) {
	    for (Object atomValue : (Collection<?>) value) {
		valueController.appendValue((ValuePart) atomValue);
	    }
	}
	super.setAttributeValue(valueController.getValue());
    }

    @Override
    public Object getAttributeValue() throws DMSIException {
	Object attributeValue = super.getAttributeValue();
	valueController.setValue(attributeValue);
	return getLastPart(valueController);
    }

    private ValuePart getLastPart(ValueController controller)
	    throws DMSIException {
	ValuePart[] parts = controller.getParts();
	if (parts.length > 0) {
	    return parts[parts.length - 1];
	}
	return null;
    }
}
