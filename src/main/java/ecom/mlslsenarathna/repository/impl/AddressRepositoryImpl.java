package ecom.mlslsenarathna.repository.impl;

import ecom.mlslsenarathna.model.entity.CustomerEntity;
import ecom.mlslsenarathna.repository.AddressRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ecom.mlslsenarathna.model.entity.AddressEntity;

public class AddressRepositoryImpl implements AddressRepository {

    public AddressEntity getLastAddressId() {

            AddressEntity lastAddress = null;
            Transaction transaction = null;

            // ✅ Create SessionFactory using Hibernate’s built-in Configuration API
            try (Session session = new Configuration()
                    .configure("hibernate.cfg.xml") // loads from resources
                    .buildSessionFactory()
                    .openSession()) {

                transaction = session.beginTransaction();

                String hql = "FROM AddressEntity a ORDER BY a.addressId DESC";
                Query<AddressEntity> query = session.createQuery(hql, AddressEntity.class);
                query.setMaxResults(1);

                lastAddress = query.uniqueResult();

                transaction.commit();

            } catch (Exception e) {
                if (transaction != null) transaction.rollback();
                e.printStackTrace();
            }
             System.out.println(lastAddress);
            return lastAddress;
        }

    @Override
    public void registrationAddress(AddressEntity addressEntity) {
        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(ecom.mlslsenarathna.model.entity.AddressEntity.class);
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory=configuration.buildSessionFactory();
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.merge(addressEntity);
        transaction.commit();
    }

    @Override
    public AddressEntity getAddressById(String addressId) {
        AddressEntity addressEntity = null;
        Transaction transaction = null;


        try (Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();


            addressEntity= session.find(AddressEntity.class, addressId);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return addressEntity;
    }

    @Override
    public void updateAddress(AddressEntity addressEntity) {
        Transaction transaction = null;

        try (Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();
            session.merge(addressEntity);
            transaction.commit();
            System.out.println("✅ Customer updated successfully: " + addressEntity);


        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
