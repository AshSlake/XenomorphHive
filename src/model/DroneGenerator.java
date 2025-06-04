package model;

import model.enums.BehaviorState;
import model.enums.XenoPhase;

import java.util.UUID;

public class DroneGenerator extends Xenomorph {

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
        this.dead();
    }


    protected void dead() {
        if (this.isDead) {
            System.out.println(this.type + " is dead");
        }
    }
}
