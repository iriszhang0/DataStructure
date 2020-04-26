package week3;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UnboundedArray <T> {
	int currentsize;
	T []boundedarray;
	
	public UnboundedArray(T[]array,int size) {
		boundedarray=array;
		currentsize=size;
	}
	
	public T[] reallocate(int newsize){
		//create a new array with the given size
		T[]newarray=(T[])new Object[newsize];
		//copy the elements to the new array
		for(int i=0;i<currentsize;i++) {
			newarray[i]=boundedarray[i];
		} 
		return newarray;
	}
	
	public T[] Grow(T element) {
		//if array is full, then make it twice large 
		if(currentsize==boundedarray.length-1) {
			reallocate(2*currentsize);
		}	
		//add the given element to the array
		else {
			boundedarray[currentsize]=element;
			currentsize=currentsize+1;
		}
		
		return boundedarray;
	}
	
	public T[] Shrink(){
		if(currentsize>=0) {
			currentsize=currentsize-1;
			if(currentsize>0 && boundedarray.length>=4*currentsize) {
				reallocate(2*currentsize);
			}
		}
		return boundedarray;
	}
	
}
