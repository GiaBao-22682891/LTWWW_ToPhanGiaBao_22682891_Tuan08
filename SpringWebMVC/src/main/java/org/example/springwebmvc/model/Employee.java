package org.example.springwebmvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.example.springwebmvc.model.enumerate.Gender;

import java.time.LocalDate;

@Data
//Dùng getter/setter nếu @Data ko chạy
//@Getter
//@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "First name can't not be left empty")
    @Column (name = "first_name")
    private String firstName;

    @NotEmpty(message = "Last name can't not be left empty")
    @Column (name = "last_name")
    private String lastName;

    private Gender gender;

    private String email;

    @Column (name = "birth_date")
    private LocalDate birthDate;

    @NotEmpty(message = "Phone can't not be left empty")
    private String phone;

    private String address;

}
