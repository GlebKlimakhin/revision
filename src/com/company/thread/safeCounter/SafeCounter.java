package com.company.thread.safeCounter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeCounter {

    private final Lock lock = new ReentrantLock();
    private int value;

    public SafeCounter(int value) {
        this.value = value;
    }

    public boolean increment() {
        try {
            lock.lock();
            value++;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            lock.unlock();
        }
    }

    public boolean decrement() {
        try {
            lock.lock();
            value--;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            lock.unlock();
        }
    }

    public int getValue() {
        try {
            lock.lock();
            return this.value;
        }
        finally {
            lock.unlock();
        }
    }
}
