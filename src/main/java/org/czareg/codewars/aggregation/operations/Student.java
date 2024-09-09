package org.czareg.codewars.aggregation.operations;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Student {

    private String name;
    private double grade;
    private String department;
    private Gender gender;

    public enum Gender {
        MALE, FEMALE
    }
}
