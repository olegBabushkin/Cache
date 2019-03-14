package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;


public class DataBaseCache1<K, V> implements IDataBase<K, V> {
    private static DataBaseCache1 instance;
    private SessionFactory sessionFactory;
    private PojoClass<K, V> pojo;

    private DataBaseCache1() {
        this.sessionFactory = SessionFactoryUtil.getSessionFact();
    }

    public static DataBaseCache1 getDataBase1() {
        if (instance == null) {
            instance = new DataBaseCache1();
        }
        return instance;
    }

    @Override
    public void add(K key, V value) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            pojo = new PojoClass(key, value);
            session.save(pojo);
            transaction.commit();
        }
    }

    @Override
    public void deleteOldest(K key) {

        //Criteria

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaDelete<PojoClass> cq = cb.createCriteriaDelete(PojoClass.class);
            Root<PojoClass> authorRoot = cq.from(PojoClass.class);
            cq.where(cb.equal(authorRoot.get("key"), key));

            Query query = session.createQuery(cq);
            int rows = query.executeUpdate();
            System.out.format("Delete %d rows \n", rows);
            transaction.commit();
        }

        //HQL

        /*Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM PojoClass WHERE key =:oldkey");
        query.setParameter("oldkey", key);
        int rows = query.executeUpdate();
        transaction.commit();
        session.close();*/

    }

    @Override
    public V get(K key) {

        //Criteria

        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<PojoClass> cq = cb.createQuery(PojoClass.class);
            Root<PojoClass> authorRoot = cq.from(PojoClass.class);
            Selection[] selections = {authorRoot.get("key")};
            cq.select(cb.construct(PojoClass.class, selections)).where(cb.equal(authorRoot.get("key"), key));

            Query query = session.createQuery(cq);
            List<PojoClass> authorList = query.getResultList();

            return (V) authorList.get(0).getValue();
        }

        //HQL

       /* Session session = sessionFactory.openSession();
        Query query = session.createQuery("SELECT value FROM PojoClass WHERE key = :param");
        query.setParameter("param", key);
        List<PojoClass> list = query.getResultList();
        session.close();
        return (V)list.get(0).getValue();*/
    }
}
