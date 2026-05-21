package com.spring.observer;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class HouseSubject {
    private List<HouseObserver> observers = new ArrayList<>();

    public void addObserver(HouseObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(HouseObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (HouseObserver observer : observers) {
            observer.update(message);
        }
    }
}