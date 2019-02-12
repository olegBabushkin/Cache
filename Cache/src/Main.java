import controller.CacheManager;
import model.CacheL1;
import model.CacheL2;
import strategy.StrategyLRR1;
import strategy.StrategyLRR2;

public class Main {
    public static void main(String[] args) {

        CacheL1 l1 = new CacheL1(5);
        CacheL2 l2 = new CacheL2(10);
        CacheManager<String, Integer> cache1 = new CacheManager(new StrategyLRR1(), l1, l2);

        CacheManager<String, Object> cache2 = new CacheManager(new StrategyLRR2());


        cache1.put("Oleg", 12);
        cache1.put("Oleg4", 55);
        cache1.put("Oleg5", 55);
        cache1.put("Oleg6", 55);
        cache1.put("Oleg7", 45);
        cache1.put("Oleg8", 55);

        System.out.println(cache1.get("Oleg"));
        System.out.println(cache1.get("Oleg7"));

        System.out.println(cache1);
        System.out.println(cache2);
    }
}
