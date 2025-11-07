package ecom.mlslsenarathna.repository.impl;

import ecom.mlslsenarathna.model.entity.AddressEntity;
import ecom.mlslsenarathna.model.entity.CustomerEntity;
import ecom.mlslsenarathna.repository.CustomerRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public void customerRegistration(CustomerEntity customerEntity) {
        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(ecom.mlslsenarathna.model.entity.CustomerEntity.class);
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory=configuration.buildSessionFactory();
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.merge(customerEntity);
        transaction.commit();
    }
    public CustomerEntity getLastCustomer(){

        CustomerEntity customerEntity = null;
        Transaction transaction = null;

        try (Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();

            String hql = "FROM CustomerEntity c ORDER BY c.custId DESC";
            Query<CustomerEntity> query = session.createQuery(hql, CustomerEntity.class);
            query.setMaxResults(1);

            customerEntity = query.uniqueResult();

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        System.out.println(customerEntity);
        return customerEntity;
    }

    @Override
    public CustomerEntity searchCustomerById(String input) {
            CustomerEntity customerEntity = null;
            Transaction transaction = null;


            try (Session session = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory()
                    .openSession()) {

                transaction = session.beginTransaction();


                customerEntity = session.find(CustomerEntity.class, input);

                transaction.commit();

            } catch (Exception e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }

            return customerEntity;
        }

    @Override
    public CustomerEntity searchCustomerByMobile(String input) {
        Transaction transaction = null;
        CustomerEntity customer = null;

        try (Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();

            String hql = "FROM CustomerEntity c WHERE c.custMobile = :mobile";
            Query<CustomerEntity> query = session.createQuery(hql, CustomerEntity.class);
            query.setParameter("mobile", input);
            customer = query.uniqueResult();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void updateCustomerByID(CustomerEntity customerEntity) {
        Transaction transaction = null;

        try (Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();
            session.merge(customerEntity);
            transaction.commit();
            System.out.println("✅ Customer updated successfully: " + customerEntity);


        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }


}
