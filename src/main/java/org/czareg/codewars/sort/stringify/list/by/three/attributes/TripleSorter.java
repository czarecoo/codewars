package org.czareg.codewars.sort.stringify.list.by.three.attributes;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
Tale University is a bit messy, and can't maintain an ordered list of their student. Tale's dean wants to print a sortet list of his students by the gpa, last name and age and post it on the walls so everybody can be impressed of his great students.

Given a list of students, sort them by (from most important to least important):

GPA (descending)
First letter of last name (ascending)
Age (ascending)
Return the sorted result as full names string, comma separated.

For Example, given the list (name, age, gpa):

David Goodman, 23, 88
Mark Rose, 25, 82
Jane Doe, 22, 90
Jane Dane, 25, 90
sort(students) should return "Jane Doe,Jane Dane,David Goodman,Mark Rose"
 */
@UtilityClass
class TripleSorter {

    static String sort(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparingInt(Student::gpa).reversed()
                        .thenComparing(TripleSorter::getFirstLetterOfLastName)
                        .thenComparingInt(Student::age))
                .map(Student::fullName)
                .collect(Collectors.joining(","));
    }

    private static char getFirstLetterOfLastName(Student student) {
        String fullName = student.fullName();
        String[] split = fullName.split(" ");
        return split[1].charAt(0);
    }
}
