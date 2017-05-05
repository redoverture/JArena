package Global;
import Transferable.Position;

public class Player extends Entity {
    private Position currentPosition;
    private Position boundary;
    private int facing;
    private int health;
    private boolean alive = true;

    public Player(Position currentPosition, Position boundary, int facing, int health) {
        if (currentPosition.x <= 0 || currentPosition.y <= 0)
            throw new IllegalArgumentException("Position must be positive.");
        if (boundary.x < 0 || boundary.y < 0) throw new IllegalArgumentException("Boundary must be positive.");
        if (health < 0) throw new IllegalArgumentException("Health must be positive and greater than zero.");
        this.currentPosition = currentPosition;
        this.facing = facing;
        this.health = health;
    }

    public Player(Position boundary) {
        if (boundary.x < 0 || boundary.y < 0) throw new IllegalArgumentException("Boundary must be positive.");
        if (health < 0) throw new IllegalArgumentException("Health must be positive and greater than zero.");
        this.currentPosition = new Position(0, 0);
        this.health = 5;
        this.facing = Constants.FACING_NORTH;
    }

    public Player(int health, Position boundary) {
        if (boundary.x < 0 || boundary.y < 0) throw new IllegalArgumentException("Boundary must be positive.");
        if (health < 0) throw new IllegalArgumentException("Health must be positive and greater than zero.");
        this.currentPosition = new Position(0, 0);
        this.health = health;
        this.facing = Constants.FACING_NORTH;
    }

    public Player(Position currentPosition, Position boundary, int facing) {
        if (currentPosition.x <= 0 || currentPosition.y <= 0)
            throw new IllegalArgumentException("Position must be positive.");
        if (boundary.x < 0 || boundary.y < 0) throw new IllegalArgumentException("Boundary must be positive.");
        if (health < 0) throw new IllegalArgumentException("Health must be positive and greater than zero.");
        this.health = 5;
        this.currentPosition = currentPosition;
        this.facing = facing;

    }
}