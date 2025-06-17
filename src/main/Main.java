package main;

import ecs.entities.Entity;
import ecs.factory.EggFactory;
import ecs.world.World;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        World world = new World();

        //create entities(Eggs, etc...)
        Entity egg = EggFactory.createRandom();
        world.addEntity(egg);

        // add systems
//        world.addSystem(new IncubationSystem());
//        world.addSystem(new EvolutionSystem());
//        world.addSystem(new CombatSystem());

        //loop from simulation
        for (int i = 0 ; i < 1000; i++){
            world.update();
            Thread.sleep(100);
        }
    }
}
