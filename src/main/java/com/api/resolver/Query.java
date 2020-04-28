package com.api.resolver;


import com.api.model.UserDevice;
import com.api.model.UserDeviceDTO;
import com.api.repository.UserDeviceRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.List;
import java.util.Optional;

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
   
    public List<UserDevice> getDeviceDetails(UserDeviceDTO user1) {
    	if(user1.getUserId()==null)
    	{
    		return userRepository.fetchDetailsByCarrierID(user1.getCarrierId());
    	}
    	else
    	{
    		return userRepository.fetchDetails(user1.getUserId(),user1.getCarrierId());
    	}
		


	}
    
   
}



















