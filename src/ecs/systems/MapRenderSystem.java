package ecs.systems;

import ecs.components.PositionComponent;
import ecs.entities.Entity;
import utils.PositionGenerator;

import java.util.Arrays;
import java.util.List;

public class MapRenderSystem implements System{
private static final int WIDTH = 30;
private static final int HEIGHT = 20;

public void update(List<Entity> entities) {
    char[][] map  = new char[WIDTH][HEIGHT];

    for(char[] row : map) {
        Arrays.fill(row, '.');
    }

    for(Entity e : entities) {
        if (!e.hasComponent(PositionComponent.class)) continue;

        PositionGenerator position = e.getComponent(PositionComponent.class).getPosition();
        if (position.x < WIDTH && position.y < HEIGHT) {
            map[position.y][position.x] = resolveSymbol(e);
        }
    }
    for (char[] row : map) {
        java.lang.System.out.println(new String(row));
    }
}

    private char resolveSymbol(Entity e) {
        if (e.getName().contains("Queen")) return 'Q';
        if (e.getName().contains("Drone")) return 'D';
        if (e.getName().contains("Egg")) return 'O';
        if (e.getName().contains("Facehugger")) return 'F';
        if (e.getName().contains("Human")) return 'H';
        return '?';
    }

}
