package spring.tutorial.orm.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.tutorial.orm.domain.User;
import spring.tutorial.orm.repository.IUserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserRepository implements IUserRepository {

    /**
     * 真正的EntityManager是与当前事务相关联的那一个，如果不
     * 存在这样的EntityManager的话，就会创建一个新的。这样的话，我们就能始终以线程安全
     * 的方式使用实体管理器。
     */
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserDetail(Integer id) {
        return entityManager.find(User.class, id);
    }
}
