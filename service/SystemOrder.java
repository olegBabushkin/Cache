package service;

import order.OrderDecorator;

import java.util.LinkedList;
import java.util.List;

public class SystemOrder implements Observable {
    private List<Observer> observers;
    OrderDecorator order;

    public SystemOrder(OrderDecorator order) {
        this.observers = new LinkedList<>();
        this.order = order;
    }

    @Override
    public void registerObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.send(order);
        }
    }

    public void process() {
        order.process();
        notifyObservers();
    }
}