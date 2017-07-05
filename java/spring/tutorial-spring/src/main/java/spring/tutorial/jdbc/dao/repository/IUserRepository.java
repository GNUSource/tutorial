package spring.tutorial.jdbc.dao.repository;

import java.util.List;

import spring.tutorial.jdbc.dao.User;

public interface IUserRepository {


	List<User> getUserList(Integer userId);

	User getUserDetail(Integer userId);

}
