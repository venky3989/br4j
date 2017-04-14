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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.4-b02-fcs
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2011.07.07 at 04:32:17 PM MSD
//

package com.aplana.dmsi.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * <p>
 * Java class for anonymous complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base=&quot;&lt;http://www.w3.org/2001/XMLSchema&gt;string&quot;&gt;
 *       &lt;attribute name=&quot;secname&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;firstname&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;fathersname&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "", propOrder = { "value" })
@XmlRootElement(name = "Name")
public class Name {

    protected String value;
    protected String secname;
    protected String firstname;
    protected String fathersname;

    // 'Calculated' values is necessary for storing of parsed from 'value'
    // details. If one of details is set directly, 'calculated' values were
    // store actual values.
    protected String calculatedSecname;
    protected String calculatedFirstname;
    protected String calculatedFathersname;

    private boolean isCalculating = true;

    /**
     * Gets the value of the value property.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlValue
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setValue(String value) {
        this.value = value;
        if (isCalculating && value != null && !"".equals(value)) {
            fillCalculatedValues();
        }
    }

    /**
     * Gets the value of the secname property.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlAttribute
    public String getSecname() {
        return secname;
    }

    /**
     * Sets the value of the secname property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setSecname(String value) {
        this.secname = value;
        if (value != null) {
            switchToNonCalculating();
            this.calculatedSecname = value;
        }
    }

    /**
     * Gets the value of the firstname property.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlAttribute
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the value of the firstname property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setFirstname(String value) {
        this.firstname = value;
        if (value != null) {
            switchToNonCalculating();
            this.calculatedFirstname = value;
        }
    }

    /**
     * Gets the value of the fathersname property.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlAttribute
    public String getFathersname() {
        return fathersname;
    }

    /**
     * Sets the value of the fathersname property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setFathersname(String value) {
        this.fathersname = value;
        if (value != null) {
            switchToNonCalculating();
            this.calculatedFathersname = value;
        }
    }

    @XmlTransient
    public String getCalculatedSecname() {
        return this.calculatedSecname;
    }

    @XmlTransient
    public String getCalculatedFirstname() {
        return this.calculatedFirstname;
    }

    @XmlTransient
    public String getCalculatedFathersname() {
        return this.calculatedFathersname;
    }

    private void switchToNonCalculating() {
        if (isCalculating) {
            this.calculatedFathersname = null;
            this.calculatedFirstname = null;
            this.calculatedSecname = null;
        }
        isCalculating = false;
    }

    private void fillCalculatedValues() {
        String[] allParts = new String[3];
        final String replacer = " ";
        String[] actualParts = value.replaceAll("[\\s\\.]+", replacer).trim()
                .split(replacer, 3);
        System.arraycopy(actualParts, 0, allParts, 0, actualParts.length);
        this.calculatedSecname = allParts[0];
        this.calculatedFirstname = allParts[1];
        this.calculatedFathersname = allParts[2];
    }

}
