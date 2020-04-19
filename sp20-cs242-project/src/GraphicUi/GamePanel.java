package GraphicUi;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.JPanel;

import object.Piece;
import object.Square;
import util.ImageUtil;

class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	MainFrame mainframe;
	private Image bankgroundImage = ImageUtil.getImage("resource"
			+ File.separator + "images" + File.separator
			+ "backgroundImage.jpg");

	public GamePanel(MainFrame mainFrame) {
		this.mainframe = mainFrame;
		this.setPreferredSize(new Dimension());
	}

	public void paint(Graphics g) {
		g.drawImage(this.bankgroundImage, 0, 0, this.getWidth(),
				this.getHeight(), null);

		Piece currentPiece = this.mainframe.getCurrentPiece();
		ImageUtil.paintPiece(g, currentPiece);

		Square[][] squares = this.mainframe.getSquares();
		if (squares == null) {
			return;// 
		}



	}

}