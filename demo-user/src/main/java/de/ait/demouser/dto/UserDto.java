package de.ait.demouser.dto;

import de.ait.demouser.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    public String firstName;
    public String lastName;
//
//    public UserDto(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//    public UserDto() {}
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public static UserDto from(User user) {
        return new UserDto(user.getFirstName(), user.getLastName());
    }

    public static List<UserDto> from(List<User> users) {
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}
