package org.Tang;

import lombok.*;
import util.Util;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    public enum Province {
        AB, BC, MB, NB, NL, NS, ON, PE, QC, SK
    }

    /**
     * Checks if the postal code is in a valid format
     * @param postalCode the postal code
     * @return whether the postal code is in the correct format
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null || postalCode.length() != 6) {
            return false;
        }

        for (int i = 0; i < 6; i++) {
            char ch = postalCode.charAt(i);
            if (i % 2 == 0) {
                if (!Character.isLetter(ch)) {
                    return false;
                }
            } else {
                if (!Character.isDigit(ch)) {
                    return false;
                }
            }
        }
        return true;
    }

    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = Util.toTitleCase(street);
            this.city = Util.toTitleCase(city);
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
        } else {
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        }
    }
}
