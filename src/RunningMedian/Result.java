package RunningMedian;
import RunningMedian.Heap.HeapMe;
import RunningMedian.Heap.IntNode;

import java.util.PriorityQueue;

public class Result {
    public static void main(String[] args){
        int[] arr = {1,3,5,4,6,13,10,9,8,15,17};
        IntNode[] arrIntNode = new IntNode[arr.length];
        for (int i = 0; i < arr.length; i++){
            arrIntNode[i] = new IntNode(arr[i]);
        }

        HeapMe<IntNode> heap = new HeapMe<>(arrIntNode);

        heap.printHeap();


    }
}
