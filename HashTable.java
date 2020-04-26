package week4;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.ArrayList; 


class HashNode {
 Tuple key; 
 HashNode next; 

 public HashNode(Tuple key) 
 { 
     this.key = key; 
     next=null;
 } 
} 


public class HashTable {
 
 private ArrayList<HashNode> arr; 
 private int Maxnum; 
 private int currentsize; 

 public HashTable(int Max_number) {
     arr = new ArrayList<>(); 
     Maxnum = Max_number; 
     currentsize = 0;
     for (int i = 0; i < Maxnum; i++) 
         arr.add(null); 
 } 

 public int size() { 
  return currentsize; 
 }

 public boolean isEmpty() { 
  return size() == 0;
  } 

 
 private int Hashfunction(Tuple key) 
 { 
     int hashCode = key.hashCode(); 
     int index = hashCode % Maxnum; 
     return index; 
 } 

 public Tuple remove(Tuple key) { 
     int Index = Hashfunction(key); 
     HashNode head = arr.get(Index); 
     HashNode prev = null; 
     while (head != null) 
     { 
         if (head.key.equals(key)) {
             break; 
         }
         else {
         prev = head; 
         head = head.next; 
     } 
     }
     if (head == null) 
         return null; 
     currentsize=currentsize-1; 
     if (prev != null) 
         prev.next = head.next; 
     else
         arr.set(Index, head.next);
     
     return head.key; 
 
 }


 public Tuple get(Tuple key) 
 { 
     int Index = Hashfunction(key); 
     HashNode head = arr.get(Index); 
     while (head != null) 
     { 
         if (head.key.equals(key)) 
             return head.key; 
         head = head.next; 
     } 
     return null; 
 } 


 public void Insert(Tuple key) 
 { 
     int Index = Hashfunction(key); 
     HashNode head = arr.get(Index); 
     while (head != null) 
     { 
         if (head.key.equals(key)) 
         { 
             head.key = key; 
             return; 
         } 
         head = head.next; //always add to the head
     } 
     currentsize=currentsize+1; 
     head = arr.get(Index); 
     HashNode newNode = new HashNode(key); 
     newNode.next = head; 
     arr.set(Index, newNode); 
  } 

 public Tuple FindFirst() {
  Tuple first=null;
  for(int i=0;i<arr.size();i++) {
   if(arr.get(i)!=null) {
    first=arr.get(i).key;
   break;
   }
  }
  return first;
 }

public Tuple FindMax() {
Tuple max=FindFirst();
  // Tuple max=null;
for(int i=0;i<arr.size();i++) {
 if(arr.get(i)!=null) {
 Tuple com=arr.get(i).key;
 if(com!=null) {
 if(com.compareTo(max)) {
  max=com;
 }
}
 }
}
return max;
}
}