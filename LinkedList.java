package week4;
import java.util.NoSuchElementException;

class Node{
 Tuple key;
 Node next;
 
 Node(Tuple k){
  this.key=k;
  next=null;
 }
}
public class LinkedList{
 Node head;
 
 public Node getHead() {
  return head;
 }
 
 public LinkedList(Tuple k) {
  head=new Node(k);
 }
 
 public int Size() {
  int size=0;
  Node current=head;
  while(current!=null) {
   size=size+1;
   current=current.next;
  }
  return size;
 }
 
 public boolean Empty() {
  return head==null;
 }
 
 public Node FindAt(int i) throws Exception{
  if(Empty()) {
   System.out.println("This Linked List is empty!");
   throw new Exception();
  }
  else {
   int j=0;
   Node current=head;
   while(current!=null && j<i) {
    current=current.next;
    j=j+1;
   }
   if(current==null) {
    System.out.println("The index is out of bound!");
    throw new IndexOutOfBoundsException();
   }
   else {
    return current;
   }
  }
 }
 
 public Node FindKey(Tuple k) throws Exception {
  if(Empty()) {
   throw new Exception(); 
  }
  else {
   Node current = head;
   while(current!=null && current.key!=k) {
    current=current.next;
   }
   if(current==null) {
    throw new NoSuchElementException();
   }
   else {
    return current;
   }
  }
 }
 
 public Tuple Get(Node N)  {
  assert(N!=null);
  return  N.key;
 }
 
 public void Set(Node N, Tuple k) {
  assert(N!=null);
  N.key= k;
 }
 
 public Node InsertPlace(Tuple k) {
  if(head.key==null) {
   return head;
  }
  else {
  Node current=head;
  if(current.key.compareTo(k)) {
   return current;
  }
  while(current.key!=null && !(current.key).compareTo(k)) {
   current=current.next;
  }
  return current;
 }
 }
 
 public void InsertHead(Tuple k) {
  Node N=new Node(k);
  N.next=head;
  head=N;
 }
 
 public void InsertOther(Tuple k, Node pre)  {
  assert(pre!=null);
  Node N=new Node(k);
  N.next=pre.next;
  pre.next=N;
 }
 
 public Node DeleteHead() throws Exception {
  Node x=head;
  if(x==null){
   throw new Exception();
  }
  else {
   head=head.next;
  }
  return x;
 }
 
 public void DeleteOther(Node pre) {
  assert(pre!=null);
   if(pre.next!=null) {
    pre.next=pre.next.next;
   }
  }
 
 public Node FindPred(Node x) throws Exception {
  if(Empty()) {
   throw new Exception();
  }
  else {
   Node current=head;
   Node pre=null;
   while(current!=null && current.key!=x.key) {
    pre=current;
    current=current.next;
   }
   if(current==null) {
    throw new NoSuchElementException();
   }
   else {
    return pre;
   }
  }
 }

}