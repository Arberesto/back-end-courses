package it.sevenbits.workshop;

import it.sevenbits.workshop.DoubleEndedQueue.DoubleEndedQueue;
import it.sevenbits.workshop.Matrix.Matrix;

public class Main {
    public static void main(String[] args) {
        int rowsLen = 3;
        int colsLen = 4;
        if (args.length == 2){
            rowsLen =  Integer.parseInt(args[0]);
            colsLen = Integer.parseInt(args[1]);
        }
        Matrix matrix = new Matrix(rowsLen,colsLen);
        DoubleEndedQueue queue = new DoubleEndedQueue();
        System.out.println(matrix.toString());
        matrix.Inverse();
        System.out.println(matrix.toString());

        System.out.println(queue.toString());
        queue.AddFirst(DoubleEndedQueue.RANDOM_NODE);
        System.out.println(queue.toString());
        queue.AddLast(DoubleEndedQueue.RANDOM_NODE);
        System.out.println(queue.toString());
        queue.AddFirst(DoubleEndedQueue.RANDOM_NODE);
        queue.AddLast(DoubleEndedQueue.RANDOM_NODE);
        System.out.println(queue.GetFirst());
        System.out.println(queue.GetLast());
        System.out.println(queue.toString());
    }
}
