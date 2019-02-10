//point of entry
public interface ICache {
    void putInclusive (String date);
    void putExclusive (String date);
    String get (String date);
}
