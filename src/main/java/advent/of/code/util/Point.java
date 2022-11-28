package advent.of.code.util;

public class Point {

    private int x;
    private int y;

    public Point(String s, String s1) {
        this.x = Integer.parseInt(s);
        this.y = Integer.parseInt(s1);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point(int x, int y) {


        this.x = x;
        this.y = y;
    }
}
