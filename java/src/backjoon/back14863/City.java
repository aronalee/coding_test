// prob: https://www.acmicpc.net/problem/14863

package backjoon.back14863;

public class City {
    private final int workingMinute;
    private final long workingCost;

    private final int bicycleMinute;
    private final long bicycleCost;

    public City(int workingMinute, long workingCost, int bicycleMinute, long bicycleCost) {
        this.workingMinute = workingMinute;
        this.workingCost = workingCost;
        this.bicycleMinute = bicycleMinute;
        this.bicycleCost = bicycleCost;
    }

    public static City of(int workingMinute, long workingCost, int bicycleMinute, long bicycleCost) {
        return new City(workingMinute, workingCost, bicycleMinute, bicycleCost);
    }

    public int getWorkingMinute() {
        return workingMinute;
    }

    public long getWorkingCost() {
        return workingCost;
    }

    public int getBicycleMinute() {
        return bicycleMinute;
    }

    public long getBicycleCost() {
        return bicycleCost;
    }
}
