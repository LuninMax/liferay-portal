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

package com.liferay.dynamic.data.mapping.type.paragraph.internal;

import com.liferay.dynamic.data.mapping.annotations.DDMForm;
import com.liferay.dynamic.data.mapping.annotations.DDMFormField;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayout;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutColumn;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutPage;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutRow;
import com.liferay.dynamic.data.mapping.annotations.DDMFormRule;
import com.liferay.dynamic.data.mapping.form.field.type.DefaultDDMFormFieldTypeSettings;
import com.liferay.dynamic.data.mapping.model.DDMFormFieldValidation;
import com.liferay.dynamic.data.mapping.model.LocalizedValue;

/**
 * @author Bruno Basto
 */
@DDMForm(
	rules = {
		@DDMFormRule(
			actions = {
				"set(fieldAt(\"predefinedValue\", 0), \"visible\", false)",
				"set(fieldAt(\"repeatable\", 0), \"visible\", false)",
				"set(fieldAt(\"required\", 0), \"visible\", false)",
				"set(fieldAt(\"showLabel\", 0), \"visible\", false)",
				"set(fieldAt(\"tip\", 0), \"visible\", false)",
				"set(fieldAt(\"validation\", 0), \"visible\", false)"
			}
		)
	}
)
@DDMFormLayout(
	paginationMode = com.liferay.dynamic.data.mapping.model.DDMFormLayout.TABBED_MODE,
	value = {
		@DDMFormLayoutPage(
			title = "basic",
			value = {
				@DDMFormLayoutRow(
					{
						@DDMFormLayoutColumn(
							size = 12,
							value = {"label", "text", "tip", "required"}
						)
					}
				)
			}
		),
		@DDMFormLayoutPage(
			title = "properties",
			value = {
				@DDMFormLayoutRow(
					{
						@DDMFormLayoutColumn(
							size = 12,
							value = {
								"validation", "showLabel", "repeatable",
								"predefinedValue", "visibilityExpression",
								"fieldNamespace", "indexType", "localizable",
								"readOnly", "dataType", "type", "name"
							}
						)
					}
				)
			}
		)
	}
)
public interface ParagraphDDMFormFieldTypeSettings
	extends DefaultDDMFormFieldTypeSettings {

	@DDMFormField(
		label = "%title", properties = {"placeholder=%enter-a-title"},
		type = "key_value"
	)
	@Override
	public LocalizedValue label();

	@DDMFormField
	@Override
	public LocalizedValue predefinedValue();

	@DDMFormField
	@Override
	public boolean repeatable();

	@DDMFormField
	@Override
	public boolean required();

	@DDMFormField
	@Override
	public boolean showLabel();

	@DDMFormField(
		dataType = "string", label = "%body-text",
		properties = {"placeholder=%enter-body-text"}, required = true,
		type = "editor"
	)
	public String text();

	@DDMFormField
	@Override
	public LocalizedValue tip();

	@DDMFormField(dataType = "ddm-validation", type = "validation")
	@Override
	public DDMFormFieldValidation validation();

}