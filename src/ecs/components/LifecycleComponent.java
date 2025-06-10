package ecs.components;

import model.enums.XenoPhase;

/**
 * Controla estágios de vida e tempo em cada fase
 */

public class LifecycleComponent implements Component {
private XenoPhase currentPhase;
private float timeInPhase;
private float health;
private float maxHealth;

    public LifecycleComponent(XenoPhase initialPhase, float health) {
        this.currentPhase = initialPhase;
        this.health = calculateMaxHealth(initialPhase);
    }

    private float calculateMaxHealth(XenoPhase phase) {
        return switch(phase) {
            case EGG -> 10f;
            case FACEHUGGER -> 25f;
            case CHESTBURSTER -> 50f;
            case ADULT -> 100f;
            case QUEEN -> 200f;
        };
    }
}
