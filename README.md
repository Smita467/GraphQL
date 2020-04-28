
--
    query {

  findAllDevice {
        
         id
    
         userId

         carrierId

         deviceId
         
         deviceToken
         
         isActive
         
         deviceOs
         
         deviceOsVersion 
          }
    
}
--
    
    mutation newDevice($userId: String!, $carrierId: String!, $deviceId: String!, $deviceToken: String!, $isActive: Boolean, $deviceOs: String!, 
    $deviceOsVersion: String!)
     {

    newDevice(userId: $userId, carrierId: $carrierId, deviceId: $deviceId, deviceToken: $deviceToken,  isActive: $isActive, deviceOs: $deviceOs,  deviceOsVersion: $deviceOsVersion)
        {

                    id
        }
    }
    
    {
	    "userId" : "user101",
        
         "carrierId": "car101",

         "deviceId": "D101",
         
         "deviceToken" :"T101",
         
         "isActive" :true,
         
         "deviceOs" :"windows",
         
         "deviceOsVersion": "os1.1"
         
       }
--
    
    mutation updateUserDevice($id: ID!, $userId: String!, $carrierId: String!, $deviceId: String!, $deviceToken: String!, $isActive: Boolean, $deviceOs: String!, 
    $deviceOsVersion: String!) 
    {

    updateUserDevice(id : $id, userId: $userId, carrierId: $carrierId, deviceId: $deviceId, deviceToken: $deviceToken,  isActive: $isActive, deviceOs: $deviceOs, 
        deviceOsVersion: $deviceOsVersion)
        {
            id
        }
        
    }

    {
	    "userId" : "user101",
        
         "carrierId": "car101",

         "deviceId": "D101",
         
         "deviceToken" :"T101",
         
         "isActive" :true,
         
         "deviceOs" :"Linux",
         
         "deviceOsVersion": "os1.1",

         "id": 1
         
       }
    
    
    
--

   mutation deleteUserDevice($userId: String!) {

    deleteUserDevice(userId : $userId)
}

{

         "userId" : "user101"
}
--
query {
   getDeviceDetails (input: {
        
         userId: null
         carrierId: "car102"
  }){
         id
    
         userId

         carrierId

         deviceId
         
         deviceToken
         
         isActive
         
         deviceOs
         
         deviceOsVersion
        
    }     
 }
    
-----------------------------

    # GraphQL
