package model;

import model.enums.BehaviorState;
import model.enums.XenoPhase;

import java.util.UUID;

public class ChestBursterGenerator extends Xenomorph {

    public ChestBursterGenerator(int x, int y) {
        this.id = UUID.randomUUID();
        this.type = "ChestBurster";
        this.x = x;
        this.y = y;
        this.health = 40;
        this.maxHealth = 40;
        this.age = 0;
        this.strength = 20;
        this.intelligence = 13;
        this.defense = 7;
        this.acidBlood = true;
        this.phase = XenoPhase.CHESTBURSTER;
        this.isDead = false;
        this.currentBehavior = BehaviorState.ESCAPING;
    }

    public void dead() {
        if (this.health <= 0) {
            this.isDead = true;
            System.out.println(this.type + " is dead");
        }
    }

    public DroneGenerator evolveToDrone() {
        // {evolution logic}
        return new DroneGenerator(this.x, this.y);
    }
}
