package object;

import java.util.*;


public class Piece {
	protected List<Square> squares;
	protected List<List<Square>> changes = new ArrayList<List<Square>>();

	Random random = new Random();
	private int currentIndex = 0;
	public static final int SQUARE_BORDER = 16;

	public List<Square> getSquares() {
		return this.squares;
	}

	public void setSquares(List<Square> squares) {
		this.squares = squares;
	}

	public List<Square> getDefault() {
		this.currentIndex = random.nextInt(changes.size());
		return this.changes.get(this.currentIndex);
	}

	public void change() {
		if (this.changes.size() <= 0)
			return;
		this.currentIndex++;
		if (this.currentIndex >= this.changes.size())
			this.currentIndex = 0;
		this.squares = this.changes.get(this.currentIndex);
	}


	public void setSquaresXLocation(int x) {
		for (List<Square> squares : this.changes) {
			for (Square square : squares) {
				square.setBeginX(square.getBeginX() + x);
			}
		}
	}


	public void setSquaresYLocation(int y) {
		for (List<Square> squares : this.changes) {
			for (Square square : squares) {
				square.setBeginY(square.getBeginY() + y);
			}
		}
	}

	public int getMinXLocation() {
		int result = Integer.MAX_VALUE;
		for (Square square : this.squares) {
			if (square.getBeginX() < result)
				result = square.getBeginX();
		}
		return result;
	}

	public int getMaxXLocation() {
		int result = Integer.MIN_VALUE;
		for (Square square : this.squares) {
			if (square.getBeginX() > result)
				result = square.getBeginX();
		}
		return result;
	}
	
	public int getMaxYLocation() {
		int result = Integer.MIN_VALUE;
		for (Square square : this.squares) {
			if (square.getBeginY() > result)
				result = square.getBeginY();
		}
		return result + SQUARE_BORDER;
	}

	public int getMinYLocation() {
		int result = Integer.MAX_VALUE;
		for (Square square : this.squares) {
			if (square.getBeginY() < result)
				result = square.getBeginY();
		}
		return result + SQUARE_BORDER;
	}


}// Piece