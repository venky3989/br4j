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
package com.aplana.dbmi.ws.impl;

import java.util.Date;

import javax.jws.WebService;

import com.aplana.dbmi.ws.DocsStatisticService;
import com.aplana.dbmi.ws.docstatisticservice.DocsStatisticResponse;

/**
 * <code>DocsStatisticServiceImpl</code> is an implementation of <code>DocsStatisticService</code> web service
 * , prepares statistic about documents on the current server
 * <p>
 *
 * @author  ahasanov
 */
@WebService(endpointInterface = "com.aplana.dbmi.ws.DocsStatisticService")
public class DocsStatisticServiceImpl extends ServiceImplBase implements DocsStatisticService {

	@Override
	public DocsStatisticResponse getDocumentsStatistic(Date startPoint, Integer startInterval, Integer endInterval) {
		return DocsStatisticResponseHelper.getDocsStatisticResponse(getDataServiceBean(), startPoint, startInterval, endInterval);
	}
	
	
}
