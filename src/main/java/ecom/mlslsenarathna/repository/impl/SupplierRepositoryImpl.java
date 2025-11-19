package ecom.mlslsenarathna.repository.impl;


import ecom.mlslsenarathna.model.entity.CustomerEntity;
import ecom.mlslsenarathna.model.entity.SupplierEntity;
import ecom.mlslsenarathna.repository.SupplierRepository;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class SupplierRepositoryImpl implements SupplierRepository {



    @Override
    public SupplierEntity getSupplierByID(String id) {
        SupplierEntity supplierEntity = null;
        Transaction transaction = null;

        try (Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();


            supplierEntity= session.find(SupplierEntity.class,id);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return supplierEntity;
    }

    @Override
    public SupplierEntity getLastSupplier() {
        SupplierEntity supplierEntity=null;
        Transaction transaction = null;


        try (Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();

            String hql = "FROM SupplierEntity s ORDER BY s.supplierId DESC";
            Query<SupplierEntity> query = session.createQuery(hql, SupplierEntity.class);
            query.setMaxResults(1);

            supplierEntity = query.uniqueResult();

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }

        return supplierEntity;
    }

    @Override
    public void registerNewSupplier(SupplierEntity supplierEntity) {
        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(ecom.mlslsenarathna.model.entity.SupplierEntity.class);
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory=configuration.buildSessionFactory();
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.merge(supplierEntity);
        transaction.commit();
    }

    @Override
    public void updateSupplierDetails(SupplierEntity supplierEntity) {
        Transaction transaction = null;

        try (Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();
            session.merge(supplierEntity);
            transaction.commit();



        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(SupplierEntity supplierEntity) {
        Transaction transaction = null;

        try (Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();
            session.remove(supplierEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<SupplierEntity> getAllSuppliers() {
        Transaction transaction = null;
        List<SupplierEntity> suppliers = null;

        try (Session session = new Configuration()
                .configure("hibernate.cfg.xml") // load from resources
                .buildSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();

            Query<SupplierEntity> query = session.createQuery("FROM SupplierEntity", SupplierEntity.class);
            suppliers = query.list();

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return suppliers;

    }


}
