<#--

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

-->
<#include "common.ftl">
<@header/>
<p>Для Вас создано новое поручение <@link card=card attrId="jbr.resolutionText" attrType="TextAttribute"/> (ID ${card.id.id?c}).</p>
<#assign base = util.getLinkedCard(card,"jbr.main.doc")>
<#if base??>
<p>Поручение по документу <@link card=base attrId="NAME"/> (ID ${base.id.id?c}).</p>
</#if>
<@footer/>
