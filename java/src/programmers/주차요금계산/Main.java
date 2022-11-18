// prob: https://school.programmers.co.kr/learn/courses/30/lessons/92341
package programmers.주차요금계산;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Car {

    private final LocalTime enterTime;

    public Car(final LocalTime enterTime) {
        this.enterTime = enterTime;
    }

    public long compareTime(LocalTime exitTime) {
        return ChronoUnit.MINUTES.between(enterTime, exitTime);
    }

}

class Solution {

    private static final Pattern recordPattern = Pattern.compile(
        "(?<time>\\d{2}:\\d{2}) (?<carNo>\\d{4}) (?<command>IN|OUT)");

    public int[] solution(int[] fees, String[] records) {
        Map<String, Long> carNoToTime = createCarNoToTime(records);
        Queue<Integer> prices = createPrices(fees, carNoToTime);
        return convertPricesToArray(prices);
    }

    private Map<String, Long> createCarNoToTime(final String[] records) {
        Map<String, Car> enterCars = new HashMap<>();
        Map<String, Long> carNoToTime = new TreeMap<>();
        for (final String record : records) {
            Matcher matcher = recordPattern.matcher(record);
            if (!matcher.find()) {
                throw new IllegalArgumentException();
            }
            LocalTime time = LocalTime.parse(matcher.group("time"));
            String carNo = matcher.group("carNo");
            String command = matcher.group("command");
            if (command.equals("IN")) {
                enterCars.put(carNo, new Car(time));
                continue;
            }
            if (command.equals("OUT")) {
                Car exitedCar = enterCars.get(carNo);
                enterCars.remove(carNo);
                setUsingTime(carNoToTime, time, carNo, exitedCar);
            }
        }
        for (final String carNo : enterCars.keySet()) {
            setUsingTime(carNoToTime, LocalTime.parse("23:59"), carNo,
                enterCars.get(carNo));
        }
        return carNoToTime;
    }

    private int[] convertPricesToArray(final Queue<Integer> prices) {
        int[] answer = new int[prices.size()];
        for (int idx = 0; idx < answer.length; idx++) {
            answer[idx] = prices.remove();
        }
        return answer;
    }

    private Queue<Integer> createPrices(final int[] fees, final Map<String, Long> carNoToTime) {
        int defaultTime = fees[0];
        int defaultPrice = fees[1];
        int unitMinute = fees[2];
        int unitPrice = fees[3];
        Queue<Integer> prices = new LinkedList<>();
        for (final String carNo : carNoToTime.keySet()) {
            long time = carNoToTime.get(carNo);
            if (time < defaultTime) {
                prices.add(defaultPrice);
                continue;
            }
            int price = defaultPrice
                + (int) Math.ceil((time - defaultTime) / (double) unitMinute) * unitPrice;
            prices.add(price);
        }
        return prices;
    }

    private void setUsingTime(final Map<String, Long> carNoToTime, final LocalTime time,
        final String carNo, final Car exitedCar) {
        if (carNoToTime.containsKey(carNo)) {
            long currentTime = carNoToTime.get(carNo);
            carNoToTime.put(carNo, currentTime + exitedCar.compareTime(time));
            return;
        }
        carNoToTime.put(carNo, exitedCar.compareTime(time));
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new int[]{180, 5000, 10, 600},
            new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
                "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN",
                "23:00 5961 OUT"})));
        System.out.println(Arrays.toString(s.solution(new int[]{120, 0, 60, 591},
            new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT",
                "23:58 3961 IN"})));
    }
}
