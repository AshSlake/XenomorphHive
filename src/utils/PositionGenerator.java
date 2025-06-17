package utils;

public class PositionGenerator {

    private static final float MAP_WIDTH = 100f;
    private static final float MAP_HEIGHT = 100f;

    public static float[] generateRandomPosition() {
        return generateWithin(MAP_WIDTH, MAP_HEIGHT);
    }

    // (opcional) gerar posição dentro de limites específicos
    public static float[] generateWithin(float maxX, float maxY) {
        float x = (float) (Math.random() * maxX);
        float y = (float) (Math.random() * maxY);
        return new float[]{x, y};
    }
}
