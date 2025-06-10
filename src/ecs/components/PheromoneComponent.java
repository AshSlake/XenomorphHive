package ecs.components;

// ecs/components/PheromoneComponent.java

import model.enums.PheromoneType;

import java.util.EnumMap;
import java.util.Map;

/**
 * Comunicação com a colmeia
 */
// ecs/components/PheromoneComponent.java
public class PheromoneComponent implements Component {
    private Map<PheromoneType, Float> activePheromones; // Tipo -> Intensidade atual
    private float emissionRadius;
    private boolean isReceptor;

    public PheromoneComponent(float emissionRadius, boolean isReceptor) {
        this.activePheromones = new EnumMap<>(PheromoneType.class);
        this.emissionRadius = emissionRadius;
        this.isReceptor = isReceptor;
    }

    public void emitPheromone(PheromoneType type, float initialIntensity) {
        activePheromones.merge(type, initialIntensity, Float::sum);
    }

    public void update(float deltaTime) {
        activePheromones.replaceAll((type, intensity) ->
                Math.max(0, intensity - type.getDecayRate() * deltaTime)
        );
        activePheromones.values().removeIf(intensity -> intensity <= 0.01f);
    }
}