public class Main {
    public static void main(String[] args) {

        CacheL1 l1 = new CacheL1(6);
        CacheL2 l2 = new CacheL2(6);
        CacheManager cache1 = new CacheManager(new StrategyLRR1(), l1, l2);

        CacheManager cache2 = new CacheManager(new StrategyLRR2());


        cache1.put("Oleg");
        cache1.put("Oleg4");
        cache1.put("Oleg5");
        cache1.put("Oleg6");
        cache1.put("Oleg7");
        cache1.put("Oleg8");


        cache2.put("Oleg2");
        cache2.put("Oleg13");
        cache2.put("Oleg23");
        cache2.put("Oleg33");
        cache2.put("Oleg43");
        cache2.put("Oleg53");


        System.out.println(cache1);
        System.out.println(cache2);
    }
}
