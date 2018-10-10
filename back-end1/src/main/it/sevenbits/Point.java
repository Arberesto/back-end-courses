package main.it.sevenbits;

public class Point {
    static int x;
    static int y;

    Point(int newX, int newY) {
        SetX(newX);
        SetY(newY);
    }

    Point(Point anotherPoint) {
        SetX(anotherPoint.GetX());
        SetY(anotherPoint.GetY());
    }

    public static int GetX() {
       return x;
    }

    public static void SetX(int newX) {
       x = newX;
    }

    public static int GetY() {
        return y;
    }

    public static void SetY(int newY) {
        y = newY;
    }

    public static void SetCoordinates(int newX, int newY) {
        SetX(newX);
        SetY(newY);
    }

    public static void SetPoint(int newX, int newY) {
        SetX(newX);
        SetY(newY);
    }

    public static void SetPoint(Point anotherPoint) {
        SetX(anotherPoint.GetX());
        SetY(anotherPoint.GetY());
    }
}
