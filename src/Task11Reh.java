import java.util.ArrayList;

public class Task11Reh {
    Task11Reh() {
        // заданное множество точек
        Point[] points = {
                new Point(1, 2),
                new Point(3, 4),
                new Point(5, 6),
                new Point(7, 8),
                new Point(9, 10)
        };

        // список всех возможных троек точек
        ArrayList<Point[]> triangles = new ArrayList<Point[]>();
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    Point[] triangle = { points[i], points[j], points[k] };
                    triangles.add(triangle);
                }
            }
        }

        // выбираем треугольник с максимальным периметром
        double maxPerimeter = 0;
        Point[] maxTriangle = null;
        for (Point[] triangle : triangles) {
            double perimeter = triangle[0].distanceTo(triangle[1]) +
                    triangle[1].distanceTo(triangle[2]) +
                    triangle[2].distanceTo(triangle[0]);
            if (perimeter > maxPerimeter) {
                maxPerimeter = perimeter;
                maxTriangle = triangle;
            }
        }

        // выводим результат
        System.out.println("Треугольник с максимальным периметром:");
        System.out.println(maxTriangle[0].toString() + " " +
                maxTriangle[1].toString() + " " +
                maxTriangle[2].toString());
        System.out.println("Периметр: " + maxPerimeter);
    }
}

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceTo(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}