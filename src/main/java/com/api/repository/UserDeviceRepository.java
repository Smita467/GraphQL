package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.api.model.UserDevice;

//public interface UserDeviceRepository extends CrudRepository<UserDevice, Integer> {
	public interface UserDeviceRepository extends JpaRepository<UserDevice, Integer> {

	
	Integer deleteByUserId(String userId);
	
	@Query("SELECT ud FROM UserDevice ud where userId=:userId and carrierId=:carrierId")
	UserDevice fetchDetails(@Param("userId") String userId,@Param("carrierId") String carrierId);
}
