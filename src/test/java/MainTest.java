import org.Tang.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Util;

import java.util.List;

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
        boolean actual = Address.isPostalCodeValid(str);
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
        String expected = "Banana Berry ";
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
}
