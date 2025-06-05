package model;

import model.enums.BehaviorState;
import model.enums.XenoPhase;

import java.util.UUID;

public class EggGenerator extends Xenomorph {

    private boolean inert = true;

    public EggGenerator(int x, int y) {
        this.id = UUID.randomUUID();
        this.type = "Egg";
        this.x = x;
        this.y = y;
        this.health = 5;
        this.maxHealth = 5;
        this.age = 0;
        this.defense = 8;
        this.acidBlood = true;
        this.phase = XenoPhase.EGG;
        this.isDead = false;
        this.currentBehavior = BehaviorState.IDLE;
    }

    public boolean isInert() {
        return inert;
    }

    public void setInert(boolean inert) {
        this.inert = inert;
    }

    public void dead() {
        if(this.health <= 0){
            this.isDead = true;
            System.out.println(this.type + " is Destroyed!");
        }
    }

    public FaceHuggerGenerator eggHatching() {
        this.setInert(false);
        this.health = 0;
        this.dead();
        System.out.println(this.type + " is Hatching");
        return new FaceHuggerGenerator(this.x, this.y);
    }
}
