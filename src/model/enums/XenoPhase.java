package model.enums;

public enum XenoPhase {
    EGG, FACEHUGGER, CHESTBURSTER, ADULT, QUEEN;

    public XenoPhase getNextPhase() {
        return switch (this) {
            case EGG -> FACEHUGGER;
            case FACEHUGGER -> CHESTBURSTER;
            case CHESTBURSTER -> ADULT;
            case ADULT -> QUEEN;
            case QUEEN -> null; // Fase final
        };
    }
}