package com.cisco.ci.sudo.exam;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SuPersonsWorldTest {

	private int[][] example_1 = { { 1, 0, 2, 8, 6, 5, 7, 9, 4 },
			{ 0, 4, 9, 0, 7, 2, 6, 0, 5 }, { 5, 6, 7, 3, 9, 4, 1, 8, 2 },
			{ 0, 5, 6, 7, 2, 0, 9, 0, 8 }, { 2, 1, 3, 4, 8, 0, 5, 6, 7 },
			{ 9, 7, 8, 5, 1, 6, 2, 0, 3 }, { 3, 9, 5, 2, 4, 1, 0, 7, 6 },
			{ 6, 8, 0, 0, 5, 7, 3, 2, 1 }, { 7, 2, 1, 0, 3, 8, 4, 5, 0 }, };

	private SuPersonsWorld suPersonsWorld;

	@Before
	public void setUp() throws Exception {
		suPersonsWorld = new SuPersonsWorld(example_1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetIntValues() {
		int[][] values = suPersonsWorld.getIntValues();
		TestUtil.assertEquals(example_1, values);
	}

	@Test
	public void testGetSuPerson() {
		for (int i = 0; i < example_1.length; i++) {
			for (int j = 0; j < example_1[i].length; j++) {
				testSuPersonTeams(j, i);
			}
		}

	}

	private void testSuPersonTeams(int x, int y) {
		SuPerson testSuPerson = suPersonsWorld.getSuPerson(x, y);
		assertEquals(testSuPerson.getPosition(), new Position(x, y));
		assertEquals(testSuPerson.getPosition().getY(), testSuPerson
				.getRowTeam().getIndex());
		assertEquals(testSuPerson.getPosition().getX(), testSuPerson
				.getColumnTeam().getIndex());
		int[] rowTeamInts = testSuPerson.getRowTeam().getLineValues();
		TestUtil.assertEquals(rowTeamInts, example_1[y]);
		int[] originalColumnInts = getOriginalColumnInts(x);
		TestUtil.assertEquals(originalColumnInts, testSuPerson.getColumnTeam()
				.getLineValues());
		int[][] areaIntsForPosition = getAreaInts(x, y);
		TestUtil.assertEquals(areaIntsForPosition, testSuPerson.getAreaTeam()
				.getAreaValues());
	}

	private int[] getOriginalColumnInts(int x) {
		int[] originalColumnInts = new int[Constants.SUDO_SQUARE_COUNT];
		for (int i = 0; i < Constants.SUDO_SQUARE_COUNT; i++) {
			originalColumnInts[i] = example_1[i][x];
		}
		return originalColumnInts;
	}

	private int[][] getAreaInts(int x, int y) {
		int[][] result = new int[Constants.SUDO_COUNT][Constants.SUDO_COUNT];
		x = getStartPoint(x);
		y = getStartPoint(y);
		for (int i = y; i < y + Constants.SUDO_COUNT; i++) {
			for (int j = x; j < x + Constants.SUDO_COUNT; j++) {
				result[i - y][j - x] = example_1[i][j];
			}
		}
		return result;

	}

	private int getStartPoint(int x) {
		if (x >= 0 && x < 3) {
			x = 0;
		}
		if (x >= 3 && x < 6) {
			x = 3;
		}
		if (x >= 6 && x < 9) {
			x = 6;
		}
		return x;
	}

}
