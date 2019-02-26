package service;

import order.OrderDecorator;

public interface Observer {
    public void send(OrderDecorator order);
}
