package org.czareg.codewars.sort.stringify.list.by.three.attributes;


record Student(int age, int gpa, String fullName) {

    Student {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age should be above 0 and below 150");
        }
        String[] split = fullName.split(" ");
        if (split.length != 2) {
            throw new IllegalArgumentException("Full name should consist of first name and last name only");
        }
    }
}
