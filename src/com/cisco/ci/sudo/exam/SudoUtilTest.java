package com.cisco.ci.sudo.exam;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudoUtilTest {

	@Test
	public void testGetCommonValues() {
		int[] possibleValues1 = new int[] { 2, 7, 6, 9 };
		int[] possibleValues2 = new int[] { 1, 2, 4, 8, 9 };
		int[] possibleValues3 = new int[] { 2, 3, 4, 5, 6, 8, 9 };
		int[] commonValues = SudoUtil.getCommonValues(possibleValues3,
				possibleValues1, possibleValues2);
		int[] expectedResult = { 2, 9 };
		TestUtil.assertEquals(commonValues, expectedResult);
	}

}
