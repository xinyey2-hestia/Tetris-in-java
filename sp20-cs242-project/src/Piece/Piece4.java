package Piece;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import object.Piece;
import object.Square;

//row
public class Piece4 extends Piece {
	public Piece4(Image image) {
		// row
		List<Square> squares0 = new ArrayList<Square>();
		squares0.add(new Square(image, 0, image.getHeight(null)));
		squares0.add(new Square(image, image.getWidth(null), image
				.getHeight(null)));
		squares0.add(new Square(image, image.getWidth(null) * 2, image
				.getHeight(null)));
		squares0.add(new Square(image, image.getWidth(null) * 3, image
				.getHeight(null)));

		// col
		List<Square> squares1 = new ArrayList<Square>();
		squares1.add(new Square(image, image.getWidth(null), 0));
		squares1.add(new Square(image, image.getWidth(null), image
				.getHeight(null)));
		squares1.add(new Square(image, image.getWidth(null), image
				.getHeight(null) * 2));
		squares1.add(new Square(image, image.getWidth(null), image
				.getHeight(null) * 3));

		super.changes.add(squares0);
		super.changes.add(squares1);
		super.setSquares(getDefault());
	}// constructor
}// end of class