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
package com.aplana.dbmi.ws.docstatisticservice;

import java.util.List;
/**
 * Represents document templates statistic by organization
 * @author ahasanov
 *
 */
public class OrganizationStatistic {

	private String orgName;
	private List<TemplateStatistic> templateStatistics;

	public List<TemplateStatistic> getTemplateStatistics() {
		return templateStatistics;
	}

	public void setTemplateStatistics(List<TemplateStatistic> templateStatistics) {
		this.templateStatistics = templateStatistics;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
}
