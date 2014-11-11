package theaquarium;

public class ThredSound implements Runnable {
    
    @Override
    public void run() {
        TheAquarium.a.loop();
    }
}
