package order;

public class Order implements Transportable {
    @Override
    public void process() {
        System.out.println("sendOrder");

    }
}