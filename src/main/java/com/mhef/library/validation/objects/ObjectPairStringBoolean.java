package com.mhef.library.validation.objects;

/**
 * @author Henrik Beck
 * @version 0.0.3
 */
public class ObjectPairStringBoolean {
	private String stringValue;
	private boolean booleanValue;

	public ObjectPairStringBoolean(String stringValue, boolean booleanValue) {
		this.stringValue = stringValue;
		this.booleanValue = booleanValue;
	}

	public String getStringValue() {
		return stringValue;
	}

	public boolean getBooleanValue() {
		return booleanValue;
	}
}