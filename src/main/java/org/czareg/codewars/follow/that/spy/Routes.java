package org.czareg.codewars.follow.that.spy;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class Routes {

    public String findRoutes(String[][] routes) {
        Map<String, String> routeMap = Arrays.stream(routes)
                .collect(Collectors.toMap(r -> r[0], r -> r[1]));

        String startingPoint = findStartingPoint(routeMap);

        Deque<String> destinations = new LinkedList<>();
        destinations.addLast(startingPoint);
        destinations.addLast(routeMap.remove(startingPoint));

        while (!routeMap.isEmpty()) {
            String lastDestination = destinations.getLast();
            String nextDestination = routeMap.remove(lastDestination);
            destinations.addLast(nextDestination);
        }
        return String.join(", ", destinations);
    }

    private static String findStartingPoint(Map<String, String> map) {
        return map.keySet()
                .stream()
                .filter(s -> !map.containsValue(s))
                .findFirst()
                .orElseThrow();
    }
}
