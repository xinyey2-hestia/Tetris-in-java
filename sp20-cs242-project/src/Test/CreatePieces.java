package Test;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Test.TestPanel;
class CreatePieces {

	@Test
	void test() {
		int start=0;
		JFrame f = new JFrame();
	    //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.getContentPane().add(new TestPanel());
	    f.setSize(400,400);
	    //f.setLocation(200,200);
	    f.setVisible(true);
	    try {
	    	Thread.sleep(4000);
	    	start=1;
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    assertEquals(start,1);
	}

}
