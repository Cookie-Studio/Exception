package me.method17.exception.events;

import me.method17.eventapi.events.CancellableEvent;
import org.lwjgl.input.Keyboard;

public class KeyEvent extends CancellableEvent {
    private final int code;
    private final String name;

    public KeyEvent(int code) {
        this.code = code;
        this.name = Keyboard.getKeyName(code);
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
