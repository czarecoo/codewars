package org.czareg.codewars.address.book.by.state;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.*;

/*
Given a string with friends to visit in different states:

ad3="John Daggett, 341 King Road, Plymouth MA
Alice Ford, 22 East Broadway, Richmond VA
Sal Carpenter, 73 6th Street, Boston MA"
we want to produce a result that sorts the names by state and lists the name of the state followed by the name of each person residing in that state (people's names sorted). When the result is printed we get:

Massachusetts
.....^John Daggett 341 King Road Plymouth Massachusetts
.....^Sal Carpenter 73 6th Street Boston Massachusetts
^Virginia
.....^Alice Ford 22 East Broadway Richmond Virginia
Spaces not being always well seen, in the above result ^ means a white space.

The resulting string (when not printed) will be:

"Massachusetts\n..... John Daggett 341 King Road Plymouth Massachusetts\n..... Sal Carpenter 73 6th Street Boston Massachusetts\n Virginia\n..... Alice Ford 22 East Broadway Richmond Virginia"
or (the separator is \n or \r\n depending on the language)

"Massachusetts\r\n..... John Daggett 341 King Road Plymouth Massachusetts\r\n..... Sal Carpenter 73 6th Street Boston Massachusetts\r\n Virginia\r\n..... Alice Ford 22 East Broadway Richmond Virginia"
Notes
There can be a blank last line in the given string of addresses.
The tests only contains CA, MA, OK, PA, VA, AZ, ID, IN for states.
You can see another example in the "Sample tests".
 */
@UtilityClass
class StateGrouper {

    static String group(String str) {
        Map<String, List<Address>> addressesByState = str.lines()
                .map(Address::of)
                .collect(groupingBy(Address::state));
        Map<String, List<Address>> addressesByStateSorted = sortAddresses(addressesByState);
        return formatAddressesByState(addressesByStateSorted);
    }

    private static Map<String, List<Address>> sortAddresses(Map<String, List<Address>> addressesByState) {
        return addressesByState.entrySet().stream()
                .sorted(comparingByKey())
                .collect(toMap(
                        Map.Entry::getKey,
                        entry -> {
                            List<Address> addresses = entry.getValue();
                            addresses.sort(comparing(Address::fullName));
                            return addresses;
                        },
                        (e1, unused) -> e1,
                        LinkedHashMap::new
                ));
    }

    private static String formatAddressesByState(Map<String, List<Address>> addressesByStateSorted) {
        return addressesByStateSorted.entrySet().stream()
                .map(entry -> {
                    String stateHeader = " %s\n".formatted(entry.getKey());
                    String addresses = entry.getValue().stream()
                            .map(address -> "..... %s\n".formatted(address.toString()))
                            .collect(joining());
                    return stateHeader + addresses;
                })
                .collect(joining())
                .strip();
    }

    record Address(String fullName, String street, String city, String state) {

        static Address of(String row) {
            String[] rowSplit = row.split(",");
            String fullName = rowSplit[0].strip();
            String street = rowSplit[1].strip();
            String cityAndState = rowSplit[2].strip();
            String city = cityAndState.substring(0, cityAndState.length() - 3);
            String stateAbbreviation = cityAndState.substring(cityAndState.length() - 2);
            String state = USState.getNameByAbbreviation(stateAbbreviation).orElseThrow();
            return new Address(fullName, street, city, state);
        }

        @Override
        public String toString() {
            return String.join(" ", fullName, street, city, state);
        }
    }

    @RequiredArgsConstructor
    @Getter
    enum USState {

        ALABAMA("Alabama", "AL"), ALASKA("Alaska", "AK"), AMERICAN_SAMOA("American Samoa", "AS"), ARIZONA("Arizona", "AZ"), ARKANSAS(
                "Arkansas", "AR"), CALIFORNIA("California", "CA"), COLORADO("Colorado", "CO"), CONNECTICUT("Connecticut", "CT"), DELAWARE(
                "Delaware", "DE"), DISTRICT_OF_COLUMBIA("District of Columbia", "DC"), FEDERATED_STATES_OF_MICRONESIA(
                "Federated States of Micronesia", "FM"), FLORIDA("Florida", "FL"), GEORGIA("Georgia", "GA"), GUAM("Guam", "GU"), HAWAII(
                "Hawaii", "HI"), IDAHO("Idaho", "ID"), ILLINOIS("Illinois", "IL"), INDIANA("Indiana", "IN"), IOWA("Iowa", "IA"), KANSAS(
                "Kansas", "KS"), KENTUCKY("Kentucky", "KY"), LOUISIANA("Louisiana", "LA"), MAINE("Maine", "ME"), MARYLAND("Maryland", "MD"), MARSHALL_ISLANDS(
                "Marshall Islands", "MH"), MASSACHUSETTS("Massachusetts", "MA"), MICHIGAN("Michigan", "MI"), MINNESOTA("Minnesota", "MN"), MISSISSIPPI(
                "Mississippi", "MS"), MISSOURI("Missouri", "MO"), MONTANA("Montana", "MT"), NEBRASKA("Nebraska", "NE"), NEVADA("Nevada",
                "NV"), NEW_HAMPSHIRE("New Hampshire", "NH"), NEW_JERSEY("New Jersey", "NJ"), NEW_MEXICO("New Mexico", "NM"), NEW_YORK(
                "New York", "NY"), NORTH_CAROLINA("North Carolina", "NC"), NORTH_DAKOTA("North Dakota", "ND"), NORTHERN_MARIANA_ISLANDS(
                "Northern Mariana Islands", "MP"), OHIO("Ohio", "OH"), OKLAHOMA("Oklahoma", "OK"), OREGON("Oregon", "OR"), PALAU("Palau",
                "PW"), PENNSYLVANIA("Pennsylvania", "PA"), PUERTO_RICO("Puerto Rico", "PR"), RHODE_ISLAND("Rhode Island", "RI"), SOUTH_CAROLINA(
                "South Carolina", "SC"), SOUTH_DAKOTA("South Dakota", "SD"), TENNESSEE("Tennessee", "TN"), TEXAS("Texas", "TX"), UTAH(
                "Utah", "UT"), VERMONT("Vermont", "VT"), VIRGIN_ISLANDS("Virgin Islands", "VI"), VIRGINIA("Virginia", "VA"), WASHINGTON(
                "Washington", "WA"), WEST_VIRGINIA("West Virginia", "WV"), WISCONSIN("Wisconsin", "WI"), WYOMING("Wyoming", "WY");

        private final String name;
        private final String abbreviation;

        static Optional<String> getNameByAbbreviation(String abbreviation) {
            return Arrays.stream(USState.values())
                    .filter(USState -> USState.getAbbreviation().equals(abbreviation))
                    .map(USState::getName)
                    .findFirst();
        }
    }
}
