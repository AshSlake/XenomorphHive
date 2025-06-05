package model;

import model.enums.BehaviorState;
import model.enums.XenoPhase;

import java.util.UUID;

public class QueenGenerator extends Xenomorph{

    private int numEggsGenerated = 0;

    public QueenGenerator(int x, int y) {
        this.id = UUID.randomUUID();
        this.type = "Queen";
        this.x = x;
        this.y = y;
        this.health = 150;
        this.maxHealth = 150;
        this.age = 10;
        this.strength = 80;
        this.intelligence = 70;
        this.defense = 40;
        this.acidBlood = true;
        this.phase = XenoPhase.QUEEN;
        this.isDead = false;
        this.currentBehavior = BehaviorState.GENERATE_EGGS;
    }

    public int getNumEggsGenerated() {
        return numEggsGenerated;
    }

    public void setNumEggsGenerated(int numEggsGenerated) {
        this.numEggsGenerated = numEggsGenerated;
    }

    public void dead() {
        if (this.health <= 0) {
            this.isDead = true;
            System.out.println(this.type + " is dead");
        }
    }

    public EggGenerator generateEggs() {
        this.numEggsGenerated++;
        System.out.println(this.type + " generated a new egg");
        return new EggGenerator(this.x, this.y);
    }
}
