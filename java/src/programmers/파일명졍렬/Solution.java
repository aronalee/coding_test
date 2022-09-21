// prob: https://school.programmers.co.kr/learn/courses/30/lessons/17686

package programmers.파일명졍렬;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class File implements Comparable<File> {
    final String name;
    final int head;
    final String filename;

    public File(String filename) throws Exception {
        Pattern filenamePattern = Pattern.compile("(?<name>[a-zA-Z\040.\\-]+)(?<head>\\d+)(?<tail>.*)");
        Matcher matcher = filenamePattern.matcher(filename);
        if (!matcher.find())
            throw new Exception();
        this.name = matcher.group("name").toLowerCase();
        this.head = Integer.parseInt(matcher.group("head"));
        this.filename = filename;
    }


    @Override
    public int compareTo(File o) {
        int compareName = this.name.compareTo(o.name);
        return (compareName != 0) ? compareName : this.head - o.head;
    }
}

public class Solution {
    public String[] solution(String[] filenames) {
        String[] answer = new String[filenames.length];
        try {
            File[] files = new File[filenames.length];
            for (int i = 0; i < filenames.length; i++) {
                files[i] = new File(filenames[i]);
            }
            Arrays.sort(files);
            for (int i = 0; i < filenames.length; i++) {
                answer[i] = files[i].filename;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }
}