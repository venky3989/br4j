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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

import com.aplana.dmsi.ObjectFactory;
import com.aplana.dmsi.types.adapters.DocumentTypeAdapter;
import com.aplana.dmsi.types.common.File;

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
 *         &lt;element name=&quot;Document&quot; type=&quot;{}DocumentType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;TaskList&quot; type=&quot;{}TaskListType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;AddDocuments&quot; type=&quot;{}AddDocumentsType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Expansion&quot; type=&quot;{}ExpansionType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;Acknowledgement&quot; type=&quot;{}AcknowledgementType&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name=&quot;standart&quot; use=&quot;required&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;version&quot; use=&quot;required&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;time&quot; use=&quot;required&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot; /&gt;
 *       &lt;attribute name=&quot;msg_type&quot; use=&quot;required&quot; type=&quot;{}HeaderMessageEnumType&quot; /&gt;
 *       &lt;attribute name=&quot;msg_id&quot; use=&quot;required&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;msg_acknow&quot; type=&quot;{}HeaderAsknowEnumType&quot; default=&quot;0&quot; /&gt;
 *       &lt;attribute name=&quot;from_org_id&quot; use=&quot;required&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;from_organization&quot; use=&quot;required&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;from_department&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;from_sys_id&quot; use=&quot;required&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;from_system&quot; use=&quot;required&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;from_system_details&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;to_org_id&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;to_organization&quot; use=&quot;required&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;to_department&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;to_sys_id&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;to_system&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;to_system_details&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = { "document", "taskList", "addDocuments", "expansion", "acknowledgement" }, factoryClass = ObjectFactory.class, factoryMethod = "createHeader")
@XmlRootElement(name = "Header")
public class Header extends DMSIObject {

    protected DocumentType document;
    protected TaskListType taskList;
    protected AddDocumentsType addDocuments;
    protected ExpansionType expansion;
    protected AcknowledgementType acknowledgement;
    protected String standart = "";
    protected String version = "";
    protected XMLGregorianCalendar time;
    protected HeaderMessageEnumType msgType;
    protected String msgId = "";
    protected HeaderAsknowEnumType msgAcknow = HeaderAsknowEnumType.NO;
    protected String fromOrgId = "";
    protected String fromOrganization = "";
    protected String fromDepartment;
    protected String fromSysId = "";
    protected String fromSystem = "";
    protected String fromSystemDetails;
    protected String toOrgId;
    protected String toOrganization = "";
    protected String toDepartment;
    protected String toSysId;
    protected String toSystem;
    protected String toSystemDetails;
	protected File sourceFile;
    protected String name;
    protected String processingResult;
    protected Organization recipient;
    protected MessageDirectionEnumType direction = MessageDirectionEnumType.INCOME;

    /**
     * Gets the value of the document property.
     *
     * @return possible object is {@link DocumentType }
     *
     */
    @XmlElement(name = "Document")
    @XmlJavaTypeAdapter(DocumentTypeAdapter.class)
    public DocumentType getDocument() {
	return document;
    }

    /**
     * Sets the value of the document property.
     *
     * @param value
     *                allowed object is {@link DocumentType }
     *
     */
    public void setDocument(DocumentType value) {
	this.document = value;
		fillTasksDescription();
    }

    /**
     * Gets the value of the taskList property.
     *
     * @return possible object is {@link TaskListType }
     *
     */
    @XmlElement(name = "TaskList")
    public TaskListType getTaskList() {
	return taskList;
    }

    /**
     * Sets the value of the taskList property.
     *
     * @param value
     *                allowed object is {@link TaskListType }
     *
     */
    public void setTaskList(TaskListType value) {
	this.taskList = value;
		fillTasksDescription();
    }

	private void fillTasksDescription() {
		if (getDocument() != null && getTaskList() != null) {
			getDocument().setTasksDescription(getTaskList().toString());
		}
	}

