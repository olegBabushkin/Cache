package order;

public class OrderDecorator implements Transportable {
    Transportable wrapper;

    public OrderDecorator(Transportable wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public void process() {
        wrapper.process();
    }
}
