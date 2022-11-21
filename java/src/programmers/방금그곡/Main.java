// prob: https://school.programmers.co.kr/learn/courses/30/lessons/17683
package programmers.방금그곡;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Music {

    private final String name;
    private final String melody;
    private final long playTime;

    public Music(final String name, final String melody, final long playTime) {
        this.name = name;
        this.melody = melody;
        this.playTime = playTime;
    }

    private String repeatMelodyUntilDiffTime() {
        StringBuilder builder = new StringBuilder();
        char[] chars = melody.toCharArray();
        int idx = 0;
        for (int i = 0; i < playTime; i++) {
            builder.append(chars[idx]);
            idx++;
            idx %= chars.length;
        }
        return builder.toString();
    }

    public int countMatchMelody(String matchMelody) {
        String totalMelody = repeatMelodyUntilDiffTime();
        Matcher matcher = Pattern.compile(matchMelody).matcher(totalMelody);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public String getName() {
        return name;
    }

    public long getPlayTime() {
        return playTime;
    }
}

class Solution {

    private final Pattern musicInfoPattern = Pattern.compile(
        "(?<startTime>\\d{2}:\\d{2}),(?<endTime>\\d{2}:\\d{2}),(?<name>[^,]+),(?<melody>[A-Z#]+)");

    private String replaceSharpToLowerCase(String inputMelody) {
        return inputMelody.replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("E#", "e")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g")
            .replaceAll("A#", "a");
    }

    public String solution(String m, String[] musicinfos) {
        List<Music> musics = new ArrayList<>();
        for (final String musicinfo : musicinfos) {
            Matcher matcher = musicInfoPattern.matcher(musicinfo);
            if (!matcher.find()) {
                throw new IllegalArgumentException();
            }
            LocalTime startTime = LocalTime.parse(matcher.group("startTime"));
            LocalTime endTime = LocalTime.parse(matcher.group("endTime"));
            String name = matcher.group("name");
            String melody = replaceSharpToLowerCase(matcher.group("melody"));
            long playTime = ChronoUnit.MINUTES.between(startTime, endTime);
            musics.add(new Music(name, melody, playTime));
        }
        int maxCount = 0;
        Music matchedMusic = null;
        String matchMelody = replaceSharpToLowerCase(m);
        for (final Music music : musics) {
            int count = music.countMatchMelody(matchMelody);
            if (count == 0 || maxCount > count) {
                continue;
            }
            if (maxCount == count && matchedMusic.getPlayTime() >= music.getPlayTime()) {
                continue;
            }
            matchedMusic = music;
            maxCount = count;
        }
        if (matchedMusic == null) {
            return "(None)";
        }
        return matchedMusic.getName();
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("ABCDEFG",
            new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(s.solution("CC#BCC#BCC#BCC#B",
            new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(s.solution("ABC",
            new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(s.solution("CC#BCC#BCC#BCC#B",
            new String[]{"00:00,00:04,SHORT,CC#", "04:00,04:08,LONG,B"}));
    }

}
