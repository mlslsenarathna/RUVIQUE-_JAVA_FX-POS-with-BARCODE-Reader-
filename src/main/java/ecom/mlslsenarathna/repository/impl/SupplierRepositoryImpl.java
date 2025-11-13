package ecom.mlslsenarathna.repository.impl;

import ecom.mlslsenarathna.model.entity.ItemEntity;
import ecom.mlslsenarathna.model.entity.SupplierEntity;
import ecom.mlslsenarathna.repository.SupplierRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
}
