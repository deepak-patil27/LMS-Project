package com.bridgelabz.admin.entity;

import com.bridgelabz.admin.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name="UserDetails")
public class User {
    @Id
    @GeneratedValue
    private Integer userID;
    private  String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private String address;
    private String password;
    private String profilePath;
    private boolean status;

    public User(UserDTO dto) {
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.mobile = dto.getMobile();
        this.email = dto.getEmail();
        this.address = dto.getAddress();
        this.password = dto.getPassword();
        this.profilePath=dto.getProfilePath();
//        this.status = dto.getStatus();
    }
    public User(Integer userID, UserDTO dto) {
        this.userID=userID;
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.mobile = dto.getMobile();
        this.email = dto.getEmail();
        this.address = dto.getAddress();
        this.password = dto.getPassword();
        this.profilePath=dto.getProfilePath();
//        this.status = dto.getStatus();
    }


}
