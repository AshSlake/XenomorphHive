package ecs.components;

public class IncubationComponent implements Component {

    private boolean isIncubating;
    private float incubationTime;   // tempo total necessario para eclosão.
    private float elapsedTime;      // tempo ja decorrido.

    public IncubationComponent(float incubationTime) {
        this.isIncubating = true;
        this.incubationTime = incubationTime;
        this.elapsedTime = 0;
    }

    public void update(float deltaTime) {
        if (this.isIncubating) {
            this.elapsedTime += deltaTime;
        }
    }

    public boolean isReadyToHatch(){
        return this.isIncubating && this.elapsedTime >= incubationTime;
    }

    public void reset() {
        this.isIncubating = true;
        this.elapsedTime = 0;
    }

    public void stop(){
        this.isIncubating = false;
    }

    public boolean isIncubating() {
        return isIncubating;
    }

    public void setIncubating(boolean incubating) {
        isIncubating = incubating;
    }

    public float getIncubationTime() {
        return incubationTime;
    }

    public void setIncubationTime(float incubationTime) {
        this.incubationTime = incubationTime;
    }

    public float getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(float elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    @Override
    public String toString() {
        return "Incubation(time=" + elapsedTime + "/" + incubationTime + ")";
    }
}
