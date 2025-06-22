package main;

import ecs.entities.Entity;
import ecs.factory.EggFactory;
import ecs.systems.HostIcubationSytem;
import ecs.systems.IncubationSystem;
import ecs.systems.LifeCycleSystem;
import ecs.world.World;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        World world = new World();
        // Adiciona um ovo inicial
        Entity egg = EggFactory.createRandom();
        Entity egg2 = EggFactory.createRandom();
        world.addEntity(egg);
        world.addEntity(egg2);

        // Registra sistemas
        world.addSystem(new IncubationSystem());
        world.addSystem(new LifeCycleSystem());
        world.addSystem(new HostIcubationSytem());



        // Loop principal
        for (int tick = 0; tick < 50; tick++) {
            System.out.println("--- Tick " + tick + " ---");
                    world.update();
                    world.printEntities();


            Thread.sleep(500);
        }
    }
}
