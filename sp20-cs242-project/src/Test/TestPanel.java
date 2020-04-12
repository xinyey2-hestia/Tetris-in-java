package Test;

import java.awt.Graphics;
import javax.swing.JPanel;
import PieceCreator.PieceCreatorImpl;
import object.Piece;
import util.ImageUtil;
public class TestPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PieceCreatorImpl pc=new PieceCreatorImpl();
	Piece thispc=pc.createPiece(250, 150);
	Piece second = pc.createPiece(100, 50);
	Piece thirdd = pc.createPiece(50, 50);
	Piece fourth = pc.createPiece(10, 20);
	Piece fifth = pc.createPiece(200, 10);
	Piece sixth = pc.createPiece(300, 80);
	Piece last = pc.createPiece(150, 80);
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		ImageUtil.paintPiece(g, thispc);
		ImageUtil.paintPiece(g, second);
		ImageUtil.paintPiece(g, fourth);
		ImageUtil.paintPiece(g, fifth);
		ImageUtil.paintPiece(g, sixth);
		ImageUtil.paintPiece(g, thirdd);
		ImageUtil.paintPiece(g, last);
	}	
}
