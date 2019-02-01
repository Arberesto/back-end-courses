package it.sevenbits.practice5.listOperator;

import java.util.List;

public class ListOperator implements IListOperator {

    public <E extends Object & Comparable> E max(List<E> array, int startIndex, int endIndex) {
        E maxResult;
        try {
            maxResult = array.get(startIndex);
            for (int i = startIndex + 1; i < endIndex; i++) {
                if (maxResult.compareTo(array.get(i)) > 0) {
                    maxResult = array.get(i);
                }
            }
        } catch (Exception e) {
            maxResult = null;
        }
        return maxResult;
    }

    public <E> void changeElementsPosition(List<E> array, int firstElementIndex, int lastElementIndex) {
        E temp = array.get(firstElementIndex);
        array.add(firstElementIndex + 1, array.get(lastElementIndex));
        array.remove(firstElementIndex);
        array.add(lastElementIndex + 1, temp);
        array.remove(lastElementIndex);
    }

}
