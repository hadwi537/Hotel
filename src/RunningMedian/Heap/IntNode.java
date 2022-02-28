package RunningMedian.Heap;


public class IntNode implements HeapNodeInterface{
    public Integer data;
    public Integer priority;

    public IntNode(Integer value){
        priority = value;
        data = value;
    }

    @Override
    public int getPriority() {
        return priority;
    }
    @Override
    public void printPriority(){
        System.out.print(priority);
    }
}
