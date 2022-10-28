package com.fareye.training.service;

import com.fareye.training.model.User;
import com.fareye.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
   @Autowired
   UserRepository userRepository;

   public List<User> getAllUsers(){
       return userRepository.findAll();
   }

   public User getUser(Long id){
      return userRepository.getReferenceById(id);
   }

   public void addUser(User user){
      userRepository.save(user);
   }

   public void deleteUser(Long id){
      userRepository.deleteById(id);
   }

   public void updateUser(User user){

      Optional<User> optional=userRepository.findById(user.getId());
      if(optional.isPresent())
      {
         User user1=optional.get();
         user.setEmail(user.getEmail());
         user.setFirstName(user.getFirstName());
         user.setLastName(user.getLastName());
         user.setPassword(user.getPassword());
         user.setVerified(user.isVerified());
      }else{
         new EntityNotFoundException(user.getId().toString());
      }
   }

}
