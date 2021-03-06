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
package com.aplana.dbmi.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.aplana.dbmi.Portal;

public class WorkflowProperties {
	private static String configFile = "dbmi/flags.properties";
	private static Properties props = new Properties();
	private static Log logger = LogFactory.getLog("WorkflowFlags");
	static{
		try {
			InputStream in = Portal.getFactory().getConfigService().loadConfigFile(configFile);
			props.load(in);
		} catch (IOException e) {
			logger.error("Cannot load config file " + configFile);
		}
	}
	public static String getProperty(String name){
		return props.getProperty(name);
	}
	private WorkflowProperties(){}
}
