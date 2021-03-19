package me.method17.eventapi;

import me.method17.eventapi.events.Event;
import me.method17.eventapi.events.EventHandler;
import me.method17.eventapi.listener.Listener;
import me.method17.eventapi.listener.ListenerMethod;
import org.lwjgl.Sys;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class EventManager {
    private static final ArrayList<ListenerMethod> methods = new ArrayList<>();

    public static void registerListener(Listener listener) {
        for (Method method : listener.getClass().getMethods()) {
            if (method.isAnnotationPresent(EventHandler.class)) {
                methods.add(new ListenerMethod(method, listener));
            }
        }
    }

    public static void unregisterListener(Listener listener) {
        ArrayList<ListenerMethod> methods1 = (ArrayList<ListenerMethod>) methods.clone();
        for (ListenerMethod lm : methods1) {
            if (lm.getInstance().equals(listener)) {
                methods.remove(lm);
            }
        }
    }

    public static void unregisterAllListener() {
        methods.clear();
    }

    public static void callEvent(Event event) {
        for (ListenerMethod lm : methods) {
            if (lm.getInstance().isActive() && lm.isMatchEvent(event)) {
                try {
                    lm.getMethod().invoke(lm.getInstance(), event);
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        }
    }
}
