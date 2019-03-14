import controller.CacheManager;
import database.SessionFactoryUtil;
import model.CacheL1;
import model.CacheL2;
import strategy.StrategyLRR1;

public class Main {
    public static void main(String[] args) throws Exception {

        CacheL1 l1 = new CacheL1(2);
        CacheL2 l2 = new CacheL2(10);

        CacheManager<String, Integer> cache1 = new CacheManager(new StrategyLRR1(), l1, l2);


        cache1.put("Oleg", 12);
        cache1.put("Oleg1", 16);
        cache1.put("Oleg2", 13);

      /*  try {
            System.out.println(cache1.get("Olegg"));
        } catch (NoElementInCache e) {
            System.out.println(e.getMessage());
        }*/

        System.out.println(cache1.get("Oleg"));

        System.out.println(cache1);

        SessionFactoryUtil.getSessionFact().close();
    }
}
