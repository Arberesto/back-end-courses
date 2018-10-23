package it.sevenbits.workshop.DoubleEndedQueue;

import it.sevenbits.workshop.Matrix.Matrix;

import java.util.Random;

class Node {
    private Matrix value;
    private Node next;
    private Node prev;
    public final static int RANDOM_NODE = 1;
    public final static int EMPTY_NODE = 0;
    private Node(){}

    public Node(Matrix matrix,Node prev,Node next){
        SetValue(matrix);
        SetNext(next);
        SetPrev(prev);
    }

    public Node(int nodeClass){
        switch (nodeClass) {
            case RANDOM_NODE:
                Random rand = new Random();
                SetValue(new Matrix( rand.nextInt(3) + 1,rand.nextInt(3) + 1));
                break;
            case EMPTY_NODE:
                SetValue(null);
                break;
            default:
                break;
        }
        SetPrev(this);
        SetNext(this);
    }
    public Node GetNext(){
        return next;
    }

    public void SetNext(Node newNext){
        next = newNext;
    }

    public Node GetPrev(){
        return prev;
    }

    public void SetPrev(Node newPrev) {
        prev = newPrev;
    }

    public Matrix GetValue() {
        return value;
    }

    public void SetValue(Matrix newMatrix) {
        value = newMatrix;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("node contain: \n");
        if (GetValue() !=null) {
            sb.append(GetValue().toString());
        }
        return sb.toString();
    }
}
