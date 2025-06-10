package ecs.components;

// ecs/components/AIComponent.java

import ecs.entities.Entity;
import model.enums.BehaviorState;

/**
 * Dados para tomada de decisão
 */
public class AIComponent implements Component {
    private BehaviorState currentState;
    private float awarenessRadius;
    private Entity currentTarget;
}