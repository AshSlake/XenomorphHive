package model;

import model.enums.BehaviorState;
import model.enums.XenoPhase;

import java.util.UUID;

public class FaceHuggerGenerator extends Xenomorph{

    private boolean incubating = false;

    public FaceHuggerGenerator(int x, int y) {
        this.id = UUID.randomUUID();
        this.type = "Facehugger";
        this.x = x;
        this.y = y;
        this.health = 15;
        this.maxHealth = 15;
        this.age = 0;
        this.strength = 35;
        this.intelligence = 18;
        this.defense = 8;
        this.acidBlood = true;
        this.phase = XenoPhase.FACEHUGGER;
        this.isDead = false;
        this.currentBehavior = BehaviorState.IDLE;
    }

    public boolean isIncubating() {
        return incubating;
    }

    public void setIncubating(boolean incubating) {
        this.incubating = incubating;
    }

    protected void dead() {
        if(this.health <= 0){
            this.isDead = true;
            System.out.println(this.type + " is dead!");
        }
    }

    public void incubation(){
        this.incubating = true;
    }

    public ChestBursterGenerator completeIncubation() {
        this.incubating = false;
        System.out.println(this.type + " is complete incubation!");
        this.health = 0;
        this.dead();

        return new ChestBursterGenerator(this.x, this.y);
    }


}
