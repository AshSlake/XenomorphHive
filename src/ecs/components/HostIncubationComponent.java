package ecs.components;

public class HostIncubationComponent implements Component {

    private float timeToBurst;
    private float incubationTime;
    private boolean itIncubated = false;
    private boolean readyToBurst;

    public HostIncubationComponent() {
        this.timeToBurst = 0f;
        this.incubationTime = 0f;
        this.readyToBurst = false;
        itIncubated = false;
    }

    public HostIncubationComponent(boolean itIncubated, float timeToBurst) {
        this.itIncubated = itIncubated;
        this.timeToBurst = timeToBurst;
        this.incubationTime = timeToBurst;
        this.readyToBurst = false;
    }

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

    public float getTimeToBurst() {
        return timeToBurst;
    }

    public void setTimeToBurst(float timeToBurst) {
        this.timeToBurst = timeToBurst;
    }

    public float getIncubationTime() {
        return incubationTime;
    }

    public void setIncubationTime(float incubationTime) {
        this.incubationTime = incubationTime;
    }

    public boolean isItIncubated() {
        return itIncubated;
    }

    public void setItIncubated(boolean itIncubated) {
        this.itIncubated = itIncubated;
    }

    public void setReadyToBurst(boolean readyToBurst) {
        this.readyToBurst = readyToBurst;
    }

    @Override
        public String toString() {
            return "HostIncubation(" + incubationTime + "/" + timeToBurst + ")";
        }
}
