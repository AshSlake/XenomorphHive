package utils;

import java.util.Objects;

public class PositionGenerator {

    public final int x;
    public final int y;

    public PositionGenerator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static PositionGenerator ramdom(int maxX, int maxY) {
        int x = (int) (Math.random() * maxX);
        int y = (int) (Math.random() * maxY);
        return new PositionGenerator(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PositionGenerator position)) return false;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "PositionGenerator{" + "x=" + x + ", y=" + y + '}';
    }
}
