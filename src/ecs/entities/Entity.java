package ecs.entities;

import ecs.components.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * Representa uma entidade no sistema ECS (Entity-Component-System).
 *
 * Cada entidade possui um ID e um conjunto de componentes associados.
 * Os componentes são armazenados em um mapa, indexados pelo tipo da classe.
 */
public class Entity {

    /** contador global para incrementação dos IDS */
    private static int nextId = 0;

    /** ID usado para identificar a entidade no sistema. */
    private int id;

    /** nome da entidade */
    private String name;

    /** ID usado para identificar o tipo da entidade*/
    private int idTypeComponent;

    /**
     * Armazena todos os componentes que a entidade possui,
     * indexando-os pela sua classe.
     */
    private final Map<Class<?>, ecs.components.Component> components = new HashMap<>();
    private boolean removed = false;

    public Entity() {
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTypeComponent() {
        return idTypeComponent;
    }

    public void setIdTypeComponent(int idTypeComponent) {
        this.idTypeComponent = idTypeComponent;
    }

    /**
     * Adiciona um componente à entidade.
     *
     * @param component O componente a ser adicionado.
     */
    public void addComponent(ecs.components.Component component) {
        components.put(component.getClass(), component);
    }

    /**
     * Retorna um componente da entidade com base na classe do componente.
     *
     * @param componentClass A classe do componente desejado.
     * @param <T> O tipo do componente.
     * @return O componente correspondente, ou {@code null} se não estiver presente.
     */
    public <T extends ecs.components.Component> T getComponent(Class<T> componentClass) {
        return componentClass.cast(components.get(componentClass));
    }

    public boolean hasComponent(Class<?> componentClass) {
        return  components.containsKey(componentClass);
    }

    public void markForRemoval() {
        this.removed = true;
    }

    public boolean isRemoved() {
        if(this.removed) {
            System.out.println("Entity has been removed");
        }
        return this.removed;
    }

    public Map<Class<?>, Component> getAllComponents() {
        return Map.copyOf(components); // Retorna uma cópia imutável
    }

    public void update() {

    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Entity.nextId = nextId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Entity [id=" + id + ", components=" + components + ", removed=" + removed + "]";
    }
}
