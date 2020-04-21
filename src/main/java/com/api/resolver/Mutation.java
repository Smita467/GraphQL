package com.api.resolver;

import com.api.model.UserDevice;
import com.api.repository.UserDeviceRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Transactional
public class Mutation implements GraphQLMutationResolver {

    @PersistenceContext
    private EntityManager entityManager;

    private UserDeviceRepository userRepository;

    
    @Autowired
    public Mutation(UserDeviceRepository userRepository) {
        
        this.userRepository = userRepository;
    }
    
   //Insert Operation

    public UserDevice newDevice(String userId,String carrierId, String deviceId,String deviceToken, Boolean isActive,String deviceOs,String deviceOsVersion) {
    	UserDevice device = new UserDevice(userId,carrierId,deviceId,deviceToken,isActive,deviceOs,deviceOsVersion);
        return userRepository.save(device);
    }
    
    //DELETE Operation
    public boolean deleteUserDevice(String userId) {
    	return userRepository.deleteByUserId(userId) > 0;
    	
    }
    
    //Update Operation
    public UserDevice updateUserDevice(int id,String userId,String carrierId, String deviceId,String deviceToken, Boolean isActive,String deviceOs,String deviceOsVersion) {
     
      Optional<UserDevice> userObj = userRepository.findById(id);

      UserDevice userObj1 = userObj.get();
      userObj1.setUserId(userId);
      userObj1.setCarrierId(carrierId);
      userObj1.setDeviceId(deviceId);
      userObj1.setDeviceToken(deviceToken);
      userObj1.setIsActive(isActive);
      userObj1.setDeviceOs(deviceOs);
      userObj1.setDeviceOsVersion(deviceOsVersion);
     

      return userRepository.save(userObj1);
  }
    
   
}