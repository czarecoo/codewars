package org.czareg.codewars.aggregation.operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AggregationTest {

    private Student[] students;
    private Student[] randomStudents;

    @BeforeEach
    void setUp() {
        Student galina = new Student("Galina", 95, "Philology", Student.Gender.FEMALE);
        Student anton = new Student("Anton", 90, "CS", Student.Gender.MALE);
        Student jack = new Student("Jack", 82, "Philology", Student.Gender.MALE);
        Student mike = new Student("Mike", 60, "Philology", Student.Gender.MALE);
        Student jane = new Student("Jane", 65, "CS", Student.Gender.FEMALE);

        students = new Student[]{galina, anton, jack, mike, jane};

        Student.Gender[] genders = Student.Gender.values();

        int randomLength = (int) (Math.random() * 100 + 1);
        randomStudents = new Student[randomLength];

        for (int i = 0; i < randomStudents.length; i++) {
            int randomNameNum = (int) (Math.random() * 1000);
            int randomDepartmentNum = (int) (Math.random() * 10);
            int randomGenderIndex = (int) (Math.random() * 2);
            String name = "Student" + randomNameNum;
            double grade = Math.random() * (100 - 40) + 40;
            String department = "Department" + randomDepartmentNum;
            Student.Gender gender = genders[randomGenderIndex];
            randomStudents[i] = new Student(name, grade, department, gender);
        }
    }

    @Test
    void basicTestGetAverageGradeByDepartment() {
        Map<String, Double> actual = Aggregation.getAverageGradeByDepartment(Arrays.stream(students));
        Map<String, Double> expected = new HashMap<>();
        expected.put("CS", 77.5);
        expected.put("Philology", 79.0);
        assertEqualsWithTolerance(expected, actual);
    }

    @Test
    void randomTestGetAverageGradeByDepartment() {
        Map<String, Double> expected = Stream.of(randomStudents)
                .collect(Collectors.groupingBy(Student::getDepartment,
                        Collectors.averagingDouble(Student::getGrade)));
        Map<String, Double> actual = Aggregation.getAverageGradeByDepartment(Arrays.stream(randomStudents));
        assertEqualsWithTolerance(expected, actual);
    }

    void assertEqualsWithTolerance(Map<String, Double> expected, Map<String, Double> actual) {
        assertEquals(expected.size(), actual.size());
        for (var entry : expected.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            assertTrue(actual.containsKey(key));
            var actualValue = actual.get(key);
            assertTrue(Math.abs(actualValue - value) < 1e-6);
        }
    }
}