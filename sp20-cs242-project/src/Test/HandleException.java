package Test;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;
import PieceCreator.PieceCreatorImpl;
import object.Piece;
import util.ImageUtil;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HandleException {

	@Test
	void test() {
		boolean thrown = false;
		try {
			BufferedImage test = ImageUtil.getImage("justtest");
		  } catch (Exception e) {
		    thrown = true;
		  }
		
		assertEquals(thrown,true);
	}

}