    /**
     * Gets the value of the addDocuments property.
     *
     * @return possible object is {@link AddDocumentsType }
     *
     */
    @XmlElement(name = "AddDocuments")
    public AddDocumentsType getAddDocuments() {
	return addDocuments;
    }

    /**
     * Sets the value of the addDocuments property.
     *
     * @param value
     *                allowed object is {@link AddDocumentsType }
     *
     */
    public void setAddDocuments(AddDocumentsType value) {
	this.addDocuments = value;
    }

    /**
     * Gets the value of the expansion property.
     *
     * @return possible object is {@link ExpansionType }
     *
     */
    @XmlElement(name = "Expansion")
	@XmlJavaTypeAdapter(com.aplana.dmsi.types.adapters.ExpansionAdapter.class)
    public ExpansionType getExpansion() {
	if (expansion == null) {
	    expansion = new ExpansionType();
	}
	return expansion;
    }

    /**
     * Sets the value of the expansion property.
     *
     * @param value
     *                allowed object is {@link ExpansionType }
     *
     */
    public void setExpansion(ExpansionType value) {
	this.expansion = value;
    }

    /**
     * Gets the value of the acknowledgement property.
     *
     * @return possible object is {@link AcknowledgementType }
     *
     */
    @XmlElement(name = "Acknowledgement")
    public AcknowledgementType getAcknowledgement() {
	return acknowledgement;
    }

    /**
     * Sets the value of the acknowledgement property.
     *
     * @param value
     *                allowed object is {@link AcknowledgementType }
     *
     */
    public void setAcknowledgement(AcknowledgementType value) {
	this.acknowledgement = value;
    }

