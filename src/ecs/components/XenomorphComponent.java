package ecs.components;

/*
 * Identifica o tipo e status do xenomorfo
 * */

import model.enums.XenoType;

public class XenomorphComponent implements Component {
    private XenoType type;
    private boolean isAlive = true;
    private int hiveId; //id da colmeia que pertence

    public XenomorphComponent(XenoType type) {
        this.type = type;

    }

    public XenomorphComponent(XenoType type, boolean isAlive, int hiveId) {
        this.type = type;
        this.isAlive = isAlive;
        this.hiveId = hiveId;
    }

    public XenoType getType() {
        return type;
    }

    public void setType(XenoType type) {
        this.type = type;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getHiveId() {
        return hiveId;
    }

    public void setHiveId(Integer hiveId) {
        this.hiveId = hiveId;
    }
}
