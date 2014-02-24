package com.cisco.ci.sudo.exam;

import java.util.List;

public class AreaTeam extends AbstractTeam {

	private Position position;

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	private List<List<SuPerson>> cellLists;

	public AreaTeam(Position postion, List<List<SuPerson>> cells) {
		this.position = position;
		this.cellLists = cells;
	}

	protected int[] getIntArrayBasedValueAsPosition() {
		int[] tempInt = new int[Constants.SUDO_SQUARE_COUNT];
		for (int i = 0; i < cellLists.size(); i++) {
			for (int j = 0; j < cellLists.get(i).size(); j++) {
				SuPerson cell = cellLists.get(i).get(j);
				if (cell.getValue() != 0) {
					tempInt[cell.getValue() - 1] = 1;
				}
			}
		}
		return tempInt;
	}

	public int[][] getAreaValues() {
		int[][] result = new int[Constants.SUDO_COUNT][];
		for (int i = 0; i < cellLists.size(); i++) {
			result[i] = new int[Constants.SUDO_COUNT];
			for (int j = 0; j < cellLists.get(i).size(); j++) {
				SuPerson cell = cellLists.get(i).get(j);
				result[i][j] = cell.getValue();
			}
		}
		return result;
	}

}
