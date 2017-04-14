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

package com.aplana.soz.client;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

import com.aplana.soz.service.DMSExchangePortType;



/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.1-b03-
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "DMSExchangePortTypeImplService", targetNamespace = "urn://x-artefacts-it-ru/dob/poltava/dmsx/1.0", wsdlLocation = "http://127.0.0.1:8080/SOZExchangeServices/DMSExchangePortType?wsdl")
public class DMSExchangeService
    extends Service
{

    public DMSExchangeService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }


    /**
     * 
     * @return
     *     returns DMSExchangePortType
     */
    @WebEndpoint(name = "DMSExchangeEndpoint")
    public DMSExchangePortType getDMSExchangeEndpoint() {
        return (DMSExchangePortType)super.getPort(new QName("urn://x-artefacts-it-ru/dob/poltava/dmsx/1.0", "DMSExchangePortTypeImplPort"), DMSExchangePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DMSExchangePortType
     */
    @WebEndpoint(name = "DMSExchangeEndpoint")
    public DMSExchangePortType getDMSExchangeEndpoint(WebServiceFeature... features) {
        return (DMSExchangePortType)super.getPort(new QName("urn:DefaultNamespace", "DMSExchangePortTypeImplPort"), DMSExchangePortType.class, features);
    }

}
