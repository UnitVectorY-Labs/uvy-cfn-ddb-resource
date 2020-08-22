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

		// TODO Implement

		return CustomResourceResponseCreate.Builder.createSuccess(logicalResourceId).build();
	}

	@Override
	public CustomResourceResponseUpdate processUpdate(String physicalResourceId, String resourceType,
			String logicalResourceId, String stackId, CustomResourceRequestProperties customResourceRequestProperties,
			CustomResourceRequestProperties customResourceRequestOldProperties) {

		// TODO Implement

		return CustomResourceResponseUpdate.Builder.createSuccess().build();
	}

	@Override
	public CustomResourceResponseDelete processDelete(String physicalResourceId, String resourceType,
			String logicalResourceId, String stackId, CustomResourceRequestProperties customResourceRequestProperties) {

		// TODO Implement

		return CustomResourceResponseDelete.Builder.createSuccess().build();
	}
}
