package com.cisco.ci.sudo.exam;

import java.util.ArrayList;
import java.util.List;

public class SudoUtil {

	public static int getNoValueCount(int[] tempInt) {
		int noValueCount = 0;
		for (int i = 0; i < tempInt.length; i++) {
			if (tempInt[i] == 0) {
				noValueCount++;
			}
		}
		return noValueCount;
	}

	public static int[] getAvailableValueThroughPosition(int[] tempInt,
			int noValueCount) {
		int[] allowedValues = new int[noValueCount];
		int no = 0;
		for (int i = 0; i < tempInt.length; i++) {
			if (tempInt[i] == 0) {
				allowedValues[no] = i + 1;
				no++;
			}
		}
		return allowedValues;
	}

	public static int[] getCommonValues(int[] possibleValues1,
			int[] possibleValues2, int[] possbileValues3) {
		List commonInts = new ArrayList<Integer>();
		for (int i = 0; i < possibleValues1.length; i++) {
			if (isInIntArray(possibleValues1[i], possibleValues2)
					&& isInIntArray(possibleValues1[i], possbileValues3)) {
				commonInts.add(possibleValues1[i]);
			}
		}
		int[] result = new int[commonInts.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = ((Integer) commonInts.get(i)).intValue();
		}
		return result;

	}

	private static boolean isInIntArray(int pInt, int[] intArray) {
		boolean result = false;
		for (int i = 0; i < intArray.length; i++) {
			if (pInt == intArray[i]) {
				return true;
			}
		}
		return result;
	}

}
