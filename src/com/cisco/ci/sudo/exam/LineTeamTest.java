package com.cisco.ci.sudo.exam;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LineTeamTest {

	private LineTeam testLineTeam = null;
	private int[] testInts = { 6, 0, 9, 5, 2, 0, 7, 0, 1 };
	private static final int TEST_INDEX = 2;

	@Before
	public void setUp() throws Exception {
		List<SuPerson> testList = new ArrayList<SuPerson>();
		testLineTeam = new LineTeam(5, Constants.COLUMN_TEAM_TYPE, testList);
		for (int i = 0; i < testInts.length; i++) {
			testList.add(new SuPerson(i, TEST_INDEX, testInts[i]));
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllowedValue() {
		int[] allowedValues = testLineTeam.getAvailableValues();
		int[] result = new int[] { 3, 4, 8 };
		TestUtil.assertEquals(allowedValues, result);
	}

	@Test
	public void testGetLineValues() {
		int[] lineValues = testLineTeam.getLineValues();
		int[] result = new int[] { 6, 0, 9, 5, 2, 0, 7, 0, 1 };
		TestUtil.assertEquals(lineValues, result);
	}

}
