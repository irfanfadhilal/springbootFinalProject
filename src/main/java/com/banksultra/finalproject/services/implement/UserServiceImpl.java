package com.banksultra.finalproject.services.implement;

import com.banksultra.finalproject.models.User;
import com.banksultra.finalproject.repositories.UserRepository;
import com.banksultra.finalproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User signUp(User user) {
        //Save user
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        //Save user_role
        User getUser = userRepository.sqlFindDataByEmail(user.getEmail());
        Long userId = getUser.getId();
        Long roleId = 2L;
        userRepository.sqlInsertUserRole(userId, roleId);

        return user;
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id){
        return userRepository.findById(id);
    }

    @Override
    public User updateData(Long id, User user){
        User userCheck = userRepository.findById(id);

        if(userCheck != null) {
            user.setId(id);
            if(user.getEmail() == null) user.setEmail(userCheck.getEmail());
            if(user.getFirst_name() == null) user.setFirst_name(userCheck.getFirst_name());
            if(user.getLast_name() == null) user.setLast_name(userCheck.getLast_name());
            if(user.getMobile_number() == null) user.setMobile_number(userCheck.getMobile_number());
            user.setRoles(userCheck.getRoles());

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if(user.getPassword() == null) {
                user.setPassword(userCheck.getPassword());
            } else {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            return userRepository.save(user);
        }else{
            return null;
        }
    }
}
