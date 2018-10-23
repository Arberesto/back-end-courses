package it.sevenbits.workshop.DoubleEndedQueue;

import it.sevenbits.workshop.Matrix.Matrix;

import java.util.Arrays;

public class DoubleEndedQueue {
    private int queueMaxSize;
    private Node first = new Node(EMPTY_NODE);
    private Node last = new Node(EMPTY_NODE);
    private Node zeroNode = new Node(EMPTY_NODE);
    public static int RANDOM_NODE = 1;
    public final static int EMPTY_NODE = 0;

    private DoubleEndedQueue(){}

    public DoubleEndedQueue(int queueMaxSize) {
        this.queueMaxSize = queueMaxSize;
        zeroNode.SetNext(first);
        zeroNode.SetPrev(last);
        first.SetNext(zeroNode);
        first.SetPrev(zeroNode);
        last.SetPrev(zeroNode);
        last.SetNext(zeroNode);
    }
    public Matrix GetFirst(){
        if (IsEmpty()){
            return null;
        }
        else if (first.GetNext() == zeroNode) {
            return last.GetValue();
        }
        return first.GetValue();
    }

    public Matrix GetLast(){
        if (IsEmpty()){
            return null;
        }
        else if (last.GetPrev() == zeroNode) {
            return first.GetValue();
        }
        return last.GetValue();
    }

    public void AddFirst(Matrix matrix){
        Node node = new Node(matrix,zeroNode,zeroNode);
        if (!IsEmpty()) {
            first.SetPrev(node);
            if (last.GetPrev() == zeroNode) {
                first.SetNext(zeroNode);
                last = first;
                node.SetNext(last);
            } else if (first.GetNext() == zeroNode) {
                node.SetNext(last);
                last.SetPrev(node);
            }
        }
        else {
            node.SetNext(last);
        }
        first = node;
    }

    public void AddFirst(int nodeClass) {
        Node node = new Node(nodeClass);
        node.SetPrev(zeroNode);
        node.SetNext(zeroNode);
        if (!IsEmpty()) {
            first.SetPrev(node);
            if (last.GetPrev() == zeroNode) {
                first.SetNext(zeroNode);
                last = first;
                node.SetNext(last);
            } else if (first.GetNext() == zeroNode) {
                node.SetNext(last);
                last.SetPrev(node);
            }
        }
        else {
            node.SetNext(last);
        }
        first = node;
    }

    public void AddLast(Matrix matrix){
        Node node = new Node(matrix,zeroNode,zeroNode);
        if (!IsEmpty()) {
            last.SetPrev(node);
            if (last.GetPrev() == zeroNode) {
                node.SetPrev(first);
                first.SetNext(node);
            } else if (first.GetNext() == zeroNode) {
                last.SetPrev(zeroNode);
                last.SetNext(node);
                first = last;
                node.SetPrev(first);
            }
        }
        else {
            node.SetPrev(first);
        }
        last = node;
    }

    public void AddLast(int nodeClass){
        Node node = new Node(nodeClass);
        node.SetPrev(zeroNode);
        node.SetNext(zeroNode);
        if (!IsEmpty()) {
            last.SetPrev(node);
            if (last.GetPrev() == zeroNode) {
                node.SetPrev(first);
                first.SetNext(node);
            } else if (first.GetNext() == zeroNode) {
                last.SetPrev(zeroNode);
                last.SetNext(node);
                first = last;
                node.SetPrev(first);
            }
        }
        else {
            node.SetPrev(first);
        }
        last = node;
    }

    public boolean IsEmpty(){
        if ((first.GetNext() == zeroNode)&&(last.GetPrev() == zeroNode)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue contain:").append("\n");
        for (Node current = first; current!=last;current = current.GetNext()) {
            sb.append(current.toString()).append("\n");
        }
        sb.append(last.toString());
        sb.append("\n");
        return sb.toString();
    }
}
