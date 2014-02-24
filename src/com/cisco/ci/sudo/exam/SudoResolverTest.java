package com.cisco.ci.sudo.exam;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SudoResolverTest {
	private SudoI resolver = null;

	@Before
	public void setUp() throws Exception {
		resolver = new SudoResolver();
	}

	@After
	public void tearDown() throws Exception {
	}

	private int[][] example_1 = { { 1, 0, 2, 8, 6, 5, 7, 9, 4 },
			{ 0, 4, 9, 0, 7, 2, 6, 0, 5 }, { 5, 6, 7, 3, 9, 4, 1, 8, 2 },
			{ 0, 5, 6, 7, 2, 0, 9, 0, 8 }, { 2, 1, 3, 4, 8, 0, 5, 6, 7 },
			{ 9, 7, 8, 5, 1, 6, 2, 0, 3 }, { 3, 9, 5, 2, 4, 1, 0, 7, 6 },
			{ 6, 8, 0, 0, 5, 7, 3, 2, 1 }, { 7, 2, 1, 0, 3, 8, 4, 5, 0 }, };

	private int[][] example_1_result = { { 1, 3, 2, 8, 6, 5, 7, 9, 4 },
			{ 8, 4, 9, 1, 7, 2, 6, 3, 5 }, { 5, 6, 7, 3, 9, 4, 1, 8, 2 },
			{ 4, 5, 6, 7, 2, 3, 9, 1, 8 }, { 2, 1, 3, 4, 8, 9, 5, 6, 7 },
			{ 9, 7, 8, 5, 1, 6, 2, 4, 3 }, { 3, 9, 5, 2, 4, 1, 8, 7, 6 },
			{ 6, 8, 4, 9, 5, 7, 3, 2, 1 }, { 7, 2, 1, 6, 3, 8, 4, 5, 9 }, };

	@Test
	public void testFigureOut() {
		int[][] result = resolver.figureOut(example_1);
		TestUtil.assertEquals(example_1_result, result);
	}

	@Test
	public void testFigureOutJojoExamples() {
		testFigureoutThroughIntArrayList(Example.easyList, Example.exampleList);
		testFigureoutThroughIntArrayList(Example.normalList,
				Example.exampleList);
		testFigureoutThroughIntArrayList(Example.hardList, Example.exampleList);
		testFigureoutThroughIntArrayList(Example.evilList, Example.exampleList);

	}

	private void testFigureoutThroughIntArrayList(List<int[][]> list,
			List<int[][]> result) {
		for (int i = 0; i < list.size(); i++) {
			if (i == 1) {
				continue;
			}
			int[][] resultInts = resolver.figureOut(list.get(i));
			TestUtil.assertEquals(result.get(i), resultInts);
		}
	}

	@Test
	public void testFigureOutExample2Evil() {
		SudoResolver resolver = new SudoResolver();
		int[][] result = resolver.figureOut(Example.example_2_evil);
		int[][] evil2_result = { { 5, 2, 3, 7, 1, 8, 4, 6, 9 },
				{ 7, 9, 4, 5, 2, 6, 1, 8, 3 }, { 6, 1, 8, 3, 4, 9, 2, 7, 5 },
				{ 3, 4, 5, 1, 7, 2, 8, 9, 6 }, { 2, 8, 9, 6, 3, 5, 7, 4, 1 },
				{ 1, 7, 6, 8, 9, 4, 5, 3, 2 }, { 8, 5, 1, 9, 6, 7, 3, 2, 4 },
				{ 4, 6, 7, 2, 5, 3, 9, 1, 8 }, { 9, 3, 2, 4, 8, 1, 6, 5, 7 } };
		TestUtil.assertEquals(evil2_result, result);
	}

}
