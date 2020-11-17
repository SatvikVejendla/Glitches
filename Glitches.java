import javax.swing.*;
import java.awt.*;

public class Glitches {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.add(new Glitches2());
        frame.setVisible(true);
    }

}

class Glitches2 extends JComponent {
	int r = 0;
	int g = 0;
	int b = 0;
	Color c;

    Glitches2() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    repaint();
                    try {
						Thread.sleep(1);
					} catch (Exception e) {}
                }
            }
        });

        t.start();
    }

    public void paint(Graphics g) {
        Graphics2D gg = (Graphics2D) g;
		for(int i = 0; i < 800; i+=10){
			for(int j = 0; j < 400; j+=10){
				newColor();
				gg.setColor(c);
				gg.fillRect(i,j,10,10);
			}
		}



    }
    public void newColor(){
		r = (int)(Math.random()*255)+1;
		g = (int)(Math.random()*255)+1;
        b = (int)(Math.random()*255)+1;
        c = new Color(r,g,b);

	}

}