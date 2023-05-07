package ru.nsu.fit.vinter.carFactory.core.factory.utils;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class GeneratorID {
    private final AtomicLong number;

    public GeneratorID() {
        number = new AtomicLong(1);
    }

    public long generate() {
        return number.getAndIncrement();
    }
}
