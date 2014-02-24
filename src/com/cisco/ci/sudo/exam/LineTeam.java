package com.cisco.ci.sudo.exam;

import java.util.ArrayList;
import java.util.List;

public class LineTeam extends AbstractTeam {

	private int index;
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	private List<SuPerson> cellList = new ArrayList<SuPerson>();
	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public LineTeam(int index, int type, List<SuPerson> list) {
		this.index = index;
		this.type = type;
		this.cellList = list;
	}

	protected int[] getIntArrayBasedValueAsPosition() {
		int[] tempInt = new int[Constants.SUDO_SQUARE_COUNT];
		for (int i = 0; i < cellList.size(); i++) {
			SuPerson cell = cellList.get(i);
			if (cell.getValue() != 0) {
				tempInt[cell.getValue() - 1] = 1;
			}
		}
		return tempInt;
	}

	public int[] getLineValues() {
		int[] values = new int[Constants.SUDO_SQUARE_COUNT];
		for (int i = 0; i < cellList.size(); i++) {
			SuPerson cell = cellList.get(i);
			values[i] = cell.getValue();
		}
		return values;
	}

}
