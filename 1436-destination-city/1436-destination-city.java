
import java.util.*;

class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> startingCities = new HashSet<>();

        for (List<String> path : paths) {
            startingCities.add(path.get(0));
        }

        for (List<String> path : paths) {
            String destination = path.get(1);

            if (!startingCities.contains(destination)) {
                return destination;
            }
        }

        return "";
    }
}
