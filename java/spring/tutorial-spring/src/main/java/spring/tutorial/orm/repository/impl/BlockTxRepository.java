package spring.tutorial.orm.repository.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import spring.tutorial.orm.domain.BlockTx;
import spring.tutorial.orm.repository.IBlockTxRepository;

import java.util.List;

//@Repository
@SuppressWarnings({"unused", "unchecked"})
public class BlockTxRepository implements IBlockTxRepository {

    // 使用 SessionFactory 来获取 Session
    private SessionFactory sessionFactory;

    public BlockTxRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        // TODO: 使用 @EnableTransactionManagement 和 @Transactional 来管理事物
        try {
            return this.sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            return this.sessionFactory.openSession();
        }
//        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public List<BlockTx> findAll() {
        return listAndCast(currentSession().createQuery("from BlockTx"));
    }

    private static <T> List<T> listAndCast(Query q) {
        return q.list();
    }
}
