public class Main {
    public static void main(String[] args) {

        CacheL1 l1 = new CacheL1(8);
        CacheL2 l2 = new CacheL2(8);
        CacheManager cache1 = new CacheManager(new StrategyLRR1(), l1, l2);

        CacheManager cache2 = new CacheManager(new StrategyLRR1());
        CacheManager cache3 = new CacheManager(new StrategyLRR2());

        cache1.putExclusive("Oleg");
        System.out.println(cache1.get("Oleg"));

        cache1.putInclusive("Oleg1");
        System.out.println(cache1.get("Oleg1"));

        cache1.putInclusive("Oleg4");
        cache1.putInclusive("Oleg5");
        cache1.putInclusive("Oleg6");
        cache1.putInclusive("Oleg7");
        cache1.putInclusive("Oleg8");


        cache2.putInclusive("Oleg2");
        System.out.println(cache2.get("Oleg2"));

        cache2.putExclusive("Oleg3");
        System.out.println(cache2.get("Oleg3"));

        System.out.println(cache1);
        System.out.println(cache2);
    }
}
