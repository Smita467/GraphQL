package com.api.model;


import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
@Entity
public class UserDevice extends Auditable  {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String userId;
	private String carrierId;
	private String deviceId;
	private String deviceToken;
	private Boolean isActive;
	private String deviceOs;
	private String deviceOsVersion;
//	private LocalDateTime createdDateTime;
//	private LocalDateTime updatedDateTime;

	
	

	public UserDevice() {
		super();
	}
	
	
//	public LocalDateTime getCreatedDateTime() {
//		return createdDateTime;
//	}
//
//
//	public void setCreatedDateTime(LocalDateTime createdDateTime) {
//		this.createdDateTime = createdDateTime;
//	}
//
//
//	public LocalDateTime getUpdatedDateTime() {
//		return updatedDateTime;
//	}
//
//
//	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
//		this.updatedDateTime = updatedDateTime;
//	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceToken() {
		return deviceToken;
	}
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
	
	public String getDeviceOs() {
		return deviceOs;
	}
	public void setDeviceOs(String deviceOs) {
		this.deviceOs = deviceOs;
	}
	
	public String getDeviceOsVersion() {
		return deviceOsVersion;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setDeviceOsVersion(String deviceOsVersion) {
		this.deviceOsVersion = deviceOsVersion;
	}


	public UserDevice(String userId, String carrierId, String deviceId, String deviceToken, Boolean isActive,
			String deviceOs, String deviceOsVersion) {
		super();
		this.userId = userId;
		this.carrierId = carrierId;
		this.deviceId = deviceId;
		this.deviceToken = deviceToken;
		this.isActive = isActive;
		this.deviceOs = deviceOs;
		this.deviceOsVersion = deviceOsVersion;
		
	}
	
	
	
	
	
}
