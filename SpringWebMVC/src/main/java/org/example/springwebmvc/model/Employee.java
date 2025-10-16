package org.example.springwebmvc.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
//@Getter     Dùng getter/setter nếu @Data ko chạy
//@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;
    private String email;

    @Column (name = "birth_date")
    private LocalDate birthDate;
    private String phone;

}
