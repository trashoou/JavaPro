package de.ait.demouser.controller;

import de.ait.demouser.dto.NewUserDTO;
import de.ait.demouser.dto.UserDto;
import de.ait.demouser.model.User;
import de.ait.demouser.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Tags(value = @Tag(name = "Users"))
@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


//    @PostMapping("/signUp")
//    public String addUser(@RequestParam("inputFirstName")String firstName,
//                          @RequestParam("inputLastName")String lastName,
//                          @RequestParam("inputEmail")String email,
//                          @RequestParam("inputPassword")String password)
//    {
//        userService.addUser(firstName, lastName, email, password);
//
//        System.out.println(firstName+" "+lastName+" "+email+" "+password);
//
//        return "redirect:/success_signUp.html";
//    }
    // после добавления DTO:




    @Operation(summary = "Get all users", description = "available for administrator")
    @GetMapping("/users")
    @ResponseBody // означает, что метод будет возвращать не название страницы, а JSON-объект
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    @ResponseBody
    public UserDto addUser(@RequestBody NewUserDTO newUser) { // RequestBody - return json
        return userService.addUser(newUser);
    }
}
