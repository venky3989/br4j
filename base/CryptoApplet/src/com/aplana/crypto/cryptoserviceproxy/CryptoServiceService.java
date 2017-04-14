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

package com.aplana.crypto.cryptoserviceproxy;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "CryptoServiceService", targetNamespace = "http://crypto.aplana.com/", wsdlLocation = "http://localhost:18080/CryptoServer/service/CryptoService?wsdl")
public class CryptoServiceService
    extends Service
{

    private final static URL CRYPTOSERVICESERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.aplana.crypto.cryptoserviceproxy.CryptoServiceService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.aplana.crypto.cryptoserviceproxy.CryptoServiceService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:18080/CryptoServer/service/CryptoService?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:18080/CryptoServer/service/CryptoService?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        CRYPTOSERVICESERVICE_WSDL_LOCATION = url;
    }

    public CryptoServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CryptoServiceService() {
        super(CRYPTOSERVICESERVICE_WSDL_LOCATION, new QName("http://crypto.aplana.com/", "CryptoServiceService"));
    }

    /**
     * 
     * @return
     *     returns CryptoService
     */
    @WebEndpoint(name = "CryptoServicePort")
    public CryptoService getCryptoServicePort() {
        return super.getPort(new QName("http://crypto.aplana.com/", "CryptoServicePort"), CryptoService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CryptoService
     */
    @WebEndpoint(name = "CryptoServicePort")
    public CryptoService getCryptoServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://crypto.aplana.com/", "CryptoServicePort"), CryptoService.class, features);
    }

}
