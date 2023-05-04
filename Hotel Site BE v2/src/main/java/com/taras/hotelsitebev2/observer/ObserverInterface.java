package com.taras.hotelsitebev2.observer;

import com.taras.hotelsitebev2.dtos.payment.RequestBodyNotificationBnb;

public interface ObserverInterface {

    void update (RequestBodyNotificationBnb requestBodyNotificationBnb);
}
