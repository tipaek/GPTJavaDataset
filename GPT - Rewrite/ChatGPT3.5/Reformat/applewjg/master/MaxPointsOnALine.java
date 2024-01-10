import java.util.HashMap;

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

public class Solution {
    public int maxPoints(Point[] points) {
        int res = 0;
        int N = points.length;

        for (int i = 0; i < N; ++i) {
            HashMap<Double, Integer> slopeCount = new HashMap<>();
            int sameSlope = 1, samePoint = 0;

            for (int j = i + 1; j < N; ++j) {
                double slope = Double.MIN_VALUE;

                if (points[i].x != points[j].x) {
                    slope = (double) (points[i].y - points[j].y) / (points[i].x - points[j].x);

                    // Handle -0.0 case
                    if (slope == -0.0)
                        slope = 0.0;
                } else if (points[i].y == points[j].y) {
                    samePoint += 1;
                    continue;
                }

                int tmp = 2;
                if (slopeCount.containsKey(slope)) {
                    tmp = slopeCount.get(slope) + 1;
                }

                slopeCount.put(slope, tmp);
                sameSlope = Math.max(sameSlope, tmp);
            }

            res = Math.max(res, sameSlope + samePoint);
        }

        return res;
    }
}
