package Test;
import javax.swing.JFrame;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Rotate {

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
	    	Thread.sleep(4000);
	    	start=1;
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    try {
	    	tp.thispc.change();
	    	tp.repaint();
	    	Thread.sleep(4000);
	    	start=1;
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    assertEquals(start,1);
	}

}
