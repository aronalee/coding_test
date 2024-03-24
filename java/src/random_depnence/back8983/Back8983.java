// prob: https://www.acmicpc.net/problem/8983

package random_depnence.back8983;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Back8983 {
    private final List<Point> spotsOfShoot;
    private final List<Point> spotsOfAnimals;
    private final int shootOfBoundary;

    public Back8983(List<Point> spotsOfShoot, List<Point> spotsOfAnimals, int shootOfBoundary) {
        this.spotsOfShoot = spotsOfShoot;
        this.spotsOfAnimals = spotsOfAnimals;
        this.shootOfBoundary = shootOfBoundary;
    }

    public int computeShootAnimals() {
        int count = 0;
        Queue<Point> queue = new LinkedList<>(spotsOfAnimals);
        spotsOfShoot.sort(Comparator.comparingInt(Point::getX));
        while (!queue.isEmpty()) {
            Point animal = queue.poll();
            if (hasInboundAnimal(animal, 0, spotsOfShoot.size() - 1)) {
                count++;
            }
        }
        return count;
    }

    private boolean hasInboundAnimal(Point animal, int left, int right) {
        int mid = (left + right) / 2;
        if (left >= right) {
            return isBoundaryInAnimal(animal, spotsOfShoot.get(left));
        }
        Point spotOfShoot = spotsOfShoot.get(mid);
        if (isBoundaryInAnimal(animal, spotOfShoot)) {
            return true;
        }
        if (animal.getX() > spotOfShoot.getX()) {
            return hasInboundAnimal(animal, mid + 1, right);
        } else if (animal.getX() < spotOfShoot.getX()) {
            return hasInboundAnimal(animal, left, mid);
        }
        return false;
    }

    private boolean isBoundaryInAnimal(Point animal, Point spotOfShoot) {
        return computeBoundary(spotOfShoot, animal) <= shootOfBoundary;
    }

    private int computeBoundary(Point spotOfShoot, Point animal) {
        return Math.abs(spotOfShoot.getX() - animal.getX()) + animal.getY();
    }
}
