package com.cisco.ci.sudo.exam;

import java.util.ArrayList;
import java.util.List;

public class SuPersonsWorld {
	private List<List<SuPerson>> suPersonsMatrix = new ArrayList<List<SuPerson>>();

	public List<List<SuPerson>> getSuPersonsMatrix() {
		return suPersonsMatrix;
	}

	public void setSuPersonsMatrix(List<List<SuPerson>> suPersonsMatrix) {
		this.suPersonsMatrix = suPersonsMatrix;
	}

	public SuPersonsWorld(int[][] sudoMatrix) {
		initSuPersonsAndRowTeam(sudoMatrix);
		initColumnTeam();
		initArea();
	}

	public void initArea() {
		for (int i = 0; i < Constants.SUDO_SQUARE_COUNT; i += 3) {
			for (int j = 0; j < Constants.SUDO_SQUARE_COUNT; j += 3) {
				createArea(i, j);
			}
		}
	}

	private void createArea(int x, int y) {
		List<List<SuPerson>> areaCells = new ArrayList<List<SuPerson>>();
		AreaTeam area = new AreaTeam(new Position(x, y), areaCells);
		for (int i = x; i < x + Constants.SUDO_COUNT; i++) {
			List cells = new ArrayList<SuPerson>();
			areaCells.add(cells);
			for (int j = y; j < y + Constants.SUDO_COUNT; j++) {
				SuPerson cell = suPersonsMatrix.get(i).get(j);
				cell.setAreaTeam(area);
				cells.add(cell);
			}
		}
	}

	public void initColumnTeam() {
		List firstRowSuPersonsList = suPersonsMatrix.get(0);
		for (int i = 0; i < firstRowSuPersonsList.size(); i++) {
			List<SuPerson> columnSuPersonsList = new ArrayList<SuPerson>();
			LineTeam columnTeam = new LineTeam(i, Constants.COLUMN_TEAM_TYPE,
					columnSuPersonsList);
			for (int j = 0; j < suPersonsMatrix.size(); j++) {
				SuPerson columnSuPerson = suPersonsMatrix.get(j).get(i);
				columnSuPerson.setColumnTeam(columnTeam);
				columnSuPersonsList.add(columnSuPerson);
			}
		}
	}

	public void initSuPersonsAndRowTeam(int[][] sudoMatrix) {
		for (int i = 0; i < sudoMatrix.length; i++) {
			List suPersons = new ArrayList<SuPerson>();
			LineTeam rowTeam = new LineTeam(i, Constants.ROW_TEAM_TYPE,
					suPersons);
			for (int j = 0; j < sudoMatrix[i].length; j++) {
				SuPerson suPerson = new SuPerson(j, i, sudoMatrix[i][j]);
				suPersons.add(suPerson);
				suPerson.setRowTeam(rowTeam);
			}
			suPersonsMatrix.add(suPersons);
		}
	}

	public SuPerson getSuPerson(int x, int y) {
		return suPersonsMatrix.get(y).get(x);
	}

	public int[][] getIntValues() {
		int[][] result = new int[Constants.SUDO_SQUARE_COUNT][];
		for (int i = 0; i < suPersonsMatrix.size(); i++) {
			result[i] = new int[Constants.SUDO_SQUARE_COUNT];
			for (int j = 0; j < suPersonsMatrix.get(i).size(); j++) {
				SuPerson cell = suPersonsMatrix.get(i).get(j);
				result[i][j] = cell.getValue();
			}
		}
		return result;
	}

}
