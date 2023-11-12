package com.mhef.library.validation.objects;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Henrik Beck
 * @version 0.0.3
 */
class ObjectPairStringBooleanTest {
	private static List<ObjectPairStringBoolean> pairs = new ArrayList<>();

	@BeforeAll
	static void setupLoadVariables() {
		pairs.add(new ObjectPairStringBoolean("foo", true));
		pairs.add(new ObjectPairStringBoolean("bar", false));
	}

	@Test
	void getStringValue() {
		assertEquals(pairs.get(0).getStringValue(), "foo");
		assertEquals(pairs.get(1).getStringValue(), "bar");
	}

	@Test
	void getBooleanValue() {
		assertEquals(pairs.get(0).getBooleanValue(), true);
		assertEquals(pairs.get(1).getBooleanValue(), false);
	}
}