package org.example.springwebmvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.example.springwebmvc.model.enumerate.Gender;

import java.time.LocalDate;

//@Data
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotEmpty(message = "First name can't not be left empty") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotEmpty(message = "First name can't not be left empty") String firstName) {
        this.firstName = firstName;
    }

    public @NotEmpty(message = "Last name can't not be left empty") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotEmpty(message = "Last name can't not be left empty") String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public @NotEmpty(message = "Phone can't not be left empty") String getPhone() {
        return phone;
    }

    public void setPhone(@NotEmpty(message = "Phone can't not be left empty") String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
