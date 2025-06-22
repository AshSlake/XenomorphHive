package ecs.components;

/**
 * Armazena posição e orientação no espaço
 */

public class PositionComponent implements Component{

    private float x,y;
    private float rotation;

    public PositionComponent(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    @Override
    public String toString() {
        return "PositionComponent [x=" + x + ", y=" + y + ", rotation=" + rotation + "]";
    }
}
