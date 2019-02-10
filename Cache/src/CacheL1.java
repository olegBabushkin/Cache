
import java.util.*;

public class CacheL1 extends Cache {

    public CacheL1(int capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        return "CacheL1{" +
                "cache=" + super.cache +
                '}';
    }
}
