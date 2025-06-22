package ecs.components;

import model.enums.XenoPhase;

import java.util.Map;

/**
 * Componente que controla o ciclo de vida do Xenomorfo,
 * sua fase atual, tempo nessa fase e vida.
 */
public class LifecycleComponent implements Component {
    private XenoPhase currentPhase;
    private float timeInPhase;
    private float timeIsAlive = 0f;
    private float timeToEnvolve;

    private float health;
    private float maxHealth;

    public LifecycleComponent(XenoPhase initialPhase) {
        this.currentPhase = initialPhase;
        this.maxHealth = calculateMaxHealth(initialPhase);
        this.health = maxHealth;
        this.timeInPhase = 0f;
    }

    public LifecycleComponent(XenoPhase initialPhase, float timeToEnvolve) {
        this.currentPhase = initialPhase;
        this.maxHealth = calculateMaxHealth(initialPhase);
        this.health = maxHealth;
        this.timeInPhase = 0f;
        this.timeToEnvolve = timeToEnvolve;
    }

    private float calculateMaxHealth(XenoPhase phase) {
        return switch (phase) {
            case EGG -> 10f;
            case FACEHUGGER -> 25f;
            case CHESTBURSTER -> 50f;
            case ADULT -> 100f;
            case QUEEN -> 200f;
        };
    }

    public void update(float deltaTime) {
        timeInPhase += deltaTime;
        timeIsAlive += deltaTime;

    }

    // Getters
    public XenoPhase getCurrentPhase() {
        return currentPhase;
    }

    public float getTimeInPhase() {
        return timeInPhase;
    }

    public float getHealth() {
        return health;
    }

    public float getMaxHealth() {
        return maxHealth;
    }

    // Modificador de dano
    public void takeDamage(float amount) {
        health = Math.max(0, health - amount);
    }

    public boolean isReadyToEvolve() {
        return timeInPhase >= timeToEnvolve;
    }

    public void resetPhaseTime() {
        this.timeInPhase = 0f;
    }

    // toString para debug
    @Override
    public String toString() {
        return "Lifecycle(" + currentPhase +
                ", time is a Phase=" + timeInPhase +
                ", time is a live=" + timeIsAlive +
                ", health=" + health + "/" + maxHealth + ")";
    }
}
