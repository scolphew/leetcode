package base;

public class Point {
    public int x;
    public int y;

    public Point(Point p, Point origin) {

    }

    public Point(int a, int b) {
        x = a;
        y = b;
    }

    @Override
    public String toString() {
        return String.format("【%d,%d】", x, y);
    }
}
