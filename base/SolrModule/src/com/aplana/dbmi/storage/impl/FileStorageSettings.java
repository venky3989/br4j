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
package com.aplana.dbmi.storage.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.aplana.dbmi.Portal;

public class FileStorageSettings {

	private static Log logger = LogFactory.getLog(FileStorageSettings.class);

	private final static String SOLR_CONFIG = "dbmi/solr/solrModule.properties";

	private final static String KEY_FILESTORE_ROOT = "store.rootLocation";
	private final static String KEY_NULL_URL_ROOT  = "store.nullUrlRootLocation";
	private final static String KEY_SOLR_SERVER_URL = "solr.serverUrl";

	private static Properties props;
	
	public static Properties getProps() {
		if (props == null) {
			try {
				final InputStream is = Portal.getFactory().getConfigService().getConfigFileUrl(SOLR_CONFIG).openStream();
				final Properties p = new Properties();
				p.load(is);
				props = p;
			} catch (IOException e) {
				logger.error("Couldn't read settings file " + SOLR_CONFIG, e);
			}
		}
		return props;
	}

	public static String getFilestoreRoot() {
		return getProps().getProperty(KEY_FILESTORE_ROOT);
	}

	public static String getNullUrlRoot() {
		return getProps().getProperty(KEY_NULL_URL_ROOT);
	}

	public static String getSolrServerURL() {
		return getProps().getProperty(KEY_SOLR_SERVER_URL);
	}
}
