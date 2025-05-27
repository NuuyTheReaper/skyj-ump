// Player.java
import greenfoot.*;

public class Player extends Actor {
    private int speedY = 0;
    private final int GRAVITY = 1;
    private final int JUMP_STRENGTH = -16;

    public Player() {
        GreenfootImage img = new GreenfootImage("pou.png");
        img.scale(50, 50);
        setImage(img);
    }
    
    public void act() {
        applyGravity();
        checkPlatformCollision();
        checkCoinCollision();
        checkGate();
        moveHorizontally();
    }

    private void applyGravity() {
        speedY += GRAVITY;
        setLocation(getX(), getY() + speedY);
    }

    private void jump() {
        speedY = JUMP_STRENGTH;
    }

    private void checkPlatformCollision() {
        Platform platform = (Platform) getOneObjectAtOffset(0, getImage().getHeight() / 2, Platform.class);
        if (platform != null && speedY > 0) {
            jump();
        }
    }

    private void checkCoinCollision() {
        Coin coin = (Coin) getOneIntersectingObject(Coin.class);
        if (coin != null) {
            getWorld().removeObject(coin);
            ((GameWorld) getWorld()).tambahPoin(10);
        }
    }

    private void checkGate() {
    Gate gate = (Gate) getOneIntersectingObject(Gate.class);
    if (gate != null) {
        GameWorld world = (GameWorld) getWorld();
        if (world.getPoin() >= world.getTargetPoin()) {
            Greenfoot.setWorld(new Level2World()); // Ganti ke level 2
        } else {
            getWorld().showText("Poin belum cukup!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        }
    }
}


    private void moveHorizontally() {
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - 5, getY());
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + 5, getY());
        }
    }
}