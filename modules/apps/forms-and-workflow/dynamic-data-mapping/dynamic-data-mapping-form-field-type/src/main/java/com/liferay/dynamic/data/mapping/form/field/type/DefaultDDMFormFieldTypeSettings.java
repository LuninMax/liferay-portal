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

package com.liferay.dynamic.data.mapping.form.field.type;

import com.liferay.dynamic.data.mapping.annotations.DDMForm;
import com.liferay.dynamic.data.mapping.annotations.DDMFormField;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayout;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutColumn;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutPage;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutRow;
import com.liferay.dynamic.data.mapping.annotations.DDMFormRule;
import com.liferay.dynamic.data.mapping.model.DDMFormFieldValidation;
import com.liferay.dynamic.data.mapping.model.LocalizedValue;
import com.liferay.portal.kernel.util.StringPool;

/**
 * @author Marcellus Tavares
 */
@DDMForm(
	rules = {
		@DDMFormRule(
			actions = {
				"set(fieldAt(\"fieldNamespace\", 0), \"visible\", false)",
				"set(fieldAt(\"indexType\", 0), \"visible\", false)",
				"set(fieldAt(\"localizable\", 0), \"visible\", false)",
				"set(fieldAt(\"readOnly\", 0), \"visible\", false)"
			}
		)
	}
)
@DDMFormLayout(
	{
		@DDMFormLayoutPage(
			title = "basic",
			value = {
				@DDMFormLayoutRow(
					{
						@DDMFormLayoutColumn(
							size = 12,
							value = {
								"label", "predefinedValue", "required", "tip"
							}
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
								"repeatable", "showLabel", "validation",
								"visibilityExpression"
							}
						)
					}
				)
			}
		)
	}
)
public interface DefaultDDMFormFieldTypeSettings
	extends DDMFormFieldTypeSettings {

	@DDMFormField
	public String fieldNamespace();

	@DDMFormField(
		label = "%indexable",
		optionLabels = {
			"%not-indexable", "%indexable-keyword", "%indexable-text"
		},
		optionValues = {StringPool.BLANK, "keyword", "text"},
		predefinedValue = "keyword", type = "select"
	)
	public String indexType();

	@DDMFormField(
		label = "%label",
		properties = {
			"placeholder=%enter-a-field-label",
			"tooltip=%enter-a-descriptive-field-label-that-guides-users-to-enter-the-information-you-want"
		},
		type = "key_value"
	)
	public LocalizedValue label();

	@DDMFormField(label = "%localizable")
	public boolean localizable();

	@DDMFormField(
		label = "%predefined-value",
		properties = {
			"placeholder=%enter-a-default-value",
			"tooltip=%enter-a-default-value-that-is-submitted-if-no-other-value-is-entered"
		},
		type = "text"
	)
	public LocalizedValue predefinedValue();

	@DDMFormField(label = "%read-only")
	public boolean readOnly();

	@DDMFormField(label = "%repeatable", properties = {"showAsSwitcher=true"})
	public boolean repeatable();

	@DDMFormField(
		label = "%required-field", properties = {"showAsSwitcher=true"}
	)
	public boolean required();

	@DDMFormField(
		label = "%show-label", predefinedValue = "true",
		properties = {"showAsSwitcher=true"}
	)
	public boolean showLabel();

	@DDMFormField(
		label = "%help-text",
		properties = {
			"placeholder=%enter-help-text",
			"tooltip=%add-a-comment-to-help-users-understand-the-field-label"
		},
		type = "text"
	)
	public LocalizedValue tip();

	@DDMFormField(
		dataType = "ddm-validation", label = "%validation", type = "validation"
	)
	public DDMFormFieldValidation validation();

	/**
	 * @deprecated As of 7.0.0
	 */
	@DDMFormField(
		label = "%field-visibility-expression",
		properties = {
			"placeholder=%equals(Country, \"US\")",
			"tooltip=%write-a-conditional-expression-to-control-whether-this-field-is-displayed"
		}
	)
	@Deprecated
	public String visibilityExpression();

}