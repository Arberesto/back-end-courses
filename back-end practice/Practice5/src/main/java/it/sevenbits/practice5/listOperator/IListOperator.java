package it.sevenbits.practice5.listOperator;
import java.util.List;

public interface IListOperator {

    <E extends Object & Comparable> E max(List<E> array, int startIndex, int endIndex);

    <E extends Object> void changeElementsPosition(List<E> array, int firstElementIndex, int lastElementIndex);



}
