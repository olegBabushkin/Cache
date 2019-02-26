package order;

public class BigOrder extends OrderDecorator {
    @Override
    public void process() {
        super.process();
        putInBox();
    }

    public BigOrder(Transportable wrapper) {
        super(wrapper);

    }

    public void putInBox(){
        System.out.println("Box");
    }
}
