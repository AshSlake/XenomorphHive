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
}
