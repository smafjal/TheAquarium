
package theaquarium;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Fish {

    Image img1, img2;
    int x, y, wid, hig, MW, MH, MnW, MnH, pw, ph;
    boolean direction, scale;
    int SleepTime = 5;
    int moveStep;
    int RR;

    public Fish(String s1, String s2) {
        img1 = Toolkit.getDefaultToolkit().getImage(s1);
        img2 = Toolkit.getDefaultToolkit().getImage(s2);
        direction = false;
        scale = false;
        double g = Math.random() * 100000;
        int R = (int) g;
        x = R % 900;
        y = Math.max(animation.MinY, R % 700);
        moveStep = R % 100;

        ImageIcon icon = new ImageIcon(img1);

        wid = icon.getIconWidth();
        hig = icon.getIconHeight();
        pw = wid;
        ph = hig;
        MW = wid * 2; MH = hig * 2;
        MnW = wid / 4; MnH = hig / 4;

        //System.out.println("Fish Created: " + s1 + "  Wid: " + wid + " height: " + hig);

    }

    public void MoveFish() {
        moveStep--;
        if (moveStep <= 0 && scale == false) {
            double g = Math.random() * 100000;
            int R = (int) g;

            RR = R % 6;
            if (RR == 3 || RR == 2) {
                moveStep = R % 20;
            } else if (RR == 0) {
                if (x > 600) {

                    moveStep = 300;
                } else {
                    moveStep = R % 150;
                }

            } else if (RR == 1) {
                if (x < 200) {
                    moveStep = 300;
                } else {
                    moveStep = R % 150;
                }
            } else if (RR == 4) {
                scale = true;
                pw = wid;
                ph = hig;
                wid *= 2; hig *= 2;
                wid = Math.min(wid, MW); hig = Math.min(hig, MH);

            } else if (RR == 5) {
                scale = true;
                pw = wid;
                ph = hig;
                wid /= 2; hig /= 2;
                wid = Math.max(wid, MnW); hig = Math.max(hig, MnH);
            } else {
                moveStep = R % 150;
            }
        }

        // System.out.println("RR = "+RR+"  and MoveStep = "+moveStep);

        if (RR == 0) {
            x--;
            x = Math.max(x, animation.MinX);
            direction = false;
        } else if (RR == 1) {
            x++;
            x = Math.min(x, animation.MaxX);
            direction = true;
        } else if (RR == 2) {
            y++;
            y = Math.min(y, animation.MaxY);

        } else if (RR == 3) {
            y--;
            y = Math.max(--y, animation.MinY);
        } else if (RR == 4) {
            pw++;
            ph++;
            if (pw > wid || ph > hig) {
                scale = false;
            }


        } else if (RR == 5) {
            pw--;
            ph--;
            if (pw < wid || ph < hig) {
                scale = false;
            }
        }

        try {
            Thread.sleep(SleepTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fish.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

