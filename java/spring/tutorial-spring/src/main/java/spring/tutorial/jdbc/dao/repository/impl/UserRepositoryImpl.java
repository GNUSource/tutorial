package spring.tutorial.jdbc.dao.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.tutorial.jdbc.dao.User;
import spring.tutorial.jdbc.dao.repository.IUserRepository;

@Repository
public class UserRepositoryImpl implements IUserRepository {
	
	@Autowired
	private JdbcOperations jdbcOperations;
	
	/**
	 * 查询用户列表
	 * 
	 * @author hkf
	 */
	@Override
	public List<User> getUserList(Integer userId) {
		List<User> users = new ArrayList<User>();
		
		String sql = "select * from user where id > ?";
		users = jdbcOperations.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setMail(rs.getString("mail"));
					return user;
				}
				return null;
			}
			
		}, new Object[]{userId});
		
		
		return users;
	}
	
	/**
	 * 查询用户详情
	 * 
	 * @author hkf
	 */
	@Override
	public User getUserDetail(Integer userId) {
		String sql = "select * from user where id = ?";
		User user = jdbcOperations.queryForObject(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs != null) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setMail(rs.getString("mail"));
					return user;
				}
				return null;
			}
			
		}, new Object[]{userId});
		
		return user;
	}

}
