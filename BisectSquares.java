public class BisectSquares {
    public static String bisectLine(Square s1, Square s2) {
        Point s1C = s1.getCenter();
        Point s2C = s2.getCenter();
        double m = (s1C.y - s2C.y) / (s1C.x - s2C.x);
        double b = s1C.y - (m * s1C.x);

        return "y = " + m + "(x) + " + b;
    }
    
    static class Point {
        double x;
        double y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Square {
        //reference point is center of square
        Point topLeft;
        double length;

        public Square(double x, double y, double length) {
            topLeft = new Point(x, y);
            this.length = length;
        }

        public Point getCenter() {
            double halfLen = length/2;
            return new Point(topLeft.x + halfLen, topLeft.y - halfLen);
        }
    }

    public static void main(String[] args) {
        Square s1 = new Square(-6, 5, 10);
        Square s2 = new Square(0, 4, 4);
        System.out.println(bisectLine(s1, s2));
    }
}