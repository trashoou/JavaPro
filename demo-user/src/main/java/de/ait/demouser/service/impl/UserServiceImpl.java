package de.ait.demouser.service.impl;


import de.ait.demouser.dto.NewUserDTO;
import de.ait.demouser.dto.UserDto;
import de.ait.demouser.model.User;
import de.ait.demouser.repository.UserRepository;
import de.ait.demouser.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(@Qualifier("userRepositoryFileImpl") UserRepository userRepository){
        this.userRepository = userRepository;
    }

//    @Override
//    public User addUser(String firstName, String lastName, String email, String password) {
//
//        User user = new User(firstName, lastName, email, password);
//        userRepository.save(user);
//
//        return user;
//    }
    // После добавления DTO



    @Override
    public List<UserDto> getAllUsers() {

//        List<User> users = userRepository.findAll();
//        List<UserDto> userDtos = new ArrayList<>();
//
//        for (User user : users) {
//            UserDto userDto = new UserDto(user.getFirstName(),user.getLastName());
//            userDtos.add(userDto);
//        }
//        return userDtos;

        return UserDto.from(userRepository.findAll());
    }


    public UserDto addUser(NewUserDTO newUser) {
        User user = new User(newUser.getFirstName(),
                newUser.getLastName(),
                newUser.getEmail(),
                newUser.getPassword());
        userRepository.save(user);

//        return new UserDto(user.getFirstName(),user.getLastName());
        return UserDto.from(user);
    }
}
