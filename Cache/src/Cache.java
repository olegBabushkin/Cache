import java.util.*;

public abstract class Cache {
    Map<String, Long> cache;
    private int capacity;

    public Cache(int capacity) {
       this.cache = new HashMap<>(capacity);
       this.capacity = capacity;
    }

    public String getElement(String element) {
        if (cache.containsKey(element)) {
            cache.put(element,System.currentTimeMillis());
            return element;
        } else {
            return "element not found";
        }
    }

    public void setElement(String element) {
        cache.put(element, System.currentTimeMillis());
    }

    public void removeOldElement(){
        cache.remove(findOldestElem());
    }

    public void clearCache() {
        cache.clear();
    }

    public Map<String, Long> getCache() {
        return cache;
    }

    public void setCache(Map<String, Long> cache) {
        this.cache = cache;
    }

    public boolean isFull(){
        return this.capacity== cache.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //find oldest line in cache
    public String findOldestElem() {
        List<Long> listValues = new ArrayList<>(cache.values());
        Collections.sort(listValues);
        long oldElem = listValues.get(0); //oldest element

        String temp = null ;
        for (Map.Entry<String, Long> entry : cache.entrySet()) {
            if (entry.getValue() == oldElem) {
                temp = entry.getKey();
            }
        }
        return temp;
    }
}
