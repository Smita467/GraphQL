package com.api.resolver;

import com.api.model.UserDevice;
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
    	UserDevice users=(UserDevice) userRepository.findAll();
    	System.out.println("getting data from db"+ users );
//        return userRepository.findAll();
    	return (Iterable<UserDevice>) users;
    }


}
