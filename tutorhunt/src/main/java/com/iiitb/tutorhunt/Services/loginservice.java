package com.iiitb.tutorhunt.Services;

import com.iiitb.tutorhunt.Repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class loginservice implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    public List<com.iiitb.tutorhunt.Models.User> getAll(){
        return repo.findAll();

    }


    public boolean registerUser(com.iiitb.tutorhunt.Models.User student){
        try{
           // System.out.print(student.getSession_id());
//            String salt = BCrypt.gensalt();
//            String hashedPass = BCrypt.hashpw(student.getPassword(),salt);
//            //student.setPassword(hashedPass);
            repo.save(student);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return false;
        }


    }

    public com.iiitb.tutorhunt.Models.User checkcredentials(String username, String password,String role){
        com.iiitb.tutorhunt.Models.User user = findByUsername(username);

        if(user == null){
            return null;
        }
        else if(user.getRole().equals(role)){
            return null;
        }
        else if(BCrypt.checkpw(password,user.getPassword())){
            return user;
        }
        else{
            return null;
        }
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        com.iiitb.tutorhunt.Models.User user =findByUsername(username);

        if(user!=null){

            return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
        }
        else{
            return new User("","",new ArrayList<>());
            //throw new UsernameNotFoundException("User not found with username: "+ username);
        }
    }
    public com.iiitb.tutorhunt.Models.User findByUsername(String username) {
        List<com.iiitb.tutorhunt.Models.User> users = getAll();
        com.iiitb.tutorhunt.Models.User us = null;
        for (com.iiitb.tutorhunt.Models.User s : users) {
            if (s.getUsername().equalsIgnoreCase(username)) {
                us = s;
                //System.out.println(us.getEmail());
                break;
            }
        }
        return us;
    }


}
