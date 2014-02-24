package com.cisco.ci.sudo.exam;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AreaTeamTest {
	private AreaTeam areaTest;

	private int[][] testInts = { { 7, 0, 9 }, { 0, 5, 6 }, { 0, 1, 2 } };

	@Before
	public void setUp() throws Exception {
		List<List<SuPerson>> cellLists = new ArrayList<List<SuPerson>>();
		for (int i = 0; i < testInts.length; i++) {
			List<SuPerson> list1 = new ArrayList<SuPerson>();
			for (int j = 0; j < testInts[i].length; j++) {
				list1.add(new SuPerson(j, i, testInts[i][j]));
			}
			cellLists.add(list1);
		}
		Position p = new Position(0, 0);
		areaTest = new AreaTeam(p, cellLists);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllowedValue() {
		int[] allowedValues = areaTest.getAvailableValues();
		int[] result = new int[] { 3, 4, 8 };
		TestUtil.assertEquals(allowedValues, result);
	}

	@Test
	public void testGetAreaValue() {
		int[][] areaValues = areaTest.getAreaValues();
		TestUtil.assertEquals(areaValues, testInts);
	}
}
