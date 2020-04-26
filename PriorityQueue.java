package week4;
import java.util.*;
public class PriorityQueue{
    private Tuple[] heap;
    private int maxSize;
    private int numItem;

    public PriorityQueue(int size){
        heap=new Tuple[size];
        this.maxSize=size;
        this.numItem=0;
    }

    public int GetNumitem() {
        return numItem;
    }

    public Tuple[] Getheap(){
        return heap;
    }

    private int leftChild(int i){
        return 2*i+1;
    }

    private int rightChild(int i){
        return 2*i+2;
    }

    private int parent(int i){
        return (i-1)/2;
    }

    public void swap(int pos1,int pos2){
        Tuple temp;
        temp=heap[pos1];
        heap[pos1]=heap[pos2];
        heap[pos2]=temp;
    }

    public void decreaseKey(int i,Tuple t){
        assert (t.compareTo(heap[i]));
        heap[i]=t;
        while(i>0 && heap[parent(i)].compareTo(heap[i])){
            swap(parent(i),i);
            i=parent(i);
        }

    }

    public void insert(Tuple t){
        if(numItem==heap.length){
            System.out.print("The heap is full");
        }
        //heap[numItem]=(T) Double.NEGATIVE_INFINITY;
        decreaseKey(numItem,t);
        numItem=numItem+1;
    }

    public void siftDown(int i){
        int left=leftChild(i);
        int right=rightChild(i);
        int largest;
        if(left<numItem && !(heap[left].compareTo(heap[i]))){
            largest=left;
        }
        else{
            largest=i;
        }
        if(right<numItem&&!(heap[right].compareTo(heap[largest]))){
            largest=right;
        }
        if(largest!=i){
            swap(i,largest);
            siftDown(largest);
        }

    }

    public Tuple delete(){
        if(numItem<0){
            System.out.print("The heap is empty");
        }
        Tuple removeItem=heap[0];
        heap[0]=heap[numItem-1];
        numItem=numItem-1;
        if(numItem>=0){
            siftDown(0);
        }
        return removeItem;
    }

    public void heapSort(){

        for (int i=numItem-1;i>=0;i--){
            swap(0,i);
            numItem=numItem-1;
            siftDown(0);
        }

    }

    void printArray()
    {
        for (int i=0; i<heap.length; i++)
            System.out.println(heap[i].ToString()+" ");
    }



}