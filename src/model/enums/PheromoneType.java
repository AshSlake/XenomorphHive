package model.enums;

import java.util.Comparator;
import java.util.List;

/**
 * Sistema químico de comunicação da colmeia xenomorfa
 *
 * <p>Cada feromônio tem propriedades distintas:</p>
 * <ul>
 *   <li><b>decayRate</b>: Velocidade de dissipação (0 = permanente, 1 = instantâneo)</li>
 *   <li><b>intensity</b>: Força base do sinal químico</li>
 *   <li><b>color</b>: Representação visual em RGB (0-1)</li>
 *   <li><b>persistence</b>: Se resiste ao tempo naturalmente</li>
 * </ul>
 */
public enum PheromoneType {
    /**
     * Sinal de emergência - disparado quando há ameaça iminente
     * <p><b>Efeito:</b> Todos os xenomorfos entram em estado de alerta</p>
     */
    ALARM(
            0.3f,
            1.5f,
            new float[]{1f, 0f, 0f} // Vermelho sangue
    ),

    /**
     * Chamado para ação coletiva - caçadas ou defesa
     * <p><b>Efeito:</b> Ativa comportamento de grupo</p>
     */
    RECRUITMENT(
            0.15f,
            1.2f,
            new float[]{0f, 1f, 1f} // Ciano elétrico
    ),

    /**
     * Marcação de rotas - caminhos seguros na colmeia
     * <p><b>Efeito:</b> Otimiza movimentação</p>
     */
    TRAIL(
            0.05f,
            0.8f,
            new float[]{0.5f, 0f, 1f} // Roxo profundo
    ),

    /**
     * Hierarquia colonial - sinalização de subordinação
     * <p><b>Efeito:</b> Mantém a cadeia de comando</p>
     */
    SUBMISSION(
            0.02f,
            0.5f,
            new float[]{0f, 0f, 0.8f} // Azul real
    ),

    /**
     * Ciclo reprodutivo - atração sexual entre castas
     * <p><b>Efeito:</b> Coordena acasalamentos</p>
     */
    MATING(
            0.1f,
            1.8f,
            new float[]{1f, 0.5f, 0f} // Laranja fluorescente
    ),

    /**
     * Localização de recursos - presas ou materiais
     * <p><b>Efeito:</b> Direciona forrageamento</p>
     */
    FOOD(
            0.2f,
            1.0f,
            new float[]{0f, 1f, 0f} // Verde ácido
    ),

    /**
     * Núcleo da colmeia - sinalização permanente do ninho
     * <p><b>Efeito:</b> Ponto de referência absoluto</p>
     */
    HIVE(
            0.005f,
            2.5f,
            new float[]{0.8f, 0.4f, 0f}, // Âmbar
            true
    ) {
        @Override
        public float getDynamicRange(float currentIntensity) {
            return 50f; // Alcance fixo de 50 unidades
        }

        @Override
        public boolean affectsCaste(XenoType caste) {
            return caste != XenoType.QUEEN; // Rainhas não respondem
        }
    };

    // Propriedades químicas
    private final float decayRate;
    private final float baseIntensity;
    private final float[] visualColor;
    private final boolean isPersistent;

    /**
     * Construtor padrão para feromônios temporários
     */
    PheromoneType(float decayRate, float baseIntensity, float[] visualColor) {
        this(decayRate, baseIntensity, visualColor, false);
    }

    /**
     * Construtor completo para feromônios especiais
     */
    PheromoneType(float decayRate, float baseIntensity, float[] visualColor, boolean isPersistent) {
        this.decayRate = decayRate;
        this.baseIntensity = baseIntensity;
        this.visualColor = visualColor;
        this.isPersistent = isPersistent;
    }

    // ===== COMPORTAMENTOS DINÂMICOS =====

    /**
     * Calcula o alcance efetivo do feromônio
     * @param currentIntensity Intensidade atual (0-∞)
     * @return Alcance em unidades do mundo
     */
    public float getDynamicRange(float currentIntensity) {
        return baseIntensity * 8f; // Fator de escala padrão
    }

    /**
     * Verifica se o feromônio afeta determinada casta
     */
    public boolean affectsCaste(XenoType caste) {
        return true; // Afeta todas por padrão
    }

    // ===== MÉTODOS DE ACESSO =====
    public float getDecayRate() {
        return decayRate;
    }

    public float getBaseIntensity() {
        return baseIntensity;
    }

    public float[] getVisualColor() {
        return visualColor.clone(); // Retorna cópia segura
    }

    // ===== MÉTODOS UTILITÁRIOS =====

    public boolean isPermanent() {
        return isPersistent;
    }

    public boolean isHivePheromone() {
        return this == HIVE;
    }

    public boolean isRoyalSignal() {
        return this == SUBMISSION || this == MATING;
    }

    public boolean isEmergencySignal() {
        return this == ALARM || this == RECRUITMENT;
    }

    /**
     * Gera uma assinatura química única para debug
     */
    @Override
    public String toString() {
        return name() + "|I:" + baseIntensity + "|D:" + decayRate;
    }
}