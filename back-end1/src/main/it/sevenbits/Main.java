package main.it.sevenbits;
import java.util.ArrayList;
public class Main {
    public static void main(String args[ ]) {
        final int n = 5;
        double maxLength = 0;
        double currentLength = 0;
        double epsilon = 0.01;
        ArrayList<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < n; i++) {
            lines.add(new Line((int)((Math.random())), (int)((Math.random())),
                    (int)((Math.random())), (int)((Math.random()))));
        }
        for (int i = 0; i < lines.size(); i++) {
            currentLength = lines.get(i).GetLength();
            System.out.println("Length of " + i + " line - " + currentLength);
            if (currentLength - maxLength > epsilon) {
                maxLength = currentLength;
            }
        }
        System.out.println("Max length of line - " + maxLength);
    }
}


