package model;

import model.enums.BehaviorState;
import model.enums.XenoPhase;

import java.util.UUID;

public class DroneGenerator extends Xenomorph {

    private int enemiesKilled = 0;

    public DroneGenerator(int x, int y) {
        this.id = UUID.randomUUID();
        this.type = "Drone";
        this.x = x;
        this.y = y;
        this.health = 80;
        this.maxHealth = 80;
        this.age = 0;
        this.strength = 40;
        this.intelligence = 25;
        this.defense = 15;
        this.acidBlood = true;
        this.phase = XenoPhase.ADULT;
        this.isDead = false;
        this.currentBehavior = BehaviorState.PATROLLING;
    }

    public int getEnemiesKilled() {
        return enemiesKilled;
    }

    public void setEnemiesKilled(int enemiesKilled) {
        this.enemiesKilled += enemiesKilled;
    }

    public void dead() {
        if (this.health <= 0) {
            this.isDead = true;
            System.out.println(this.type + " is dead");
        }
    }

    public void toEvolve() {
        if (this.isDead) return;
        if (this.enemiesKilled >= 5) {
            this.strength += 10;
            this.defense += 5;
            this.intelligence += 2;
        }
    }

}
