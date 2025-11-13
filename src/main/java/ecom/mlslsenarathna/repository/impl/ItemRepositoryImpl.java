package ecom.mlslsenarathna.repository.impl;


import ecom.mlslsenarathna.model.entity.CustomerEntity;
import ecom.mlslsenarathna.model.entity.ItemEntity;
import ecom.mlslsenarathna.repository.ItemRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ItemRepositoryImpl implements ItemRepository {
    @Override
    public ItemEntity getLastItem() {
        ItemEntity itemEntity = null;
        Transaction transaction = null;
        Session session = null;

        try {
            session = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory()
                    .openSession();

            transaction = session.beginTransaction();
            String hql = "FROM ItemEntity i ORDER BY i.itemId DESC";
            Query<ItemEntity> query = session.createQuery(hql,ItemEntity.class);
            query.setMaxResults(1);

            itemEntity = query.uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (session != null) session.close(); // ✅ close session safely here
        }

        return itemEntity;


    }

    @Override
    public void registerNewItem(ItemEntity itemEntity) {
        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(ecom.mlslsenarathna.model.entity.ItemEntity.class);
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory=configuration.buildSessionFactory();
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.merge(itemEntity);
        transaction.commit();
    }

    @Override
    public ItemEntity getItemByID(String text) {
        ItemEntity itemEntity = null;
        Transaction transaction = null;

        try (Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();


            itemEntity= session.find(ItemEntity.class,text);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return itemEntity;
    }

    @Override
    public void updateItemById(ItemEntity itemEntity) {
        Transaction transaction = null;

        try (Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();
            session.merge(itemEntity);
            transaction.commit();



        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(ItemEntity itemEntity) {
        Transaction transaction = null;

        try (Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();
            session.remove(itemEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public List<ItemEntity> getItemsList() {
        Transaction transaction = null;
        List<ItemEntity> items = null;

        try (Session session = new Configuration()
                .configure("hibernate.cfg.xml") // load from resources
                .buildSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();

            Query<ItemEntity> query = session.createQuery("FROM ItemEntity", ItemEntity.class);
            items = query.list();

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }
}



