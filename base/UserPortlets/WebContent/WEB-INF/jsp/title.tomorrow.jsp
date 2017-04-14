<%--

      Licensed to the Apache Software Foundation (ASF) under one or more
      contributor license agreements.  See the NOTICE file distributed with
      this work for additional information regarding copyright ownership.
      The ASF licenses this file to you under the Apache License, Version 2.0
      (the "License"); you may not use this file except in compliance with
      the License.  You may obtain a copy of the License at

          http://www.apache.org/licenses/LICENSE-2.0

      Unless required by applicable law or agreed to in writing, software
      distributed under the License is distributed on an "AS IS" BASIS,
      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
      See the License for the specific language governing permissions and
      limitations under the License.

--%>
<%@page  contentType="text/html"  pageEncoding="UTF-8" import="com.aplana.dbmi.search.*" %>

<%@taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="/WEB-INF/tld/treetag.tld" prefix="tree" %>
<%@taglib uri="/WEB-INF/tld/requesttags.tld" prefix="request" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="ap" tagdir="/WEB-INF/tags/subtag" %>


<%@page import="com.aplana.dbmi.model.web.*" %>
<%@page import="java.util.*" %>

<portlet:defineObjects/>

<table width="100%" class="tbottomline">
	<% 	final Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 1);
		final Date tomorrow = c.getTime();
	%>
	<tr>
			<!-- месяц в виде "Октябрь" -->
		<td align="left"> <%= String.format("%tB", new Object[] {tomorrow}) %> </td>
		<td align="center">завтра</td>
			<!-- день месяца в виде "1".."31" (для вида "03" формат '%td') -->
		<td align="right"> <%= String.format("%te", new Object[] {tomorrow}) %> </td>
	</tr>
	<tr>
			<!-- день недели в виде "понедельник".."воскресенье" -->
		<td align="right" colspan="3"> <%= String.format("%tA", new Object[] {tomorrow}) %> </td>
	</tr>
</table>

