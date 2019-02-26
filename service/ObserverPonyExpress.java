package service;

import order.OrderDecorator;

public class ObserverPonyExpress implements Observer {
    OrderDecorator currentlyOrder;

    @Override
    public void send(OrderDecorator order) {
        currentlyOrder = order;
        System.out.println("Message received");
    }
}
