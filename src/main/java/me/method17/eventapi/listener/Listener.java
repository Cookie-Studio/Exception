package me.method17.eventapi.listener;

import me.method17.eventapi.EventManager;

public class Listener {
    private boolean active = true;

    public Listener() {
        EventManager.registerListener(this);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
