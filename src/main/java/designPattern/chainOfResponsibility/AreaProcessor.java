package designPattern.chainOfResponsibility;

import java.util.List;
import java.util.Map;

/**
 * Print out the full name of the Province by reading the place prefix.
 */
public class AreaProcessor extends  Processor{

    private Map<String, String> provinces = Map.of(
            "AB", "Alberta",
            "BC", "British Columbia",
            "MB", "Manitoba",
            "NB", "New Brunswick",
            "NF", "Newfoundland",
            "NS", "Nova Scotia",
            "ON", "Ontario",
            "PE", "Prince Edward Island",
            "PQ", "Quebec",
            "SK", "Saskatchewan"

    );

    private Map<String, String> territories = Map.of(
            "NT", "Northwest Territories",
            "YT", "Yukon",
            "NU", "Nunavut"

    );

    private List<Map<String, String>> lookupTables = List.of(provinces, territories);


    private String getFullName (String abbr) {
        for (Map<String, String> map : lookupTables) {
            final String result = map.get(abbr);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    @Override
    public boolean handle(String userId) {

        final String result = getFullName(userId.substring(0, 2));
        if (result != null) {
            System.out.println("User: " + userId + "From " + result);
            return true;
        } else {
            return false;
        }
    }
}
