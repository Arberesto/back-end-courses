package it.sevenbits.workshop.DoubleEndedQueue;
import it.sevenbits.workshop.Matrix.Matrix;

public class DoubleEndedQueue {
    private Node first = null;
    private Node last = null;
    public static int RANDOM_NODE = 1;
    public final static int EMPTY_NODE = 0;

    public DoubleEndedQueue() {
    }
    public Matrix GetFirst(){
        if (IsEmpty()){
            return null;
        }
        return first.GetValue();
    }

    public Matrix GetLast(){
        if (IsEmpty()){
            return null;
        }
        return last.GetValue();
    }

    public void AddFirst(Matrix matrix){
        Node node = new Node(matrix,null,null);
        if (!IsEmpty()) {
            first.SetPrev(node);
            if (last.equals(first)) {
                node.SetNext(last);
                last.SetPrev(node);
            } else {
                node.SetNext(first);
                first.SetPrev(node);
            }
        }
        else {
            last = node;
        }
        first = node;
    }

    public void AddFirst(int nodeClass) {
        Node node = new Node(nodeClass);
        node.SetPrev(null);
        node.SetNext(null);
        if (!IsEmpty()) {
            first.SetPrev(node);
            if (last.equals(first)) {
                node.SetNext(last);
                last.SetPrev(node);
            } else {
                node.SetNext(first);
                first.SetPrev(node);
            }
        }
        else {
            last = node;
        }
        first = node;
    }

    public void AddLast(Matrix matrix){
        Node node = new Node(matrix,null,null);
        if (!IsEmpty()) {
            last.SetPrev(node);
            if (last.equals(first)) {
                first.SetNext(node);
                node.SetPrev(first);
            } else  {
                node.SetPrev(last);
                last.SetNext(node);
            }
        }
        else {
            first = node;
        }
        last = node;
    }

    public void AddLast(int nodeClass){
        Node node = new Node(nodeClass);
        node.SetPrev(null);
        node.SetNext(null);
        if (!IsEmpty()) {
            last.SetPrev(node);
            if (last.equals(first)) {
                first.SetNext(node);
                node.SetPrev(first);
            } else {
                node.SetPrev(last);
                last.SetNext(node);
            }
        }
        else {
            first = node;
        }
        last = node;
    }

    public boolean IsEmpty(){
        if ((first == null)&&(last == null)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue contain:").append("\n").append("\n");
        if (!IsEmpty()) {
            for (Node current = first; current.GetNext() != null; current = current.GetNext()) {
                sb.append(current.toString()).append("\n");
            }
            sb.append(last.toString()).append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }
}
