package com.cisco.ci.sudo.exam;

import java.util.Comparator;

public class PossbileValuesCountComparator implements Comparator {
	public int compare(Object arg0, Object arg1) {
		return ((SuPerson) arg0).getPossibleValues().length
				- ((SuPerson) arg1).getPossibleValues().length;
	}
}
