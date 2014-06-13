import java.util.Arrays;
import java.util.Comparator;

public class MaxPointsOnALine {
    private Point p0;

    private class SlopeComparator implements Comparator<Point> {
        @Override
        public int compare(Point p1, Point p2) {
            double s1 = slopeTo(p0, p1);
            double s2 = slopeTo(p0, p2);
            if (s1 < s2) {
                return -1;
            } else if (s2 < s1) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    private double slopeTo(Point p1, Point p2) {
        if (p1.x == p2.x) {
            if (p1.y == p2.y) {
                return Double.NEGATIVE_INFINITY;
            } else {
                return Double.POSITIVE_INFINITY;
            }
        }
        return (p2.y - p1.y) / (double) (p2.x - p1.x);
    }

    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int maxi = 2;
        Point[] temp = new Point[n];
        for (int i = 0; i < n; ++i) {
            temp[i] = new Point(points[i].x, points[i].y);
        }
        for (int k = 0; k < n; ++k) {
            p0 = temp[k];
            Arrays.sort(points, new SlopeComparator());
            int i = 0;
            int s = 0;
            for ( ; i < n && p0.x == points[i].x && p0.y == points[i].y; ++i) {
                ++s;
            }
            maxi = Math.max(maxi, s);
            for ( ; i < n; ++i) {
                int j = i;
                for ( ; j < n && slopeTo(p0, points[i]) == slopeTo(p0, points[j]); ++j) {
                    ;
                }
                maxi = Math.max(maxi, s + j - i);
                i = j - 1;
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        MaxPointsOnALine solver = new MaxPointsOnALine();
        Point[] points = null;
        
        points = new Point[] {new Point(0, 0), new Point(1, 1), new Point(0, 0)};
        System.out.println(solver.maxPoints(points));
    }
}
