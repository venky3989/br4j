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
/**
 *
 */
package com.aplana.ireferent.endpoint.impl;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import com.aplana.ireferent.endpoint.DocumentManager;
import com.aplana.ireferent.types.WSOCollection;
import com.aplana.ireferent.types.WSOContext;
import com.aplana.ireferent.types.WSOWrapper;
import com.aplana.ireferent.types.WSOFile;
import com.aplana.ireferent.types.WSOMDocument;

@WebService(endpointInterface = "com.aplana.ireferent.endpoint.DocumentManager", targetNamespace = "urn:DefaultNamespace")
public class DocumentManagerImpl implements DocumentManager {
 
    @Resource
    WebServiceContext contextEndpoint;
    
    public WSOMDocument getDocument(final String id, final WSOContext context) {   	
	return ServiceOperationExecutor.execute(new GetDocumentOperation(id,
		context, contextEndpoint));
    }

    public WSOWrapper getDocuments(final boolean isMObject,
	    final boolean includeAttachments, final WSOCollection clientIdsDocs, final WSOContext context) {
    	return ServiceOperationExecutor.execute(new GetDocumentsOperation(
		isMObject, includeAttachments, clientIdsDocs, context, contextEndpoint));
    }
    
    public WSOFile getFile(final String id, final WSOContext context) {
    	return ServiceOperationExecutor.execute(new GetFileOperation(id,
    			context, contextEndpoint));
    }
}