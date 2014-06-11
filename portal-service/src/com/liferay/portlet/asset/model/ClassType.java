/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.asset.model;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * @author Adolfo Pérez
 */
public interface ClassType {

	public ClassTypeField getClassTypeField(String fieldName)
		throws PortalException;

	public List<ClassTypeField> getClassTypeFields()
		throws PortalException;

	public List<ClassTypeField> getClassTypeFields(int start, int end)
		throws PortalException;

	public int getClassTypeFieldsCount()
		throws PortalException;

	public long getClassTypeId();

	public String getName();

}