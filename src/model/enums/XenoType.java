// model/enums/XenoType.java
package model.enums;

/**
 * Define a espécie/casta do xenomorfo
 * (Complementa o XenoPhase que indica o estágio de vida)
 */
public enum XenoType {
    EGG {
        @Override
        public boolean canEvolve() {
            return true;
        }

        @Override
        public XenoType getNextEvolution() {
            return FACEHUGGER;
        }
    },

    FACEHUGGER {
        @Override
        public boolean canEvolve() {
            return true;
        }

        @Override
        public XenoType getNextEvolution() {
            return CHESTBURSTER;
        }
    },

    CHESTBURSTER {
        @Override
        public boolean canEvolve() {
            return true;
        }

        @Override
        public XenoType getNextEvolution() {
            return DRONE; // Evolução padrão
        }
    },

    DRONE {
        @Override
        public boolean canEvolve() {
            return false; // Requer condições especiais
        }

        @Override
        public XenoType getNextEvolution() {
            return PRAETORIAN; // Se houver recursos suficientes
        }
    },

    PRAETORIAN {
        @Override
        public boolean canEvolve() {
            return false; // Requer rainha existente
        }

        @Override
        public XenoType getNextEvolution() {
            return QUEEN; // Se não houver rainha viva
        }
    },

    QUEEN {
        @Override
        public boolean canEvolve() {
            return false; // Forma definitiva
        }

        @Override
        public XenoType getNextEvolution() {
            return null;
        }
    },

    RUNNER {
        @Override
        public boolean canEvolve() {
            return false; // Variante especial
        }

        @Override
        public XenoType getNextEvolution() {
            return null;
        }
    };

    // Métodos abstratos que cada enum deve implementar
    public abstract boolean canEvolve();
    public abstract XenoType getNextEvolution();

    // Métodos utilitários
    public boolean isRoyalCaste() {
        return this == QUEEN || this == PRAETORIAN;
    }

    public boolean canImpregnate() {
        return this == FACEHUGGER || this == QUEEN;
    }

    public boolean isAdultForm() {
        return this == DRONE || this == PRAETORIAN || this == QUEEN || this == RUNNER;
    }
}