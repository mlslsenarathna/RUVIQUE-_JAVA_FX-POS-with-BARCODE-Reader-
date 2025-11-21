package ecom.mlslsenarathna.repository.impl;

import ecom.mlslsenarathna.model.entity.OrderInfoEntity;
import ecom.mlslsenarathna.repository.OrderInfoRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OrderInfoRepositoryImpl implements OrderInfoRepository {


    @Override
    public void insertOrderInfo(OrderInfoEntity orderInfoEntity) {
        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(ecom.mlslsenarathna.model.entity.OrderInfoEntity.class);
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory=configuration.buildSessionFactory();
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.merge(orderInfoEntity);
        transaction.commit();
    }
}
