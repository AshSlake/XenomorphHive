package ecs.components;

import utils.PositionGenerator;


/**
 * Armazena posição e orientação no espaço
 */

public class PositionComponent implements Component{
    private PositionGenerator position;

    public PositionComponent(int x, int y) {
        this.position = new PositionGenerator(x,y);
    }

    public PositionGenerator getPosition() {
        return position;
    }
    public void setPosition(PositionGenerator position) {
        this.position = position;
    }

    public int getX() {return position.x;}
    public int getY() {return position.y;}

    @Override
    public String toString() {
        return "PositionComponent{" + "position=" + position + '}';
    }
}
