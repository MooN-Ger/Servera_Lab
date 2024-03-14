package models;

import java.io.Serializable;

public enum Statuses implements Serializable {
    ACTIVE,
    VACATION,
    UNKNOWN;

    public String getStatus() {
        return this.name();
    }
}
