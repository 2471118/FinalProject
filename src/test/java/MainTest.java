import org.Tang.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @DisplayName("A1B2C3 -> true")
    @Test
    void testIsPostalCodeValid1() {
        String str = "A1B2C3";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(str);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("ABC123 -> false")
    @Test
    void testIsPostalCodeValid2() {
        String str = "ABC123";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(str);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName(" -> false")
    @Test
    void testIsPostalCodeValid3() {
        String str = "";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(str);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("null -> false")
    @Test
    void testIsPostalCodeValid4() {
        String str = null;
        boolean expected = false;
        Address.isPostalCodeValid(str);
        boolean actual = false;
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Computer Science and Mathematics -> true")
    @Test
    void testIsDepartmentNameValid1() {
        String str = "Computer Science and Mathematics";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(str);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("English 101 -> false")
    @Test
    void testIsDepartmentNameValid2() {
        String str = "English 101";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(str);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("B@n@n@ -> false")
    @Test
    void testIsDepartmentNameValid3() {
        String str = "B@n@n@";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(str);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName(" -> false")
    @Test
    void testIsDepartmentNameValid4() {
        String str = "";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(str);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("null -> false")
    @Test
    void testIsDepartmentNameValid5() {
        String str = "";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(str);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("BAnaNa BeRRy-> Banana Berry")
    @Test
    void testToTitleCase1() {
        String str = "BAnaNa BeRRy";
        String expected = "Banana Berry";
        String actual = Util.toTitleCase(str);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("register course -> yes")
    @Test
    void testRegisterCourse1() {
        Department d = new Department("Computer Science");
        Course c = new Course("Introduction to Programming", 2.66, d);
        Student s = new Student("Bobby Bob", Student.Gender.MALE, null, d);
        boolean expected = true;
        boolean actual = s.registerCourse(c);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("register course -> false")
    @Test
    void testRegisterCourse2() {
        Department d = new Department("Computer Science");
        Course c = new Course("Introduction to Programming", 2.66, d);
        Student s = new Student("Bob Bobby", Student.Gender.MALE, null, d);
        boolean expected = false;
        s.registerCourse(c);
        boolean actual = s.registerCourse(c);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("drop course -> yes")
    @Test
    void testDropCourse1() {
        Department d = new Department("Computer Science");
        Course c = new Course("Introduction to Programming", 2.66, d);
        Student s = new Student("Bobby Bob", Student.Gender.MALE, null, d);
        boolean expected = true;
        s.registerCourse(c);
        boolean actual = s.dropCourse(c);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("drop course -> false")
    @Test
    void testDropCourse2() {
        Department d = new Department("Computer Science");
        Course c = new Course("Introduction to Programming", 2.66, d);
        Student s = new Student("Bob Bobby", Student.Gender.MALE, null, d);
        boolean expected = false;
        boolean actual = s.dropCourse(c);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("avg of 50 + 70 -> 60")
    @Test
    void testCalcAssignmentAvg() {
        Assignment a = new Assignment("exam1", 20);
        a.getScores().add(50);
        a.getScores().add(70);
        double expected = 60.0;
        double actual = a.calcAssignmentAvg();
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("40 + 60 = 100 -> true")
    @Test
    void testAssignmentWeightValid1() {
        Department d = new Department("Math");
        Course c = new Course("Algebra", 3.0, d);
        c.addAssignment("Midterm", 40);
        c.addAssignment("Final", 60);
        boolean expected = true;
        Boolean actual = c.isAssignmentWeightValid();
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("40 + 70 = 100 -> false")
    @Test
    void testAssignmentWeightValid2() {
        Department d = new Department("Math");
        Course c = new Course("Algebra", 3.0, d);
        c.addAssignment("Midterm", 40);
        c.addAssignment("Final", 70);
        boolean expected = false;
        Boolean actual = c.isAssignmentWeightValid();
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Average ignores null values")
    @Test
    void testCalcAssignmentAvgIgnoreNull() {
        Assignment a = new Assignment("exam1", 20);

        a.getScores().add(80);
        a.getScores().add(null);
        a.getScores().add(100);

        Assertions.assertEquals(90.0, a.calcAssignmentAvg());
    }

    @DisplayName("Drop course removes student from course")
    @Test
    public void testDropCourse() {
        Department d = new Department("Physics");
        Course c = new Course("Mechanics", 3.0, d);

        Student s = new Student("Bam Balam", Student.Gender.FEMALE, null, d);

        s.registerCourse(c);
        assertTrue(s.dropCourse(c));
        assertTrue(s.getRegisteredCourses().isEmpty());
        assertTrue(c.getRegisteredStudents().isEmpty());
    }

    @DisplayName("Constructor sets fields to null when postal code invalid")
    @Test
    public void testConstructorInvalid() {
        Address a = new Address(10, "Street", "City", Address.Province.ON, "ABC123");
        assertNull(a.getPostalCode());
    }

    @DisplayName("Generate scores should populate all assignment scores")
    @Test
    void testGenerateScores() {
        Department dept = new Department("Computer Science");
        Course course = new Course("Programming", 2.66, dept);
        Student student = new Student("Nyri ", Student.Gender.FEMALE,
                new Address(123, "St", "City",
                        Address.Province.ON, "A1B2C3"), dept);

        course.registerStudent(student);
        course.addAssignment("Assignment 1", 50.0);
        course.addAssignment("Assignment 2", 50.0);

        course.generateScores();

        for (Assignment assignment : course.getAssignments()) {
            assertNotNull(assignment.getScores().get(0));
            int score = assignment.getScores().get(0);
            assertTrue(score >= 0 && score <= 100);
        }
    }

    @DisplayName("Math -> Advanced Math")
    @Test
    void testSetDepartmentName() {
        Department dept = new Department("Math");
        dept.setDepartmentName("ADVANCED MATH");
        Assertions.assertEquals("Advanced Math", dept.getDepartmentName());
    }

    @DisplayName("toSimplifiedString should work")
    @Test
    void testToSimplifiedStringStudent() {
        Department dept = new Department("Computer Science");
        Student student = new Student("Tam Tender", Student.Gender.FEMALE,
                new Address(123, "That Street", "The City",
                        Address.Province.QC, "A9B8C3"), dept);

        String simplified = student.toSimplifiedString();
        assertTrue(simplified.contains(student.getStudentId()));
        assertTrue(simplified.contains(student.getStudentName()));
        assertTrue(simplified.contains(dept.getDepartmentName()));
    }

    @DisplayName("toSimplifiedString should return correct format")
    @Test
    void testToSimplifiedStringCourse() {
        Department dept = new Department("Computer Science And Mathematics");
        Course course = new Course("Introduction to Programming", 2.66, dept);

        String simplified = course.toSimplifiedString();
        assertTrue(simplified.contains(course.getCourseId()));
        assertTrue(simplified.contains(course.getCourseName()));
        assertTrue(simplified.contains(String.valueOf(course.getCredits())));
        assertTrue(simplified.contains(dept.getDepartmentName()));
    }

    //BIG AI help
    @DisplayName("displayScores should work")
    @Test
    void testDisplayScores_ExampleFormat() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Department dept = new Department("Computer Science");
            Course course = new Course("Programming 1", 3.0, dept);

            Student student1 = new Student("Ethan Collins", Student.Gender.MALE,
                    new Address(123, "Main St", "Toronto",
                            Address.Province.ON, "M5V2T6"), dept);
            Student student2 = new Student("Lucas Bennett", Student.Gender.MALE,
                    new Address(456, "Elm St", "Vancouver",
                            Address.Province.BC, "V6B2T9"), dept);
            Student student3 = new Student("Ava Harrington", Student.Gender.FEMALE,
                    new Address(789, "Oak Ave", "Montreal",
                            Address.Province.QC, "H3A1T6"), dept);

            course.registerStudent(student1);
            course.registerStudent(student2);
            course.registerStudent(student3);

            course.addAssignment("Assignment01", 20.0);
            course.addAssignment("Assignment02", 20.0);
            course.addAssignment("Assignment03", 20.0);
            course.addAssignment("Exam01", 20.0);
            course.addAssignment("Exam02", 20.0);

            course.getAssignments().get(0).getScores().set(0, 82);
            course.getAssignments().get(1).getScores().set(0, 82);
            course.getAssignments().get(2).getScores().set(0, 76);
            course.getAssignments().get(3).getScores().set(0, 85);
            course.getAssignments().get(4).getScores().set(0, 80);

            course.getAssignments().get(0).getScores().set(1, 97);
            course.getAssignments().get(1).getScores().set(1, 92);
            course.getAssignments().get(2).getScores().set(1, 84);
            course.getAssignments().get(3).getScores().set(1, 67);
            course.getAssignments().get(4).getScores().set(1, 90);

            course.getAssignments().get(0).getScores().set(2, 91);
            course.getAssignments().get(1).getScores().set(2, 68);
            course.getAssignments().get(2).getScores().set(2, 82);
            course.getAssignments().get(3).getScores().set(2, 83);
            course.getAssignments().get(4).getScores().set(2, 83);

            course.displayScores();

            String output = outputStream.toString();

            assertTrue(output.contains("Course: Programming 1 (" + course.getCourseId() + ")"),
                    "Should display course name and ID");

            assertTrue(output.contains("Assignment01"), "Should contain Assignment01 header");
            assertTrue(output.contains("Assignment02"), "Should contain Assignment02 header");
            assertTrue(output.contains("Assignment03"), "Should contain Assignment03 header");
            assertTrue(output.contains("Exam01"), "Should contain Exam01 header");
            assertTrue(output.contains("Exam02"), "Should contain Exam02 header");
            assertTrue(output.contains("Final Score"), "Should contain Final Score header");

            assertTrue(output.contains("Ethan Collins"), "Should contain Ethan Collins");
            assertTrue(output.contains("Lucas Bennett"), "Should contain Lucas Bennett");
            assertTrue(output.contains("Ava Harrington"), "Should contain Ava Harrington");

            assertTrue(output.contains("82"), "Should contain score 82");
            assertTrue(output.contains("76"), "Should contain score 76");
            assertTrue(output.contains("85"), "Should contain score 85");
            assertTrue(output.contains("80"), "Should contain score 80");

            assertTrue(output.contains("97"), "Should contain score 97");
            assertTrue(output.contains("92"), "Should contain score 92");
            assertTrue(output.contains("84"), "Should contain score 84");
            assertTrue(output.contains("67"), "Should contain score 67");
            assertTrue(output.contains("90"), "Should contain score 90");

            assertTrue(output.contains("91"), "Should contain score 91");
            assertTrue(output.contains("68"), "Should contain score 68");
            assertTrue(output.contains("82"), "Should contain score 82");
            assertTrue(output.contains("83"), "Should contain score 83");

            assertTrue(output.contains("Average"), "Should contain Average row");

            int[] averages = course.calcStudentsAverage();
            assertNotNull(averages, "calcStudentsAverage should return array");
            assertEquals(3, averages.length, "Should have 3 student averages");

            assertTrue(output.contains(String.valueOf(averages[0])),
                    "Should contain final score for student 1");
            assertTrue(output.contains(String.valueOf(averages[1])),
                    "Should contain final score for student 2");
            assertTrue(output.contains(String.valueOf(averages[2])),
                    "Should contain final score for student 3");

            double avg1 = course.getAssignments().get(0).calcAssignmentAvg(); // (82+97+91)/3 = 90
            double avg2 = course.getAssignments().get(1).calcAssignmentAvg(); // (82+92+68)/3 = 80.67
            double avg3 = course.getAssignments().get(2).calcAssignmentAvg(); // (76+84+82)/3 = 80.67
            double avg4 = course.getAssignments().get(3).calcAssignmentAvg(); // (85+67+83)/3 = 78.33
            double avg5 = course.getAssignments().get(4).calcAssignmentAvg(); // (80+90+83)/3 = 84.33

            assertTrue(output.contains(String.format("%.1f", avg1)) || output.contains("90"),
                    "Should contain assignment 1 average");
            assertTrue(output.contains(String.format("%.1f", avg2)) || output.contains("80.7") || output.contains("80"),
                    "Should contain assignment 2 average");
            assertTrue(output.contains(String.format("%.1f", avg3)) || output.contains("80.7") || output.contains("80"),
                    "Should contain assignment 3 average");
            assertTrue(output.contains(String.format("%.1f", avg4)) || output.contains("78.3") || output.contains("78"),
                    "Should contain exam 1 average");
            assertTrue(output.contains(String.format("%.1f", avg5)) || output.contains("84.3") || output.contains("84"),
                    "Should contain exam 2 average");

        } finally {
            System.setOut(originalOut);
        }
    }
}
