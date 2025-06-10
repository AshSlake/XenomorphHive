package ecs.components;

/**
 * Propriedades físicas para simulação
 */

public class PhysicsComponent implements Component {
    private float mass;
    private float velocityX, velocityY;
    private boolean isSolid;
}
