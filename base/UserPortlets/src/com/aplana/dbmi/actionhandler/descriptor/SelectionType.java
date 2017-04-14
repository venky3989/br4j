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
package com.aplana.dbmi.actionhandler.descriptor;

public class SelectionType {
	private final String value;		

	private SelectionType(String value) {
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
		SelectionType type = (SelectionType)obj;
		return (obj != null && value.equals(type.value));
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public String toString() {
		return value;
	}

	public static SelectionType fromString(String val) {
		for (int i = 0; i < constants.length; ++i) {
			SelectionType type = constants[i];
			if (type.toString().equals(val)) {
				return type;
			}
		}
		throw new IllegalArgumentException("Unknown selection type: " + val);
	}

	public static final SelectionType NONE = new SelectionType("none");
	public static final SelectionType SINGLE = new SelectionType("single");
	public static final SelectionType MULTIPLE = new SelectionType("multiple");
	private static final SelectionType[] constants = new SelectionType[] {
		NONE,
		SINGLE,
		MULTIPLE
	};
}