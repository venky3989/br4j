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
 * OvdAdminService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aplana.owriter.ulteo.rpcclient;

public interface OvdAdminService extends javax.xml.rpc.Service {

/**
 * Ovd Session Manager administration console API
 */
    public java.lang.String getOvdAdminPortAddress();

    public com.aplana.owriter.ulteo.rpcclient.OvdAdminPortType getOvdAdminPort() throws javax.xml.rpc.ServiceException;

    public com.aplana.owriter.ulteo.rpcclient.OvdAdminPortType getOvdAdminPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
