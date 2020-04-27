package com.api.resolver;


import com.api.model.UserDevice;
import com.api.model.UserDeviceDTO;
import com.api.repository.UserDeviceRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;


import org.springframework.beans.factory.annotation.Autowired;

public class Query implements GraphQLQueryResolver {


    private UserDeviceRepository userRepository;

    @Autowired
    public Query(UserDeviceRepository userRepository) {
        
        this.userRepository =userRepository;
    }
    
    public Iterable<UserDevice> findAllDevice(){

    	return userRepository.findAll();
    }
   
    public UserDevice getDeviceDetails(UserDeviceDTO user1)
    {
    	
    return userRepository.fetchDetails(user1.getCarrierId(),user1.getDeviceId());
    	
    }
    
   
}

















////UserDevice user1=new UserDevice(sam.getUserId(),sam.getCarrierId(),sam.getDeviceId());
