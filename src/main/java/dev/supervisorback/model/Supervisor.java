package dev.supervisorback.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of = {"identificationNumber"})
@ToString
public class Supervisor {
     String id;
     String phone;
     String jurisdiction;
     String identificationNumber;
     String firstName;
     String lastName;

    // Getters and Setters
}

