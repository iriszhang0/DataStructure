package week4;
import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import week4.Tuple;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SortedUnboundedArray  {
    int currentsize;
    Tuple []boundedarray;

    public SortedUnboundedArray(Tuple[]array,int size) {
        boundedarray=array;
        currentsize=size;
    }

    public Tuple[] reallocate(int newsize){
        //create a new array with the given size
        Tuple[]newarray=new Tuple [newsize];
        //copy the elements to the new array
        for(int i=0;i<currentsize;i++) {
            newarray[i]=boundedarray[i];
        }
        return newarray;
    }

    public Tuple[] Grow(Tuple element) {
        //if array is full, then make it twice large
        if(currentsize==boundedarray.length) {
            boundedarray=reallocate(2*currentsize);
        }
        //add the given element to the sorted array and sort the array

        boundedarray[currentsize]=element;
        currentsize=currentsize+1;

        // sort the array after insertion
        // boundedarray=mergeSort(boundedarray,0,currentsize-1);
        Insertionsort(boundedarray);
        return boundedarray;
    }

    public Tuple Shrink(){
        Tuple x=null;
        if(currentsize>0) {
            x=boundedarray[currentsize-1];
            boundedarray[currentsize-1]=null;
            currentsize=currentsize-1;
            if(currentsize>0 && boundedarray.length>=4*currentsize) {
                reallocate(2*currentsize);
            }
        }
        // sort the array after deletion
        //boundedarray=mergeSort(boundedarray,0,currentsize-1);
        Insertionsort(boundedarray);
        return x;
    }

    private boolean compareKeys(Tuple first, Tuple second) {
        if (first == null || second == null) {
            return false;
        } else {
            return first.compareToforArr(second);
        }
    }

    void Insertionsort(Tuple arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Tuple key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && compareKeys(arr[j],key)) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public void printArray(Tuple[] arr){
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.println(arr[i].ToString()+" ");
    }

}