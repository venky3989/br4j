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
<%@page  contentType="text/html"  pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ap" tagdir="/WEB-INF/tags/subtag" %>
<%@ taglib uri="/WEB-INF/tld/treetag.tld" prefix="tree" %>
<%@ taglib uri="/WEB-INF/tld/requesttags.tld" prefix="request" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@page import="com.aplana.dbmi.search.SearchPortlet"%>
<portlet:defineObjects/>
<fmt:setBundle basename="search"/>

<% if("ru".equals(renderResponse.getLocale().toString()) ||
         "ru_RU".equals(renderResponse.getLocale().toString())) {
	    pageContext.setAttribute("ruLocale", Boolean.TRUE);
    }else {
    	pageContext.setAttribute("ruLocale", Boolean.FALSE);
    }

%>

        <tr>
        <td colspan="2" align="left">
            <a href="#" onClick="return <portlet:namespace/>OnAttributeSearch('')"><fmt:message key="select.other.template.label" /></a>
            <br>
        </td>
        </tr>
        <tr>
        <td style="text-align: left">

           
           <c:forEach items="${searchBean.viewBlocks1}" var="viewBlock">
                
            <c:choose>

                 <c:when test="${ruLocale}">
                     <c:set target="${viewBlock}" property="name">
                         <c:out value="${viewBlock.nameRu}"></c:out>
                     </c:set>
                  </c:when> 
                  <c:otherwise>
                     <c:set target="${viewBlock}" property="name">
                         <c:out value="${viewBlock.nameEn}"></c:out>
                     </c:set>
                  </c:otherwise>       
            </c:choose>      
                
                
                <table style="width: 80%;">

            
                    <tbody>			
                        <tr>
                            <td>
                                <table style="width: 100%;" class="partition">
                                    <tbody>
                                        <tr>
                                            <td class="partition_left"></td>
                                            <td class="partition_middle">${viewBlock.name}</td>
                                            <td class="partition_right"></td>
                                        </tr>
                                    </tbody>
                                </table>
                                
                            </td>
                            <td>
						<ap:link  text="<span class='arrow'>&nbsp;</span>" clazz="noLine">
                        	<portlet:renderURL>
                    	    	<portlet:param name="block_id" value="${viewBlock.id.id}"/>
								<portlet:param name="portlet_action" value="<%= SearchPortlet.SEARCH_PORTLET_ACTION %>"/>
        					</portlet:renderURL>
						</ap:link>
                            </td>
                        </tr>

                    </tbody>
                </table>   
<c:if test="${viewBlock.show}"  >
                <div class="divPadding">
                <ap:attributes  templateAttributes="${viewBlock.attributes}"   path="attributes" urlPrefix="<%= renderRequest.getContextPath() %>"/>                         
                </div>                
</c:if>

           </c:forEach>
           
           
           
        </td>
        <td style="text-align: left">
               <c:forEach items="${searchBean.viewBlocks2}" var="viewBlock">
            <c:choose>

                 <c:when test="${ruLocale}">
                     <c:set target="${viewBlock}" property="name">
                         <c:out value="${viewBlock.nameRu}"></c:out>
                     </c:set>
                  </c:when> 
                  <c:otherwise>
                     <c:set target="${viewBlock}" property="name">
                         <c:out value="${viewBlock.nameEn}"></c:out>
                     </c:set>
                  </c:otherwise>       
            </c:choose>      
               
                <table style="width: 80%;">

                    <tbody>			
                        <tr>
                            <td>
                                <table style="width: 100%;" class="partition">
                                    <tbody>
                                        <tr>
                                            <td class="partition_left"></td>
                                            <td class="partition_middle">${viewBlock.name}</td>
                                            <td class="partition_right"></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                            <td>
							<ap:link  text="<span class='arrow'>&nbsp;</span>" clazz="noLine">
	                            <portlet:renderURL>
    		                        <portlet:param name="block_id" value="${viewBlock.id.id}"/>
                            		<portlet:param name="portlet_action" value="<%= SearchPortlet.SEARCH_PORTLET_ACTION %>"/>
                            	</portlet:renderURL>
                            </ap:link>
                            </td>
                            
                        </tr>

                    </tbody>
                </table> 
<c:if test="${viewBlock.show}"  >                    
                <div class="divPadding">
                <ap:attributes  templateAttributes="${viewBlock.attributes}"   path="attributes" urlPrefix="<%= renderRequest.getContextPath() %>"/>                         
                 </div>                
</c:if>

           </c:forEach>
        </td>
        
    </tr>

