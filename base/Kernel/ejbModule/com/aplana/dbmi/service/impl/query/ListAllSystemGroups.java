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
package com.aplana.dbmi.service.impl.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.aplana.dbmi.model.DataObject;
import com.aplana.dbmi.model.ObjectId;
import com.aplana.dbmi.model.SystemGroup;
import com.aplana.dbmi.model.SystemRole;
import com.aplana.dbmi.service.DataException;
import com.aplana.dbmi.service.impl.QueryBase;

/**
 * Query used to fetch all {@link SystemGroup} instances with {@link SystemRole} membership from database
 */
public class ListAllSystemGroups extends QueryBase {
	private static final long serialVersionUID = 1L;

	/**
	 * Fetches all {@link SystemGroup} objects from database
	 * @return List of {@link SystemGroup} objects respresenting all record from
	 * SYSTEM_GROUP table, ordered by name.
	 */
	@SuppressWarnings("unchecked")
	public Object processQuery() throws DataException {
		List<SystemGroup> result = getJdbcTemplate().query(
			"select group_code, group_name_rus, group_name_eng from system_group",
			new RowMapper() {
				public Object mapRow(ResultSet rs, int index)
						throws SQLException {
					ObjectId id = new ObjectId(SystemGroup.class, rs.getString(1));
					SystemGroup result = (SystemGroup)DataObject.createFromId(id);
					result.setNameRu(rs.getString(2));
					result.setNameEn(rs.getString(3));
					List<SystemRole> rolesList = getJdbcTemplate().query(
							"SELECT gr.role_code, sr.role_name_rus, sr.role_name_eng " +
							"FROM group_role gr INNER JOIN system_role sr ON gr.role_code=sr.role_code " +
							"WHERE gr.group_code=?",
							new Object[] { result.getId().getId() },
							new int[] { Types.VARCHAR },
							new RowMapper() {
								public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
									ObjectId systemRoleId = new ObjectId(SystemRole.class, rs.getString(1));
									SystemRole systemRole = (SystemRole)DataObject.createFromId(systemRoleId);
									systemRole.setNameRu(rs.getString(2));
									systemRole.setNameEn(rs.getString(3));						
									return systemRole;
								}
							});
					// sorting result list
					Collections.sort(
						rolesList,
						new Comparator<SystemRole>() {
							public int compare(SystemRole role1, SystemRole role2) {
								if (role1.getName() == null) {
									return -1;
								} else {
									return role1.getName().compareTo(role2.getName());
								}
							}
						}
					);
					result.setSystemRoles(rolesList);
					return result;
				}
			}
		);
		// sorting result list
		Collections.sort(
			result,
			new Comparator<SystemGroup>() {
				public int compare(SystemGroup group1, SystemGroup group2) {
					if (group1.getName() == null) {
						return -1;
					} else {
						return group1.getName().compareTo(group2.getName());
					}
				}
			}
		);
		return result;
	}
}


