package order;

public class ExpressOrder extends OrderDecorator {
    public ExpressOrder(Transportable wrapper) {
        super(wrapper);
    }

    @Override
    public void process() {
        super.process();
        updateTimek();
    }

    public void updateTimek(){
        System.out.println("Faster");
    }
}
