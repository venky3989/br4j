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
package com.aplana.ireferent.util;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class ReflectionUtils {

    private ReflectionUtils() {
    }

    private static Map<Class<?>, Collection<Field>> fieldsCache = new HashMap<Class<?>, Collection<Field>>();

    public static Collection<Field> getFields(Class<?> clazz) {
	Collection<Field> fields = null;
	if (fieldsCache.containsKey(clazz)) {
	    fields = fieldsCache.get(clazz);
	} else {
	    fields = readAllDeclaredFields(clazz);
	    fieldsCache.put(clazz, fields);
	}
	return Collections.unmodifiableCollection(fields);
    }

    public static <T> T instantiateClass(Class<T> requiredClazz,
	    String className) {
	return instantiateClass(initializeClass(requiredClazz, className));
    }

    public static <T> T instantiateClass(Class<T> clazz) {
	try {
	    return clazz.newInstance();
	} catch (InstantiationException ex) {
	    throw new IllegalStateException("Error during instantiation of "
		    + clazz.getName(), ex);
	} catch (IllegalAccessException ex) {
	    throw new IllegalStateException(
		    "Accessing error during instantiation of "
			    + clazz.getName(), ex);
	}
    }

    @SuppressWarnings("unchecked")
    public static <T> Class<? extends T> initializeClass(
	    Class<T> requiredClazz, String className) {
	if ("".equals(className)) {
	    throw new IllegalArgumentException("Class name cannot be empty");
	}
	Class<?> clazz = null;
	try {
	    clazz = Class.forName(className);
	} catch (ClassNotFoundException ex) {
	    throw new IllegalStateException("There is no class with name "
		    + className, ex);
	}
	if (clazz == null || !requiredClazz.isAssignableFrom(clazz)) {
	    throw new IllegalStateException(String.format(
		    "Class %s should implement %s", className, requiredClazz
			    .getName()));
	}
	return (Class<? extends T>) clazz;
    }

    private static Collection<Field> readAllDeclaredFields(Class<?> clazz) {
	Collection<Field> fields = new HashSet<Field>();
	Class<?> currentClass = clazz;
	do {
	    Field[] classFields = currentClass.getDeclaredFields();
	    for (Field field : classFields) {
		fields.add(field);
	    }
	    currentClass = currentClass.getSuperclass();
	} while (currentClass != null);
	return fields;
    }

}
