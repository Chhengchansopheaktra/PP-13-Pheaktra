package com.hrd.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hrd.model.Dashboard;
import com.hrd.model.User;

@Repository
public interface UserRepository {
	
	@Select("select "
			+"COUNT(*) as total, "
			+"COUNT(case when users.gender='m' then 1 end) as male, "
			+"COUNT(case when users.gender='f' then 1 end) as female "
			+"from users" )
	@Results(value={
			@Result(property="total" , column="total"),
			@Result(property="male" , column="male"),
			@Result(property="female" , column="female"),
	})
	public List<Dashboard> countGender();
	

	@Select("SELECT "
			+ "	id, "
			+ "	username, "
			+ "	email, "
			+ "	gender, "
			+ " phonenumber,"
			+ " status,"
			+ "	user_hash,"
			+ "	created_date"
			+ " FROM "
			+ "	users")
	@Results(value={
			@Result(property="userHash" , column="user_hash"),
			@Result(property="createdDate" , column="created_date"),
	})
	public List<User> findAll();
	
	
	@Select("SELECT "
			+ "	id, "
			+ "	username, "
			+ "	email, "
			+ "	gender, "
			+ " phonenumber,"
			+ " status,"
			+ "	user_hash,"
			+ "	created_date"
			+ " FROM "
			+ "	users WHERE user_hash = #{user.userHash}")
	@Results(value={
			@Result(property="userHash" , column="user_hash"),
			@Result(property="createdDate" , column="created_date"),
	})
	public List<User> findByUserHash(@Param("user") User user);
	
	/**
	 * Save user to database
	 * @param user
	 * @return
	 */
	@Insert("INSERT INTO users ("
			+ "	username, "
			+ "	email, "
			+ "	gender, "
			+ " phonenumber,"
			+ " status,"
			+ "	user_hash,"
			+ "	created_date"
			+ "	) VALUES ("
			+ "	#{user.username},"
			+ "	#{user.email},"
			+ "	#{user.gender},"
			+ " #{user.phoneNumber},"
			+ " #{user.status},"
			+ "	#{user.userHash}, "
			+ " #{user.createdDate}"
			+ ")")
//	@SelectKey(
//			statement="SELECT last_value FROM users_id_seq",
//			keyProperty="user.id", keyColumn="last_value",
//			before=false,
//			resultType=int.class
//	)
	public boolean save(@Param("user") User user);
	
	@Delete("DELETE FROM users WHERE user_hash=#{user_hash}")
	public boolean delete(@Param("user_hash") String userHash);
	
	@Update("UPDATE users SET "
			+ "username=#{user.username},"
			+ "email=#{user.email},"
			+ "gender=#{user.gender},"
			+ "phonenumber=#{user.phoneNumber}"
			+ " WHERE user_hash=#{user.userHash}")
	public boolean update(@Param("user") User user);
	
	
	@Insert("<script>"
			+ "	INSERT INTO users ("
			+ "		username, "
			+ "		email, "
			+ "		password, "
			+ "		gender"
			+ "	) VALUES "
			+ " <foreach collection='users' item='user' separator=','>("
			+ "	#{user.username},"
			+ "	#{user.email},"
			+ "	#{user.password},"
			+ "	#{user.gender}"
			+ "	) "
			+ "</foreach>"
			+ "</script>")
	public boolean saveBatch(@Param("users") List<User> users);


}
