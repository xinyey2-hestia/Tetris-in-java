package Piece;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import object.Piece;
import object.Square;
//O-block 
public class Piece0 extends Piece {

	public Piece0(Image image) {
		List<Square> squares = new ArrayList<Square>();
		squares.add(new Square(image, 0, 0));
		squares.add(new Square(image, 0, image.getHeight(null)));
		squares.add(new Square(image, image.getWidth(null), 0));
		squares.add(new Square(image, image.getWidth(null), image
				.getHeight(null)));
		super.changes.add(squares);
		super.setSquares(squares);

	}

}
