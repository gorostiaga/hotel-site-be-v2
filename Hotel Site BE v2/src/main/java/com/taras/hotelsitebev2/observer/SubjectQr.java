package com.taras.hotelsitebev2.observer;

import com.taras.hotelsitebev2.dtos.payment.RequestBodyNotificationBnb;
import com.taras.hotelsitebev2.exceptions.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class SubjectQr implements SubjectInterface {
    private RequestBodyNotificationBnb requestBodyNotificationBnb;
    private Set<ObserverInterface> observers;

    public SubjectQr() {
        observers = new HashSet<>();
    }

    @Override
    public void registerObserver(ObserverInterface o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(ObserverInterface o) {
        if (observers.contains(o)) {
            observers.remove(o);
        } else {
            throw new NotFoundException("Observer not found");
        }
    }

    @Override
    public void notifyObserver() {
        for (ObserverInterface observer : observers) {
            observer.update(requestBodyNotificationBnb);
        }
    }

    public void changeState(RequestBodyNotificationBnb requestBodyNotificationBnb) {
        this.requestBodyNotificationBnb = requestBodyNotificationBnb;
        notifyObserver();
    }
}
