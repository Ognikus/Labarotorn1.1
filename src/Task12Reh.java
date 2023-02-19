import java.util.ArrayList;
import java.util.List;

public class Task12Reh {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(1, 1));
        points.add(new Point(2, 2));
        points.add(new Point(3, 3));
        Point minSumPoint = findPointWithMinSum(points);
        System.out.println("Точка с наименьшей суммой расстояний: " + minSumPoint);
    }

    public static Point findPointWithMinSum(List<Point> points) {
        double minSum = Double.POSITIVE_INFINITY;
        Point minSumPoint = null;
        for (Point p1 : points) {
            double sum = 0;
            for (Point p2 : points) {
                if (p1 != p2) {
                    sum += p1.distanceTo(p2);
                }
            }
            if (sum < minSum) {
                minSum = sum;
                minSumPoint = p1;
            }
        }
        return minSumPoint;
    }
}

