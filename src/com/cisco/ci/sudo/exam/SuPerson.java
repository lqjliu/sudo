package com.cisco.ci.sudo.exam;

public class SuPerson {
	private Position position;
	private int value;
	private LineTeam rowTeam;

	public LineTeam getRowTeam() {
		return rowTeam;
	}

	public void setRowTeam(LineTeam rowTeam) {
		this.rowTeam = rowTeam;
	}

	private LineTeam columnTeam;

	public LineTeam getColumnTeam() {
		return columnTeam;
	}

	public void setColumnTeam(LineTeam columnTeam) {
		this.columnTeam = columnTeam;
	}

	public SuPerson(int x, int y, int value) {
		this.position = new Position(x, y);
		this.value = value;
	}

	private AreaTeam areaTeam;

	public AreaTeam getAreaTeam() {
		return areaTeam;
	}

	public void setAreaTeam(AreaTeam areaTeam) {
		this.areaTeam = areaTeam;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String toString() {
		return position + " value = " + value;
	}

	public int[] getPossibleValues() {
		return SudoUtil.getCommonValues(rowTeam.getAvailableValues(),
				columnTeam.getAvailableValues(), areaTeam.getAvailableValues());
	}
	
	public int positionOfPossibleValue;

	public int getPositionOfPossibleValue() {
		return positionOfPossibleValue;
	}

	public void setPositionOfPossibleValue(int positionOfPossibleValue) {
		this.positionOfPossibleValue = positionOfPossibleValue;
	}
}
