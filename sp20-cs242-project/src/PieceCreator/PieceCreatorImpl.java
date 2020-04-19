package PieceCreator;


import java.awt.Image;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import object.Piece;
import object.PieceCreator;
import Piece.Piece0;
import Piece.Piece1;
import Piece.Piece2;
import Piece.Piece3;
import Piece.Piece4;
import Piece.Piece5;
import Piece.Piece6;
import util.ImageUtil;

public class PieceCreatorImpl implements PieceCreator {

	static private final int AMOUNTOFSQUARE = 7;
	static private final int AMOUNTOFCOLOR = 7;
	static private Map<Integer, Image> images = new HashMap<Integer, Image>();
	static {
		for (int i = 0; i < AMOUNTOFSQUARE ; i++) {
			images.put(
					i,
					ImageUtil.getImage("resource" + File.separator + "images"
							+ File.separator + "square" + i + ".jpg"));
		}
	}

	private Random random = new Random();

	// create random piece on given coordinate
	public Piece createPiece(int x, int y) {

		Piece piece = initPiece(getImage(random.nextInt(AMOUNTOFCOLOR)));
		piece.setSquaresXLocation(x);
		piece.setSquaresYLocation(y);
		return piece;
	}



	private Image getImage(int key) {
		return images.get(key);
	}
// Give each piece its unique color
	private Piece initPiece(Image image) {
		int pieceType = random.nextInt(AMOUNTOFSQUARE);
		switch (pieceType) {
		case 0:
			return new Piece0(images.get(pieceType));
		case 1:
			return new Piece1(images.get(pieceType));
		case 2:
			return new Piece2(images.get(pieceType));
		case 3:
			return new Piece3(images.get((pieceType)));
		case 4:
			return new Piece4(images.get(pieceType));
		case 5:
			return new Piece5(images.get(pieceType));
		case 6:
			return new Piece6(images.get(pieceType));

		}
		return null;

	}

}