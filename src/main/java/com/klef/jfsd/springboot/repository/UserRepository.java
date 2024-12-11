package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> 
{

    @Query("select u from User u where u.email=?1 and u.password=?2")
    public User checkuserlogin(String email, String password);
    
    @Query("update User u set u.status=?1 where u.id=?2")
	@Modifying // DML
	@Transactional // to enable auto commit
	public int updateUserStatus(String status, int uid);

    public List<User> findUsersByHealthConditions(String healthCondition);

    public List<User> findUsersByDietaryPreferences(String dietaryPreference);

    public List<User> findUsersByGenderAndHealthConditions(String gender, String healthCondition);

    public User findByEmail(String email);

    public List<User> findByStatus(String status);

	public List<User> findByNutritionistId(int nid);


}
