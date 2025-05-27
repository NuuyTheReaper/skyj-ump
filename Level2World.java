// Level2World.java
import greenfoot.*;
import java.util.List;

public class Level2World extends World {
    private int poin = 0;
    private int targetPoin = 200; // Lebih tinggi dari level 1
    private Counter poinCounter;

    public Level2World() {
        super(600, 1400, 1); // Lebih tinggi dari level 1
        prepare();
    }

    private void prepare() {
        Player player = new Player();
        addObject(player, getWidth() / 2, getHeight() - 100);
        addObject(new Platform(), 300, getHeight() - 15); // Platform dasar

        // Platform level 2 (lebih jarang)
        Platform p1 = new pijakan(); addObject(p1, 150, 1200);
        Platform p2 = new pijakan(); addObject(p2, 400, 1080);
        Platform p3 = new pijakan(); addObject(p3, 200, 950);
        Platform p4 = new pijakan(); addObject(p4, 350, 820);
        Platform p5 = new pijakan(); addObject(p5, 100, 690);
        Platform p6 = new pijakan(); addObject(p6, 450, 570);
        Platform p7 = new pijakan(); addObject(p7, 250, 450);
        Platform p8 = new pijakan(); addObject(p8, 300, 330);
        Platform p9 = new pijakan(); addObject(p9, 150, 200);
        Platform p10 = new pijakan(); addObject(p10, 400, 100);

        // Tambahkan koin di atas platform secara acak
        List<Platform> platforms = getObjects(Platform.class);
        for (Platform platform : platforms) {
            int platformWidth = 150;
            int xOffset = Greenfoot.getRandomNumber(platformWidth) - platformWidth / 2;
            int x = platform.getX() + xOffset;
            int y = platform.getY() - 40;
            Coin coin = new Coin();
            addObject(coin, x, y);
        }

        poinCounter = new Counter("Poin: ");
        addObject(poinCounter, 70, 30);
    }

    public void tambahPoin(int nilai) {
        poin += nilai;
        poinCounter.setValue(poin);
        if (poin >= targetPoin && getObjects(Gate.class).isEmpty()) {
            addObject(new Gate(), getWidth() / 2, 80);
        }
    }

    public int getPoin() {
        return poin;
    }

    public int getTargetPoin() {
        return targetPoin;
    }
}
