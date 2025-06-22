package ecs.components;

public class HostIncubationComponent implements Component {

    private float timeToBurst;
    private float incubationTime;
    private boolean readyToBurst;

    public HostIncubationComponent(float timeToBurst) {
        this.timeToBurst = timeToBurst;
        this.incubationTime = 0f;
        this.readyToBurst = false;
    }

    public void update(float deltaTime) {
        incubationTime += deltaTime;
        if (incubationTime > timeToBurst) {
            readyToBurst = true;
        }
    }
    public boolean isReadyToBurst() {
        return readyToBurst;
    }

    @Override
        public String toString() {
            return "HostIncubation(" + incubationTime + "/" + timeToBurst + ")";
        }
}
