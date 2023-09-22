// prob: https://www.acmicpc.net/problem/14863

package backjoon.back14863;

import java.util.List;

public class Back14863 {

    private final long EMPTY = Integer.MIN_VALUE;
    private List<City> cities;

    private long[][] dp;

    public long getMaxCostInCity(int maxTime, List<City> cities) {
        dp = new long[cities.size()][maxTime + 1];
        this.cities = cities;
        return recursion(cities.size() - 1, maxTime);
    }

    private long recursion(int cityId, int maxTime) {
        if (maxTime < 0) {
            return EMPTY;
        }
        if (cityId < 0) {
            return 0;
        }
        if (dp[cityId][maxTime] != 0) {
            return dp[cityId][maxTime];
        }
        City city = cities.get(cityId);
        long gotoWorkingCost = recursion(cityId - 1, maxTime - city.getWorkingMinute());
        long gotoBicycleCost = recursion(cityId - 1, maxTime - city.getBicycleMinute());
        if (gotoWorkingCost == EMPTY && gotoBicycleCost == EMPTY) {
            dp[cityId][maxTime] = EMPTY;
        }
        if (gotoWorkingCost == EMPTY) {
            dp[cityId][maxTime] = gotoBicycleCost + city.getBicycleCost();
        }
        if (gotoBicycleCost == EMPTY) {
            dp[cityId][maxTime] = gotoWorkingCost + city.getWorkingCost();
        }
        dp[cityId][maxTime] = Math.max(gotoWorkingCost + city.getWorkingCost(), gotoBicycleCost + city.getBicycleCost());
        return dp[cityId][maxTime];
    }
}
