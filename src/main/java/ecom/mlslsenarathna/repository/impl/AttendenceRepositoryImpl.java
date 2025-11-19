package ecom.mlslsenarathna.repository.impl;


import ecom.mlslsenarathna.model.entity.AddressEntity;
import ecom.mlslsenarathna.model.entity.AttendenceEntity;
import ecom.mlslsenarathna.model.entity.CustomerEntity;
import ecom.mlslsenarathna.repository.AttendenceRepository;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class AttendenceRepositoryImpl implements AttendenceRepository {


    public AttendenceEntity getLastAttendence(){
        AttendenceEntity attendenceEntity = null;
        Transaction transaction = null;


        try (Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();

            String hql = "FROM AttendenceEntity a ORDER BY a.att DESC";
            Query<AttendenceEntity> query = session.createQuery(hql, AttendenceEntity.class);
            query.setMaxResults(1);

           attendenceEntity = query.uniqueResult();

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        System.out.println(attendenceEntity);
        return attendenceEntity;
    }

    @Override
    public List<AttendenceEntity> getAllAttendence() {
        Transaction transaction = null;
        List<AttendenceEntity> attendence = null;

        try (Session session = new Configuration()
                .configure("hibernate.cfg.xml") // load from resources
                .buildSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();

            Query<AttendenceEntity> query = session.createQuery("FROM AttendenceEntity", AttendenceEntity.class);
            attendence = query.list();

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return attendence;
    }

    @Override
    public void setAttendenceOn(AttendenceEntity attendenceEntity) {
        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(ecom.mlslsenarathna.model.entity.AttendenceEntity.class);
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory=configuration.buildSessionFactory();
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.merge(attendenceEntity);
        transaction.commit();
    }
}
