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
package com.aplana.dbmi.storage.content.exceptions;

/**
 * Base class for content exceptions.
 * 
 * @author <a href="mailto:ogalkin@aplana.com">Oleg Galkin</a>
 */
public class ContentException extends RuntimeException {
	private static final long serialVersionUID = 4048822365879554548L;

	/**
	 * Constructs a new {@link ContentException} without specified detail message.
	 */
	public ContentException() {
		super();
	}

	/**
	 * Constructs a new {@link ContentException} with specified detail message.
	 *
	 * @param message the error message
	 */
	public ContentException(String message) {
		super(message);
	}

	/**
	 * Constructs a new {@link ContentException} with specified nested {@link Throwable}.
	 *
	 * @param cause the exception or error that caused this exception to be thrown
	 */
	public ContentException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Constructs a new {@link ContentException} with specified detail message and nested
	 * {@link Throwable}.
	 *
	 * @param message the error message
	 * @param cause   the exception or error that caused this exception to be thrown
	 */
	public ContentException(String message, Throwable cause) {
		super(message, cause);
	}
}
