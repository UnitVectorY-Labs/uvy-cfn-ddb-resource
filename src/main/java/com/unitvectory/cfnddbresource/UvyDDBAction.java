package com.unitvectory.cfnddbresource;

import com.unitvectory.cfncustomresource.CustomResourceHandler;

enum UvyDDBAction {

	GetItem(new GetItemResourceHandler()),

	;

	private CustomResourceHandler resourceHandler;

	private UvyDDBAction(CustomResourceHandler resourceHandler) {
		this.resourceHandler = resourceHandler;
	}

	public CustomResourceHandler getResourceHandler() {
		return this.resourceHandler;
	}

	public static UvyDDBAction parse(String key) {
		if (key == null) {
			return null;
		}

		for (UvyDDBAction action : UvyDDBAction.values()) {
			if (key.equals(action.name())) {
				return action;
			}
		}

		return null;
	}
}
