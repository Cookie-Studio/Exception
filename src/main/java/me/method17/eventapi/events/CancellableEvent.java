package me.method17.eventapi.events;

public abstract class CancellableEvent implements Event {
    private boolean cancelled;

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean state) {
        cancelled = state;
    }

    public void setCancelled() {
        cancelled = true;
    }
}