package theaquarium;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class animation extends JFrame implements Runnable {

    public static int MaxX = 1050, MinX = -50, MaxY = 750, MinY = 150;
    public static int MaxFish = 10, numberOfFish = 6;
    private Image dbImage;
    private Graphics dbg;
    private final Image bud1, bud2, background, myname;
    private Fish fish[] = new Fish[MaxFish];

    public animation() {
        super("Aquarium");
        setSize(1000, 650);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        bud1 = Toolkit.getDefaultToolkit().getImage("images/budbud.gif");
        bud2 = Toolkit.getDefaultToolkit().getImage("images/budbud2.gif");
        background = Toolkit.getDefaultToolkit().getImage("images/background2.gif");
        myname = Toolkit.getDefaultToolkit().getImage("images/MyName.gif");

        for (int i = 0; i < numberOfFish; i++) {
            int k = i + 1;
            fish[i] = new Fish("images/fish" + String.valueOf(k) + ".gif", "images/fish" + String.valueOf(k) + "m.gif");
        }
    }

    @Override
    public void paint(Graphics g) {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);

        //System.exit(0);
    }

    private void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, this);
        g.drawImage(bud2, 500, 400, this);
        g.drawImage(bud2, 750, 150, this);
        g.drawImage(bud2, 200, 200, this);
        g.drawImage(myname, 810, 30, this);
        for (int i = 0; i < numberOfFish; i++) {
            fish[i].MoveFish();
            if (fish[i].scale == true && fish[i].direction == false) {
                g.drawImage(fish[i].img1, fish[i].x, fish[i].y, fish[i].pw, fish[i].ph, this);
            } else if (fish[i].scale == true && fish[i].direction == true) {
                g.drawImage(fish[i].img2, fish[i].x, fish[i].y, fish[i].pw, fish[i].ph, this);
            }
            if (fish[i].direction == false) {
                g.drawImage(fish[i].img1, fish[i].x, fish[i].y, fish[i].pw, fish[i].ph, this);
            } else {
                g.drawImage(fish[i].img2, fish[i].x, fish[i].y, fish[i].pw, fish[i].ph, this);
            }
        }
        repaint();
    }

    @Override
    public void run() {
    }
}
  
