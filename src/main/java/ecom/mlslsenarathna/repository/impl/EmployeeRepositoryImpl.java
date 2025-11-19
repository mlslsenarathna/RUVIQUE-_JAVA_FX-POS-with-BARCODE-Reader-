package ecom.mlslsenarathna.repository.impl;

import ecom.mlslsenarathna.model.entity.CustomerEntity;
import ecom.mlslsenarathna.model.entity.EmployeeEntity;
import ecom.mlslsenarathna.repository.EmployeeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EmployeeRepositoryImpl implements EmployeeRepository {


    @Override
    public EmployeeEntity getLastEmployee() {
        EmployeeEntity employeeEntity = null;
        Transaction transaction = null;

        try (Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();

            String hql = "FROM  EmployeeEntity e ORDER BY e.employeeId  DESC";
            Query<EmployeeEntity> query = session.createQuery(hql, EmployeeEntity.class);
            query.setMaxResults(1);

            employeeEntity = query.uniqueResult();

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        System.out.println(employeeEntity);
        return employeeEntity;
    }

    @Override
    public void registerEmployee(EmployeeEntity employeeEntity) {
        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(ecom.mlslsenarathna.model.entity.EmployeeEntity.class);
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory=configuration.buildSessionFactory();
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.merge(employeeEntity);
        transaction.commit();

    }
}
