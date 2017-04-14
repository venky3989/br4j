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

import com.aplana.dbmi.service.DataServiceBean;
import com.aplana.ireferent.IReferentException;
import com.aplana.ireferent.types.WSOTaskReport;
import com.aplana.ireferent.types.WSObject;

public class SetReportValueAction extends ChangeCardAction {

    private static final String REPORT_VALUE_PARAM = "report";

    private String reportValue;

    @Override
    public void setParameter(String key, Object value) {
	if (REPORT_VALUE_PARAM.equals(key)) {
	    reportValue = String.valueOf(value);
	} else {
	    super.setParameter(key, value);
	}
    }

    @Override
    public void doAction(DataServiceBean serviceBean, WSObject object)
	    throws IReferentException {
	final String report = getReportValue();
	final boolean isReportDefined = !"".equals(report);
	if (!isReportDefined) {
	    return;
	}
	super.doAction(serviceBean, object);
    }

    @Override
    protected WSObject createObject() {
	WSOTaskReport object = new WSOTaskReport();
	object.setComments(reportValue);
	return object;
    }

    private String getReportValue() {
	return reportValue == null ? "" : reportValue.toString().trim();
    }
}
