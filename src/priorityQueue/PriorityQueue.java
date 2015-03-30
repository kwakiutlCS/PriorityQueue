package priorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ricardo on 30/03/2015.
 */
public class PriorityQueue<T extends Comparable<T>> {
    private ArrayList<T> queue = new ArrayList<>();
    private Map<T, Integer> positions = new HashMap<>();
    private int nextIndex = 1;

    public PriorityQueue() {
        queue.add(null);
    }


    public void add(T e) {
        queue.add(e);
        positions.put(e, nextIndex);
        update(nextIndex);
        nextIndex++;
    }

    public T remove() {
        if (nextIndex == 1) return null;
        swap(1, nextIndex-1);
        T elem = queue.remove(--nextIndex);
        update(1);
        return elem;
    }


    public T remove(T e) {
        if (nextIndex == 1) return null;
        int pos = positions.get(e);
        swap(pos, nextIndex-1);
        T elem = queue.remove(--nextIndex);
        update(pos);
        return elem;
    }


    public T get(T e) {
        return queue.get(positions.get(e));
    }


    public int size() {
        return nextIndex-1;
    }

    public String toString() {
        String s = "";
        for (int i = 1; i < nextIndex; i++) {
            s += queue.get(i)+"\n";
        }
        return s;
    }

    public void update(int i) {
        bubbleDown(bubbleUp(i));
    }

    public void update(T e) {
        update(positions.get(e));
    }

    // private methods
    private int bubbleUp(int i) {
        int index = i;
        while (index > 1) {
            if (queue.get(index).compareTo(queue.get(index / 2)) < 0) {
                swap(index, index / 2);
                index /= 2;
            }
            else return index;
        }
        return i;
    }

    private void bubbleDown(int i) {
        int index = i;
        while (index*2 < nextIndex) {
            int trade = index*2;
            int right = index*2+1;
            if (right < nextIndex) {
                if (queue.get(trade).compareTo(queue.get(right)) > 0) {
                    trade = right;
                }
            }
            if (queue.get(index).compareTo(queue.get(trade)) > 0) {
                swap(index, trade);
                index = trade;
            }
            else return;
        }
    }





    private void swap(int i, int j) {
        T tmp = queue.get(i);
        positions.put(queue.get(j), i);
        queue.set(i, queue.get(j));
        positions.put(tmp, j);
        queue.set(j, tmp);
    }
}
