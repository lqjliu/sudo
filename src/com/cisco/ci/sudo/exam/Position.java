package com.cisco.ci.sudo.exam;

public class Position {
	private int x;
	private int y;

	public Position() {
	};

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return "x = " + x + " y = " + y;
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof Position)) {
			return false;
		}
		Position p = (Position) o;
		boolean result = true;
		if (p.getX() != this.x) {
			result = false;
		}
		if (p.getY() != this.y) {
			result = false;
		}
		return result;
	}

}
