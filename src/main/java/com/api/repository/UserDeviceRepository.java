package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.api.model.UserDevice;

//public interface UserDeviceRepository extends CrudRepository<UserDevice, Integer> {
	public interface UserDeviceRepository extends JpaRepository<UserDevice, Integer> {

	Integer deleteByUserId(String userId);
}
