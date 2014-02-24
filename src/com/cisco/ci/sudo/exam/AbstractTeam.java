package com.cisco.ci.sudo.exam;

public abstract class AbstractTeam implements Team {

	public int[] getAvailableValues() {
		int[] tempInt = getIntArrayBasedValueAsPosition();
		int noValueCount = SudoUtil.getNoValueCount(tempInt);
		int[] allowedValues = SudoUtil.getAvailableValueThroughPosition(tempInt,
				noValueCount);
		return allowedValues;
	}

	protected abstract int[] getIntArrayBasedValueAsPosition();

}
