import org.Tang.Address;
import org.Tang.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName()
}