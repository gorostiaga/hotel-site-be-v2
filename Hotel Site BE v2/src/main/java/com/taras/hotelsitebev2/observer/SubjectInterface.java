package com.taras.hotelsitebev2.observer;

public interface SubjectInterface {
    void registerObserver(ObserverInterface o);
    void removeObserver(ObserverInterface o);
    void notifyObserver();
}
