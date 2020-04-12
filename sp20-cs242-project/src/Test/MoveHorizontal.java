package Test;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;
import org.junit.jupiter.api.Test;

class MoveHorizontal {

	@Test
	void test() {
		int start=0;
		JFrame f = new JFrame();
	    //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TestPanel tp=new TestPanel();
	    f.getContentPane().add(tp);
	    f.setSize(400,400);
	    //f.setLocation(200,200);
	    f.setVisible(true);
	    try {
	    	Thread.sleep(2000);
	    	start=1;
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    try {
	    	tp.thispc.setSquaresXLocation(-50);
	    	tp.repaint();
	    	Thread.sleep(2000);
	    	start=1;
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    try {
	    	tp.thispc.setSquaresXLocation(50);
	    	tp.repaint();
	    	Thread.sleep(2000);
	    	start=1;
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    try {
	    	tp.thispc.setSquaresYLocation(50);
	    	tp.repaint();
	    	Thread.sleep(2000);
	    	start=1;
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    assertEquals(start,1);
	}

}
