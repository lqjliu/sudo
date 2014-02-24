package com.cisco.ci.sudo.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SudoResolver implements SudoI {
	List<SuPerson> needFiguredSuPersons = null;
	SuPersonsWorld suPersonWorld = null;

	public int[][] figureOut(int[][] sudo) {
		suPersonWorld = new SuPersonsWorld(sudo);
		List<List<SuPerson>> suPersonsMatrix = suPersonWorld
				.getSuPersonsMatrix();
		needFiguredSuPersons = getNeedFiguredOutSuPerson(suPersonsMatrix);

		initOnlyOnePossibleValue(suPersonsMatrix);

		if (needFiguredSuPersons.size() > 0) {
			treatSuPersonWithExceeding2PossbileValue(needFiguredSuPersons);
		}

		int[][] result = suPersonWorld.getIntValues();
		return result;
	}

	private void initOnlyOnePossibleValue(List<List<SuPerson>> suPersonsMatrix) {
		while (hasOnlyOnePossbileValues()) {
			for (int i = 0; i < needFiguredSuPersons.size(); i++) {
				if (needFiguredSuPersons.get(i).getPossibleValues().length == 1) {
					needFiguredSuPersons.get(i).setValue(
							needFiguredSuPersons.get(i).getPossibleValues()[0]);
				}
			}
			needFiguredSuPersons = getNeedFiguredOutSuPerson(suPersonsMatrix);
		}
	}

	private boolean hasOnlyOnePossbileValues() {
		boolean hasOnePossbileValue = false;
		for (int i = 0; i < needFiguredSuPersons.size(); i++) {
			if (needFiguredSuPersons.get(i).getPossibleValues().length == 1) {
				hasOnePossbileValue = true;
			}
		}
		return hasOnePossbileValue;
	}

	private List<SuPerson> getNeedFiguredOutSuPerson(
			List<List<SuPerson>> suPersonsMatrix) {
		List<SuPerson> result = new ArrayList<SuPerson>();
		for (int i = 0; i < suPersonsMatrix.size(); i++) {
			for (int j = 0; j < suPersonsMatrix.get(i).size(); j++) {
				SuPerson suPerson = suPersonsMatrix.get(i).get(j);
				if (suPerson.getValue() == 0) {
					result.add(suPerson);
				}
			}
		}
		Collections.sort(result, new PossbileValuesCountComparator());
		return result;
	}

	private int currentSuPersonIndex = 0;

	private void treatSuPersonWithExceeding2PossbileValue(List<SuPerson> list) {
		if (list.size() > 1) {
			SuPerson suPerson = list.get(0);
			suPerson.setValue(0);
			int[] pValues = suPerson.getPossibleValues();
			int currentPos = suPerson.getPositionOfPossibleValue();
			if (currentSuPersonIndex == 0 && currentPos >= pValues.length) {
				throw new RuntimeException("this data is wrong");
			}
			if (pValues.length == 0 || currentPos >= pValues.length) {
				rollbackLast(list, suPerson);
			} else {
				setSuitableValueAndJumpNext(list, suPerson, pValues);
			}
		} else {
			jumpLastSuPerson(list);
		}
	}

	private void jumpLastSuPerson(List<SuPerson> list) {
		SuPerson suPerson = list.get(0);
		int[] pValues = suPerson.getPossibleValues();
		if (pValues.length == 0) {
			rollbackLast(list, suPerson);
		} else {
			suPerson.setValue(pValues[0]);
		}
	}

	private void setSuitableValueAndJumpNext(List<SuPerson> list,
			SuPerson suPerson, int[] pValues) {
		suPerson.setValue(pValues[suPerson.getPositionOfPossibleValue()]);
		suPerson.setPositionOfPossibleValue(suPerson
				.getPositionOfPossibleValue() + 1);
		List<SuPerson> others = new ArrayList<SuPerson>();
		for (int i = 1; i < list.size(); i++) {
			others.add(list.get(i));
		}
		currentSuPersonIndex++;
		treatSuPersonWithExceeding2PossbileValue(others);
	}

	private void rollbackLast(List<SuPerson> list, SuPerson suPerson) {
		suPerson.setPositionOfPossibleValue(0);
		suPerson.setValue(0);
		currentSuPersonIndex--;
		List<SuPerson> others = new ArrayList<SuPerson>();
		others.add(needFiguredSuPersons.get(currentSuPersonIndex));
		others.addAll(list);
		treatSuPersonWithExceeding2PossbileValue(others);
	}

}
