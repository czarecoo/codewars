package org.czareg.codewars.sort.stringify.list.by.three.attributes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TripleSorterTest {

    @Test
    void basicTest() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(23, 88, "David Goodman"));
        students.add(new Student(25, 82, "Mark Rose"));
        students.add(new Student(22, 90, "Jane Doe"));
        students.add(new Student(25, 90, "Jane Dane"));
        assertEquals("Jane Doe,Jane Dane,David Goodman,Mark Rose", TripleSorter.sort(students));
    }

    @Test
    void sameGpasAndAgesTest() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(25, 90, "Roi Foodman"));
        students.add(new Student(25, 90, "Ben Pose"));
        students.add(new Student(25, 90, "Reed Zapata"));
        students.add(new Student(25, 90, "Jane Doe"));
        assertEquals("Jane Doe,Roi Foodman,Ben Pose,Reed Zapata", TripleSorter.sort(students));
    }

    @Test
    void randomTest() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Random r = new Random();
            int ageResult = r.nextInt(100 - 18) + 18;
            int gpaResult = r.nextInt(100 - 60) + 60;
            String nameResult = r.nextInt(1000 - 1) + 1 + " " + (r.nextInt(1000 - 1) + 1);
            students.add(new Student(ageResult, gpaResult, nameResult));
        }
        assertEquals(sort(students), TripleSorter.sort(students));
    }

    private String sort(List<Student> students) {
        return students.stream()
                .sorted((o1, o2) -> {
                    String ln1 = o1.fullName();
                    String ln2 = o2.fullName();
                    boolean gpa = o1.gpa() > o2.gpa();
                    boolean lastName = (int) ln1.charAt(ln1.indexOf(' ') + 1) < (int) ln2.charAt(ln2.indexOf(' ') + 1);
                    boolean age = o1.age() < o2.age();

                    if (o1.gpa() == o2.gpa()) {
                        if ((int) ln1.charAt(ln1.indexOf(' ') + 1) == (int) ln2.charAt(ln2.indexOf(' ') + 1)) {
                            return age ? -1 : 1;
                        } else if (lastName) {
                            return -1;
                        }
                        return 1;
                    } else if (gpa) {
                        return -1;
                    }
                    return 0;
                })
                .map(Student::fullName)
                .collect(Collectors.joining(","));
    }
}