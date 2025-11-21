package ecom.mlslsenarathna.repository.impl;

import ecom.mlslsenarathna.model.entity.AddressEntity;
import ecom.mlslsenarathna.model.entity.OrderEntity;
import ecom.mlslsenarathna.repository.OrderRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public OrderEntity getlastOrder() {
        OrderEntity lastOrder= null;
        Transaction transaction = null;


        try (Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();

            String hql = "FROM order a ORDER BY a.orderId DESC";
            Query<OrderEntity> query = session.createQuery(hql, OrderEntity.class);
            query.setMaxResults(1);

            lastOrder = query.uniqueResult();

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        System.out.println("Last"+lastOrder);
        return lastOrder;
    }

    @Override
    public void placeNewOrder(OrderEntity orderEntity) {
        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(ecom.mlslsenarathna.model.entity.OrderEntity.class);
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory=configuration.buildSessionFactory();
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.merge(orderEntity);
        transaction.commit();
    }

}
