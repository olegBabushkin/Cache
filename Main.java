import order.BigOrder;
import order.ExpressOrder;
import order.Order;
import service.ObserverPonyExpress;
import service.SystemOrder;

public class Main {
    public static void main(String[] args) {
        SystemOrder ss = new SystemOrder(new BigOrder(new ExpressOrder(new Order())));
        ss.registerObserver(new ObserverPonyExpress());
        ss.process();
    }
}
