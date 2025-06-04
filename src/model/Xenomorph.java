package model;

import model.enums.BehaviorState;
import model.enums.XenoPhase;

import java.util.UUID;

public abstract class Xenomorph {

    //identification
    protected UUID id;
    protected String type; // drone, facehugger, queen, etc...

    //features
    protected boolean acidBlood = true;

    //current status
    protected int health;
    protected int maxHealth;
    protected int age;
    protected int strength;
    protected int intelligence;
    protected XenoPhase phase; // Enum: EGG, FACEHUGGER, CHEST BUSTER, ADULT...

    //location
    protected int x;
    protected int y;

    //behavior
    protected BehaviorState currentBehavior;// Enum:  IDLE, HUNTING, PATROLLING, DEFENDING, ...

    //status xeno
    protected boolean isAlive;
    protected boolean isDead;

    //methods of xeno
    public boolean isMature(){
        return phase == XenoPhase.ADULT || this.phase == XenoPhase.QUEEN;
    }

    public void takeDamage(int damage){
        this.health -= damage;
        if (this.health <= 0){
            this.isDead = true;
        }
    }

    public void moveTo(int newX, int newY){
        this.x = newX;
        this.y = newY;
    }

    //public abstract void performXenomorph(WorldMap map);

    protected abstract void dead();

}
