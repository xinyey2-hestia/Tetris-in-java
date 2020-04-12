package util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import exception.GameException;
import object.Piece;
import object.Square;

public class ImageUtil {

	public static BufferedImage getImage(String imagePath) {
		try {
			return ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Img fail£º" + e.getMessage()
					+ "!", "on", JOptionPane.INFORMATION_MESSAGE);
			throw new GameException("Img fail£º" + e.getMessage());

		}
	}//getImage
	
	public static void paintPiece(Graphics g,Piece piece){
		if(piece==null)return ;	
		for(Square square:piece.getSquares()){
			g.drawImage(square.getImage(),square.getBeginX(),square.getBeginY(),null);
		}
	}
	
	
}