    /**
     * Gets the value of the standart property.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlAttribute(required = true)
    public String getStandart() {
	return standart;
    }

    /**
     * Sets the value of the standart property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setStandart(String value) {
	this.standart = value;
    }

    /**
     * Gets the value of the version property.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlAttribute(required = true)
    public String getVersion() {
	return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setVersion(String value) {
	this.version = value;
    }

    /**
     * Gets the value of the time property.
     *
     * @return possible object is {@link XMLGregorianCalendar }
     *
     */
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "dateTime")
    public XMLGregorianCalendar getTime() {
	return time;
    }

    /**
     * Sets the value of the time property.
     *
     * @param value
     *                allowed object is {@link XMLGregorianCalendar }
     *
     */
    public void setTime(XMLGregorianCalendar value) {
	this.time = value;
    }

    /**
     * Gets the value of the msgType property.
     *
     */
    @XmlAttribute(name = "msg_type", required = true)
    public HeaderMessageEnumType getMsgType() {
	return msgType;
    }

    /**
     * Sets the value of the msgType property.
     *
     */
    public void setMsgType(HeaderMessageEnumType value) {
	this.msgType = value;
    }

    /**
     * Gets the value of the msgId property.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlAttribute(name = "msg_id", required = true)
    public String getMsgId() {
	return msgId;
    }

    /**
     * Sets the value of the msgId property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setMsgId(String value) {
	this.msgId = value;
    }

    /**
     * Gets the value of the msgAcknow property.
     *
     * @return possible object is {@link Byte }
     *
     */
    @XmlAttribute(name = "msg_acknow")
    public HeaderAsknowEnumType getMsgAcknow() {
	return msgAcknow;
    }

    /**
     * Sets the value of the msgAcknow property.
     *
     * @param value
     *                allowed object is {@link Byte }
     *
     */
    public void setMsgAcknow(HeaderAsknowEnumType value) {
	this.msgAcknow = value;
    }

    /**
     * Gets the value of the fromOrgId property.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlAttribute(name = "from_org_id", required = true)
    public String getFromOrgId() {
	return fromOrgId;
    }

    /**
     * Sets the value of the fromOrgId property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setFromOrgId(String value) {
	this.fromOrgId = value;
    }

    /**
     * Gets the value of the fromOrganization property.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlAttribute(name = "from_organization", required = true)
    public String getFromOrganization() {
	return fromOrganization;
    }

    /**
     * Sets the value of the fromOrganization property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setFromOrganization(String value) {
	this.fromOrganization = value;
    }

    /**
     * Gets the value of the fromDepartment property.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlAttribute(name = "from_department")
    public String getFromDepartment() {
	return fromDepartment;
    }

    /**
     * Sets the value of the fromDepartment property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setFromDepartment(String value) {
	this.fromDepartment = value;
    }

    /**
     * Gets the value of the fromSysId property.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlAttribute(name = "from_sys_id", required = true)
    public String getFromSysId() {
	return fromSysId;
    }

    /**
     * Sets the value of the fromSysId property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setFromSysId(String value) {
	this.fromSysId = value;
    }

    /**
     * Gets the value of the fromSystem property.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlAttribute(name = "from_system", required = true)
    public String getFromSystem() {
	return fromSystem;
    }

    /**
     * Sets the value of the fromSystem property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setFromSystem(String value) {
	this.fromSystem = value;
    }

    /**
     * Gets the value of the fromSystemDetails property.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlAttribute(name = "from_system_details")
    public String getFromSystemDetails() {
	return fromSystemDetails;
    }

    /**
     * Sets the value of the fromSystemDetails property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setFromSystemDetails(String value) {
	this.fromSystemDetails = value;
    }

    /**
     * Gets the value of the toOrgId property.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlAttribute(name = "to_org_id")
    public String getToOrgId() {
	return recipient == null ? toOrgId : recipient.getOrganizationid();
    }

    /**
     * Sets the value of the toOrgId property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setToOrgId(String value) {
	this.toOrgId = value;
    }

    /**
     * Gets the value of the toOrganization property.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlAttribute(name = "to_organization", required = true)
    public String getToOrganization() {
	return recipient == null ? toOrganization : recipient.getFullname();
    }

    /**
     * Sets the value of the toOrganization property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setToOrganization(String value) {
	this.toOrganization = value;
    }

    /**
     * Gets the value of the toDepartment property.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlAttribute(name = "to_department")
    public String getToDepartment() {
	return toDepartment;
    }

    /**
     * Sets the value of the toDepartment property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setToDepartment(String value) {
	this.toDepartment = value;
    }

    /**
     * Gets the value of the toSysId property.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlAttribute(name = "to_sys_id")
    public String getToSysId() {
	return toSysId;
    }

    /**
     * Sets the value of the toSysId property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setToSysId(String value) {
	this.toSysId = value;
    }

    /**
     * Gets the value of the toSystem property.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlAttribute(name = "to_system")
    public String getToSystem() {
	return toSystem;
    }

    /**
     * Sets the value of the toSystem property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setToSystem(String value) {
	this.toSystem = value;
    }

    /**
     * Gets the value of the toSystemDetails property.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlAttribute(name = "to_system_details")
    public String getToSystemDetails() {
	return toSystemDetails;
    }

    /**
     * Sets the value of the toSystemDetails property.
     *
     * @param value
     *                allowed object is {@link String }
     *
     */
    public void setToSystemDetails(String value) {
	this.toSystemDetails = value;
    }

    @XmlTransient
	public File getSourceFile() {
		return this.sourceFile;
    }

	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
    }

    @XmlTransient
    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @XmlTransient
    public String getProcessingResult() {
	return this.processingResult;
    }

    public void setProcessingResult(String processingResult) {
	this.processingResult = processingResult;
    }

    @XmlTransient
    public Organization getRecipient() {
	return this.recipient;
    }

    public void setRecipient(Organization recipient) {
	this.recipient = recipient;
    }

    @XmlTransient
    public MessageDirectionEnumType getDirection() {
	return this.direction;
    }

    public void setDirection(MessageDirectionEnumType direction) {
	this.direction = direction;
    }
}
