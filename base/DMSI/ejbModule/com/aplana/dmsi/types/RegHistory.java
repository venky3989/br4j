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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref=&quot;{}OrganizationOnly&quot;/&gt;
 *         &lt;element ref=&quot;{}RegNumber&quot;/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name=&quot;idnumber&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "organizationOnly", "regNumber" })
@XmlRootElement(name = "RegHistory")
public class RegHistory extends DMSIObject {

    @XmlElement(name = "OrganizationOnly", required = true)
    protected OrganizationOnly organizationOnly = new OrganizationOnly();
    @XmlElement(name = "RegNumber", required = true)
    protected RegNumber regNumber = new RegNumber();
    @XmlAttribute
    protected String idnumber;

    /**
     * Gets the value of the organizationOnly property.
     *
     * @return possible object is {@link OrganizationOnly }
     *
     */
    public OrganizationOnly getOrganizationOnly() {
	return organizationOnly;
    }

    /**
     * Sets the value of the organizationOnly property.
     *
     * @param value
     *                allowed object is {@link OrganizationOnly }
     *
     */
    public void setOrganizationOnly(OrganizationOnly value) {
	this.organizationOnly = value;
    }

    /**
     * Gets the value of the regNumber property.
     *
     * @return possible object is {@link RegNumber }
     *
     */
    public RegNumber getRegNumber() {
	return regNumber;
    }

    /**
     * Sets the value of the regNumber property.
     *
     * @param value
     *                allowed object is {@link RegNumber }
     *
     */
    public void setRegNumber(RegNumber value) {
	this.regNumber = value;
    }

    /**
     * Gets the value of the idnumber property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getIdnumber() {
	return idnumber;
    }

    /**
     * Sets the value of the idnumber property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setIdnumber(String value) {
	this.idnumber = value;
    }

}
