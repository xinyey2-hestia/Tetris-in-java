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



}// Piece