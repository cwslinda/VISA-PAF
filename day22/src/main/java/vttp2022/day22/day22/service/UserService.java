package vttp2022.day22.day22.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.day22.day22.model.User;
import vttp2022.day22.day22.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;

    public boolean createUser(final User user) throws Exception{
        int count = userRepo.createUser(user);
        System.out.printf("Insert count: %d\n", count);
        return count > 0;
    }

    public boolean validateUser(User user) throws Exception{
        boolean result = userRepo.validateUser(user);
       
       return result;
    }
}
