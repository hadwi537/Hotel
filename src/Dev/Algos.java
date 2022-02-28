package Dev;

import java.lang.reflect.Array;
import java.util.*;

public class Algos<T> {
    public static void main(String[] args){
        List<Integer> l = new ArrayList<>(Arrays.asList(1,3,5,2,6,9));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(1,1));
        try{
            System.out.println(subArrayEqualToK(l, 6));
            System.out.println(subArrayEqualToK(l, 7));
            System.out.println(subArrayEqualToK(l, 8));
            System.out.println(subArrayEqualToK(l, 11));
            System.out.println(subArrayEqualToK(l, 12));
            System.out.println(subArrayEqualToK(l, 21));
            System.out.println(subArrayEqualToK(l, 25));
            System.out.println(subArrayEqualToK(l, 23));
            System.out.println(subArrayEqualToK(l2, 2));
            System.out.println(subArrayEqualToK(l, 31));
        } catch (Exception ignored){
            System.out.println("value not possible");
        }
    }

    /**
     * This will be used to efficiently fill the rooms
     * for a particular booking reference
     *
     * idea:
     * bfs through the values
     *
     *keep a hashmap of precomputed values
     *
     * keep track of elements by index
     *
     * issue is that it goes in the same direction
     * start at every position
     * get all subarrays of length 2
     * then subarrays of length 3
     *
     * @param l list of rooms
     * @param k the people to book i
     */
    public static List<Integer> subArrayEqualToK(List<Integer> l, int k)
        throws Exception{
        /* precomputed indexes : sum */
        HashMap<List<Integer>, Integer>  precomputed = new HashMap<>();
        System.out.println(k);

        Queue<SearchNode> q = new LinkedList<>();
        //add all starting positions
        int index = 0;
        for (Integer value : l){
            if (value == k){ //i.e value just exists
                List<Integer> rtrn = new ArrayList<>();
                rtrn.add(value);
                return rtrn;
            }
            SearchNode s = new SearchNode(l, index, value);
            q.add(s);
            index++;
        }
        int hits = 0;
        int nodesSearched = 0;
        while (!q.isEmpty()){
            SearchNode curr = q.remove(); //dequeue a node
            List<Integer> unsearched = new ArrayList<>(curr.unsearched);
            nodesSearched++;
            if (unsearched.size() > 0){
                for (int i = 0; i < unsearched.size(); i++){
                    int nextValue = unsearched.get(i);
                    SearchNode currNext = new SearchNode(); //empty
                    currNext.unsearched = new ArrayList<>(curr.unsearched);
                    currNext.unsearched.remove(i); //
                    currNext.searched = new ArrayList<>(curr.searched);
                    currNext.searched.add(nextValue);
                    currNext.total = curr.total + nextValue;

                    if (currNext.total == k){
                        System.out.println("Hits: " + hits);
                        System.out.println("Nodes searched: " + nodesSearched);
                        return currNext.searched;
                    }
                    if (!precomputed.containsKey(currNext.searched)){
                        q.add(currNext);
                        hits++;
                        precomputed.put(currNext.searched, currNext.total);
                    }
                }
            }
        }
        throw new Exception();
    }


    private static class SearchNode{
        List<Integer> searched; //vlaues
        List<Integer> unsearched;
        int total;

        /**value*/
        public SearchNode(List<Integer> l, int index, int value){
            searched = new ArrayList<>();
            searched.add(value);
            List<Integer> temp = new ArrayList<>(l);
            temp.remove(index); //can only remove by index
            unsearched = temp;
            total = value;
        }
        public SearchNode(){
            searched = new ArrayList<>();
            unsearched = new ArrayList<>();
            total = 0;
        }
    }

    /**
     * Could pass the list of rooms
     * then try to match them with a "temporary" room
     * that has the desired capacity
     * @param l
     * @param k
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T extends Comparable<T>> List<T> subArrayEqualToKGeneral(List<T> l, T k)
            throws Exception{
        /* precomputed indexes : sum */
        HashMap<List<Integer>, Integer>  precomputed = new HashMap<>();
        System.out.println(k);

        Queue<SearchNode> q = new LinkedList<>();
        //add all starting positions
        int index = 0;
        for (T value : l){
            if (value.equals(k)){ //i.e value just exists
                List<T> rtrn = new ArrayList<>();
                rtrn.add(value);
                return rtrn;
            }
            SearchNode s = new SearchNode(l, index, value);
            q.add(s);
            index++;
        }
        int hits = 0;
        int nodesSearched = 0;
        while (!q.isEmpty()){
            SearchNode curr = q.remove(); //dequeue a node
            List<Integer> unsearched = new ArrayList<>(curr.unsearched);
            nodesSearched++;
            if (unsearched.size() > 0){
                for (int i = 0; i < unsearched.size(); i++){
                    int nextValue = unsearched.get(i);
                    SearchNode currNext = new SearchNode(); //empty
                    currNext.unsearched = new ArrayList<>(curr.unsearched);
                    currNext.unsearched.remove(i); //
                    currNext.searched = new ArrayList<>(curr.searched);
                    currNext.searched.add(nextValue);
                    currNext.total = curr.total + nextValue;

                    if (currNext.total == k){
                        System.out.println("Hits: " + hits);
                        System.out.println("Nodes searched: " + nodesSearched);
                        return currNext.searched;
                    }
                    if (!precomputed.containsKey(currNext.searched)){
                        q.add(currNext);
                        hits++;
                        precomputed.put(currNext.searched, currNext.total);
                    }
                }
            }
        }
        throw new Exception();
    }
}
