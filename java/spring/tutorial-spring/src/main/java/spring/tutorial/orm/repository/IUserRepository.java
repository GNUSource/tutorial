package spring.tutorial.orm.repository;


import spring.tutorial.orm.domain.User;

public interface IUserRepository {

    User getUserDetail(Integer id);
}
