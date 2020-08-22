package com.unitvectory.cfnddbresource;

import java.util.Map;
import java.util.Map.Entry;

import com.unitvectory.cfncustomresource.CustomResourceHandler;
import com.unitvectory.cfncustomresource.CustomResourceRequestProperties;
import com.unitvectory.cfncustomresource.CustomResourceResponseCreate;
import com.unitvectory.cfncustomresource.CustomResourceResponseDelete;
import com.unitvectory.cfncustomresource.CustomResourceResponseUpdate;

class GetItemResourceHandler extends CustomResourceHandler {

	@Override
	public CustomResourceResponseCreate processCreate(String resourceType, String logicalResourceId, String stackId,
			CustomResourceRequestProperties customResourceRequestProperties) {

		String region = customResourceRequestProperties.getStringProperty(".uvy.key.region");
		String table = customResourceRequestProperties.getStringProperty(".uvy.table");
		String keyParitionString = customResourceRequestProperties.getStringProperty(".uvy.key.partition.string");
		String keyPartitionNumber = customResourceRequestProperties.getStringProperty(".uvy.key.partition.number");
		String keySortString = customResourceRequestProperties.getStringProperty(".uvy.key.sort.string");
		String keySortNumber = customResourceRequestProperties.getStringProperty(".uvy.key.sort.number");
		String gsi = customResourceRequestProperties.getStringProperty(".uvy.gsi");
		String lsi = customResourceRequestProperties.getStringProperty(".uvy.lsi");

		// TODO: Do a better job in generating a physicalResourceId
		String physicalResourceId = logicalResourceId;

		// Perform the actual GET
		Map<String, String> attributes = null;
		try {
			attributes = this.getItem(region, table, keyParitionString, keyPartitionNumber, keySortString,
					keySortNumber, gsi, lsi);
			if (attributes == null) {
				throw new Exception("Unable to get item");
			}
		} catch (Exception e) {
			// It failed, return an error
			return CustomResourceResponseCreate.Builder
					.createError(physicalResourceId, "Unable to get item: " + e.getMessage()).build();
		}

		CustomResourceResponseCreate.Builder builder = CustomResourceResponseCreate.Builder
				.createSuccess(physicalResourceId);

		// Include all of the attribute in the response
		for (Entry<String, String> attribute : attributes.entrySet()) {
			builder.withDataString(attribute.getKey(), attribute.getValue());
		}

		return builder.build();
	}

	@Override
	public CustomResourceResponseUpdate processUpdate(String physicalResourceId, String resourceType,
			String logicalResourceId, String stackId, CustomResourceRequestProperties customResourceRequestProperties,
			CustomResourceRequestProperties customResourceRequestOldProperties) {

		String region = customResourceRequestProperties.getStringProperty(".uvy.key.region");
		String table = customResourceRequestProperties.getStringProperty(".uvy.table");
		String keyParitionString = customResourceRequestProperties.getStringProperty(".uvy.key.partition.string");
		String keyPartitionNumber = customResourceRequestProperties.getStringProperty(".uvy.key.partition.number");
		String keySortString = customResourceRequestProperties.getStringProperty(".uvy.key.sort.string");
		String keySortNumber = customResourceRequestProperties.getStringProperty(".uvy.key.sort.number");
		String gsi = customResourceRequestProperties.getStringProperty(".uvy.gsi");
		String lsi = customResourceRequestProperties.getStringProperty(".uvy.lsi");

		// Perform the actual GET
		Map<String, String> attributes = null;
		try {
			attributes = this.getItem(region, table, keyParitionString, keyPartitionNumber, keySortString,
					keySortNumber, gsi, lsi);
			if (attributes == null) {
				throw new Exception("Unable to get item");
			}
		} catch (Exception e) {
			// It failed, return an error
			return CustomResourceResponseUpdate.Builder.createError("Unable to get item: " + e.getMessage()).build();
		}

		CustomResourceResponseUpdate.Builder builder = CustomResourceResponseUpdate.Builder.createSuccess();

		// Include all of the attribute in the response
		for (Entry<String, String> attribute : attributes.entrySet()) {
			builder.withDataString(attribute.getKey(), attribute.getValue());
		}

		return builder.build();
	}

	@Override
	public CustomResourceResponseDelete processDelete(String physicalResourceId, String resourceType,
			String logicalResourceId, String stackId, CustomResourceRequestProperties customResourceRequestProperties) {

		// Do nothing

		return CustomResourceResponseDelete.Builder.createSuccess().build();
	}

	private Map<String, String> getItem(String region, String table, String keyParitionString,
			String keyPartitionNumber, String keySortString, String keySortNumber, String gsi, String lsi) {

		// TODO: Get the item

		return null;
	}
}
