package org.Tang;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import util.Util;

@ToString
@EqualsAndHashCode
@Getter
public class Department {
    private final String departmentId;
    private String departmentName;

    private static int nextId = 1;

    /**
     * Checks if the department name is valid or not
     * @param departmentName the name of the department
     * @return whether the department name is valid or not
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            return false;
        }

        for (int i = 0; i < departmentName.length(); i++) {
            char ch = departmentName.charAt(i);
            if (!Character.isLetter(ch) && ch != ' ') {
                return false;
            }
        }
        return true;
    }

    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentId = String.format("D%02d", nextId++);
            this.departmentName = Util.toTitleCase(departmentName);
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    public void setDepartmentName(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = Util.toTitleCase(departmentName);
        } else {
            this.departmentName = null;
        }
    }
}
