// prob: https://www.acmicpc.net/problem/20291

package backjoon.back20291;

import java.util.*;
import java.util.stream.Collectors;

public class Back20219 {
    public Map<String, Integer> compressAboutFileExtensions(List<String> fileNames) {
        HashMap<String, Integer> extensionsToCounter = new HashMap<>();
        for (String fileName : fileNames) {
            String extension = fileName.split("\\.")[1];
            extensionsToCounter.putIfAbsent(extension, 0);
            extensionsToCounter.computeIfPresent(extension, (key, value) -> value + 1);
        }
        return extensionsToCounter;
    }


    public List<String> sortingAboutFileExtensions(Set<String> strings) {
        return strings.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }
}
