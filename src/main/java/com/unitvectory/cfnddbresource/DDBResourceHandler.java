package com.unitvectory.cfnddbresource;

import com.unitvectory.cfncustomresource.CustomResourceConfig;
import com.unitvectory.cfncustomresource.CustomResourceHandler;
import com.unitvectory.cfncustomresource.CustomResourceRequestProperties;
import com.unitvectory.cfncustomresource.CustomResourceResponseCreate;
import com.unitvectory.cfncustomresource.CustomResourceResponseDelete;
import com.unitvectory.cfncustomresource.CustomResourceResponseUpdate;

public class DDBResourceHandler extends CustomResourceHandler {

	public DDBResourceHandler() {
		super(CustomResourceConfig.Builder.create().build());
	}

	@Override
	public CustomResourceResponseCreate processCreate(String resourceType, String logicalResourceId, String stackId,
			CustomResourceRequestProperties customResourceRequestProperties) {

		String uvyAction = customResourceRequestProperties.getStringProperty(".uvy.action");
		UvyDDBAction action = UvyDDBAction.parse(uvyAction);

		if (action != null) {
			return action.getResourceHandler().processCreate(resourceType, logicalResourceId, stackId,
					customResourceRequestProperties);
		}

		return CustomResourceResponseCreate.Builder.createError(logicalResourceId, "Unknown .uvy.action: " + uvyAction)
				.build();
	}

	@Override
	public CustomResourceResponseUpdate processUpdate(String physicalResourceId, String resourceType,
			String logicalResourceId, String stackId, CustomResourceRequestProperties customResourceRequestProperties,
			CustomResourceRequestProperties customResourceRequestOldProperties) {

		String uvyAction = customResourceRequestProperties.getStringProperty(".uvy.action");
		UvyDDBAction action = UvyDDBAction.parse(uvyAction);

		if (action != null) {
			return action.getResourceHandler().processUpdate(physicalResourceId, resourceType, logicalResourceId,
					stackId, customResourceRequestProperties, customResourceRequestOldProperties);
		}

		return CustomResourceResponseUpdate.Builder.createError("Unknown .uvy.action: " + uvyAction).build();

	}

	@Override
	public CustomResourceResponseDelete processDelete(String physicalResourceId, String resourceType,
			String logicalResourceId, String stackId, CustomResourceRequestProperties customResourceRequestProperties) {

		String uvyAction = customResourceRequestProperties.getStringProperty(".uvy.action");
		UvyDDBAction action = UvyDDBAction.parse(uvyAction);

		if (action != null) {
			return action.getResourceHandler().processDelete(physicalResourceId, resourceType, logicalResourceId,
					stackId, customResourceRequestProperties);
		}

		return CustomResourceResponseDelete.Builder.createError("Unknown .uvy.action: " + uvyAction).build();
	}
}
