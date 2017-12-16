package com.example.event.beans;

import org.springframework.context.ApplicationEvent;

public abstract class GenericEvent<T> extends ApplicationEvent {
    private final T source;

    public GenericEvent(T source) {
        super(source);
        this.source = source;
    }

    @Override
    public T getSource() {
        return source;
    }
}
