package ecs.components;

public class HealthComponent implements Component {
    private float maxHealth;
    private float currentHealth;
    private boolean isDead;

    public HealthComponent(float maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.isDead = false;
    }

    public void takeDamage(int amount) {
        if (isDead) return;

        currentHealth -= amount;
        if (currentHealth <= 0) {
            currentHealth = 0;
            isDead = true;
        }
    }

    public void heal(int amount) {
        if (isDead) return;

        currentHealth += amount;
        if (currentHealth > maxHealth) {
            currentHealth = maxHealth;
        }
    }

    // Getters
    public float getMaxHealth() {
        return maxHealth;
    }

    public float getCurrentHealth() {
        return currentHealth;
    }

    public boolean isDead() {
        return isDead;
    }

    // Optional setters
    public void setMaxHealth(float maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setCurrentHealth(float currentHealth) {
        this.currentHealth = currentHealth;
    }

    @Override
    public String toString() {
        return "Health(" + currentHealth + ")";
    }
}
