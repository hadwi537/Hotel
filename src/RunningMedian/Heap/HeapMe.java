package RunningMedian.Heap;

import java.util.List;
import java.util.PriorityQueue;

public class HeapMe<T extends HeapNodeInterface> {

    private T[] elements;
    private int size;
    private int capacity;
    private int DEFAULT_CAPACITY;

    public HeapMe(int capacity){
        this.capacity = capacity;
        size = 0;
        elements = (T[]) new HeapNodeInterface[this.capacity];
    }
    public HeapMe(){
        int capacity = DEFAULT_CAPACITY;
        int size = 0;
        elements = (T[]) new HeapNodeInterface[this.capacity];
    }

    public HeapMe(List<T> a){
        size = a.size();
        capacity = size * 2;
        elements = (T[]) a.toArray();
        constructHeap(elements); //construct heap
    }
    public HeapMe(T[] a){
        size = a.length;
        capacity = size * 2;
        elements = a;
        constructHeap(elements);
    }

    /**
     * Heap construction using Floyd's method
     * O(n) time
     * @param a
     */
    public void constructHeap(T[] a){
        int n = size;
        int startIdx = (n / 2) - 1;
        for (int i = startIdx; i >= 0; i--){
            heapify(a, n, i);
        }
    }
    public void heapify(T[] a, int n, int i){
        int largest = i; //initalise largest as root
        int l = getLeftChild(i);
        int r = getRightChild(i);

        //if child greater
        if (l < n && a[l].getPriority() > a[largest].getPriority()){
            largest = l;
        }
        //if right child largest so far
        if (r < n && a[r].getPriority() > a[largest].getPriority()){
            largest = r;
        }
        //if largest is not root/parent
        if (largest != i){
            T swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;

            //recursively heapify affected sub_tree
            heapify(a, n, largest);
        }
    }

    public int getParent(int i){
        return (i-1)/2;
    }
    public int getLeftChild(int i){
        return 2*i + 1;
    }
    public int getRightChild(int i){
        return 2*i + 2;
    }

    public void printHeap(){
        for (int i = 0; i < size; i++){
            elements[i].printPriority();
            System.out.print(" ");
        }
        System.out.println();
    }
}
