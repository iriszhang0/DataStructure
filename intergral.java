
import java.util.Scanner;

  class Polynomial {
 public Tuple[]t;
 
 public Polynomial(Tuple[]tuple) {
  t=tuple;
 }
 
 public String evaluation() {
  String eva=t[0].getter1()+"x^"+t[0].getter2();
  for (int i=1;i<t.length;i++) {
   if(t[i].getter1()>0)
   eva=eva+"+"+t[i].getter1()+"x^"+t[i].getter2();
   if(t[i].getter1()<0)
      eva=eva+t[i].getter1()+"x^"+t[i].getter2(); 
  }
  return eva;
 }
 
 public double  definiteIntegral (double a, double b) {
  double parts= (b-a)/1000;
  double leftbound=a;
  double rightbound=a+(b-a)/1000;
  double integral=0;
  for(int i=0;i<1000;i++) {
   double leftvalue=0;
   for(int j=0; j<t.length;j++) {
    leftvalue=leftvalue+t[j].getter1()*Math.pow(leftbound, t[j].getter2());
   }
   double rightvalue=0;
   for(int k=0; k<t.length;k++) {
    rightvalue=rightvalue+t[k].getter1()*Math.pow(rightbound, t[k].getter2());
   }
   leftbound=leftbound+(b-a)/1000;
   rightbound=rightbound+(b-a)/1000;
   double insidevalue=rightvalue+leftvalue;
   double onepart=insidevalue*parts/2;
   integral=integral+onepart;
  }
  return integral;
 }
 }

   class Tuple{
 double u;
 double v;
 
 public Tuple(double a, double b) {
  u=a;
  v=b;
 }
 
 public double getter1() {
  return u;
 }
 
 public double getter2() { 
  return v;
 }
 
 public void setter(double a,double b) {
  u=a;
  v=b;
 }
 
 public String toString() {
  String s="The value of u for this tuple is"+u+" . The value of v for this tuple is"+v;
  System.out.println(s);
  return s;
 }
   }
  public class Group3_week1_Q2{ 

  public static void main (String[]args) {
	  if(args.length %2 == 0) {
		  if(Double.class.isInstance(args)) {  
	  Tuple[] t= new Tuple[args.length/2];
	for(int i=0;i<args.length/2;i=i+2) {
		t[i]= new Tuple(Double.parseDouble(args[i]),Double.parseDouble(args[i+1]));
	}
	
 Polynomial p1=new Polynomial(t);
 
 Scanner sc = new Scanner(System.in);
    System.out.println(" Please enter the lower bound");
    double lower = sc.nextDouble();
    System.out.println("Please enter the upper bound");
    double upper = sc.nextDouble();
    
    String eva=p1.evaluation();
    long start = System.currentTimeMillis(); 
    double integral=p1.definiteIntegral(lower, upper);
    long end = System.currentTimeMillis(); 

    System.out.println("The definite integral of polynomial "+eva+" between ["+ lower +", "+ upper+"] is"+integral);
    System.out.println("Time taken to compute the integral: " + (end - start) + "ms"); 
} 
		  else {
			  System.out.println("ERROR! Please enter only numbers!!");
		  }
	  }
	  else {
		  if(Double.class.isInstance(args)) {
		  System.out.println("ERROR! Please enter even numbers!!");
		  }
		  else {
			  System.out.println("ERROR! Please enter even numbers and only numbers!!");
		  }
	  }
  }
  }