package org.czareg.codewars.aggregation.operations;

import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Java 8 has introduced a sexy new Stream API which makes it possible to solve some data related problems in just a few lines of code. Let's try it out!
You have a Student class (see the class declaration below).
You have an array of students and you want to get some aggregate data.
THE TASK: get the average grade for every department.
Implement the method using Java 8 Stream API.
Have Fun!
 */
@UtilityClass
public class Aggregation {

    public static Map<String, Double> getAverageGradeByDepartment(Stream<Student> students) {
        return students.collect(Collectors.groupingBy(Student::getDepartment, Collectors.averagingDouble(Student::getGrade)));
    }
}
