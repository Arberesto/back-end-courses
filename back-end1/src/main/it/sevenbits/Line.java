package main.it.sevenbits;

public class Line {
    static Point start;
    static Point end;

    Line(int xStart,int yStart, int xEnd, int yEnd) {
        start.SetCoordinates(xStart, yStart);
        end.SetCoordinates(xEnd, yEnd);
    }

    Line(Point newStart, Point newEnd) {
        start.SetPoint(newStart);
        end.SetPoint(newEnd);
    }

    public static void SetLine(Point newStart, Point newEnd) {
        start.SetPoint(newStart);
        end.SetPoint(newEnd);
    }

    public double GetLength() {
        return Math.sqrt(Math.pow(start.GetX() - end.GetX(),2)) ;
    }
}
