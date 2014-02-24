package com.cisco.ci.sudo.exam;

import static org.junit.Assert.fail;

public class TestUtil {
	public static void assertEquals(int[] origianl, int[] target) {
		if (origianl.length != target.length) {
			fail("Not yet implemented");
		}
		for (int i = 0; i < origianl.length; i++) {
			if (origianl[i] != target[i]) {
				fail("Not yet implemented");
			}
		}
	}

	public static void assertEquals(int[][] origianl, int[][] target) {
		if (origianl.length != target.length) {
			fail("Not yet implemented");
		}
		for (int i = 0; i < origianl.length; i++) {
			assertEquals(origianl[i], target[i]);
		}
	}

	public static void print(int[][] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.println();
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + ",");
			}
		}
	
	}
}
