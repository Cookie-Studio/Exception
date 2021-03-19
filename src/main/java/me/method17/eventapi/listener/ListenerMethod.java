package me.method17.eventapi.listener;

import me.method17.eventapi.events.Event;

import java.lang.reflect.Method;

public class ListenerMethod {
    public Method method;
    public Listener instance;

    public ListenerMethod(Method method, Listener instance) {
        this.method = method;
        this.instance = instance;
    }

    public Method getMethod() {
        return method;
    }

    public Listener getInstance() {
        return instance;
    }

    public boolean isMatchEvent(Event event) {
        return this.method.getParameterTypes()[0] == event.getClass();
    }
}
