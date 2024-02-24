// prob: https://www.acmicpc.net/problem/20950

package backjoon.back20950;

import java.util.LinkedList;
import java.util.List;

public class Back20950 {
    private static final int MAX_MIX_COLOURS = 7;
    private static final int MAX_ONE_COLOUR_VALUE = 255;

    public Colour findClosestColour(List<Colour> colours, Colour goalColour) {
        List<List<Colour>> combinations = createCombinations(colours);
        Colour closestColour = Colour.of(goalColour.getRed() + MAX_ONE_COLOUR_VALUE,
                goalColour.getGreen() + MAX_ONE_COLOUR_VALUE,
                goalColour.getBlue() + MAX_ONE_COLOUR_VALUE);
        for (List<Colour> combination : combinations) {
            Colour mixedColour = computeMixedColour(combination);
            if (closestColour == null) {
                closestColour = mixedColour;
                continue;
            }
            if (computeDifference(mixedColour, goalColour) < computeDifference(closestColour, goalColour)) {
                closestColour = mixedColour;
            }
        }
        return closestColour;
    }

    private Colour computeMixedColour(List<Colour> combination) {
        int red = 0;
        int green = 0;
        int blue = 0;
        for (Colour colour : combination) {
            red += colour.getRed();
            green += colour.getGreen();
            blue += colour.getBlue();
        }
        return Colour.of(red / combination.size(), green / combination.size(), blue / combination.size());
    }

    private List<List<Colour>> createCombinations(List<Colour> colours) {
        return createCombinations(new LinkedList<>(), new LinkedList<>(), colours, 0);
    }

    private List<List<Colour>> createCombinations(List<List<Colour>> combinations, List<Colour> subCombination, List<Colour> colours, int idx) {
        if (subCombination.size() == MAX_MIX_COLOURS || subCombination.size() == colours.size()) {
            return combinations;
        }
        for (int i = idx; i < colours.size(); i++) {
            List<Colour> copiedSubCombination = new LinkedList<>(subCombination);
            copiedSubCombination.add(colours.get(i));
            if (copiedSubCombination.size() >= 2) {
                combinations.add(copiedSubCombination);
            }
            createCombinations(combinations, copiedSubCombination, colours, i + 1);
        }

        return combinations;
    }


    public int computeDifference(Colour colour, Colour goalColour) {
        return Math.abs(colour.getRed() - goalColour.getRed()) +
                Math.abs(colour.getGreen() - goalColour.getGreen()) +
                Math.abs(colour.getBlue() - goalColour.getBlue());
    }
}
