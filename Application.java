package week4;

import java.lang.StringBuffer;
import java.lang.StringBuilder;
import java.util.Random;
import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Application extends Thread{

    public static int number_resources;
    public static int maxnumber_request;
    public static int total_request;
    public static String DataStructure;
    public static String outputfile;

    public static void writeintoFile(String data,String desireName) {
        File file = new File(System.getProperty("user.dir")+"/week4/"+desireName);
        FileWriter filewriter = null;
        try {
            filewriter = new FileWriter(file,true);
            filewriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                filewriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> void main (String []args) throws InterruptedException {

    //calculate the time of program
        long startTime = System.nanoTime();

        //input five parameters
        number_resources=Integer.parseInt(args[0]);
        maxnumber_request=Integer.parseInt(args[1]);
        total_request=Integer.parseInt(args[2]);
        DataStructure=args[3];
        outputfile=args[4];

        //declare data structure
        SortedUnboundedArray sua = null;
        LinkedList list=null;
        HashTable table=null;
        PriorityQueue queue=null;


        //create an array to store resources, the index shows the # of resource
        // the value stored in the array shows whether the resource is available(0) or occupied(1)
        // initialize to be all available
        int[] resource=new int[9];
        for(int i=0;i<resource.length;i++) {
            resource[i]=0;
        }

        //create an array to show the accessibility of the processor_id
        //initialize to 0 to indicate available
        int[]processid=new int[1001];
        for(int j=0;j<=1000;j++) {
            processid[j]=0;
        }

        //initialize the data structure
        if(DataStructure.equals("SortedUnboundedArray")) {
            Tuple [] initial = new Tuple [maxnumber_request];
            sua=new SortedUnboundedArray(initial,0);
        }

        if(DataStructure.equals("LinkedList")) {
            list=new LinkedList(null);
        }
        if(DataStructure.equals("HashTable")) {
            table=new HashTable(maxnumber_request);
        }
        if(DataStructure.equals("PriorityQueue")) {
            queue=new PriorityQueue(maxnumber_request);
        }


        //spawn the threads
        Runnable g=new Generator(total_request,number_resources,DataStructure,outputfile,maxnumber_request,processid,sua,list,table,queue);
        Runnable s=new Scheduler(total_request, number_resources,DataStructure,maxnumber_request,processid,sua,list, table, queue,resource);
        Thread Generator=new Thread(g);
        Generator.start();
        sleep(1000);
        Thread Schedule=new Thread(s);
        Schedule.start();
        Generator.join();
        Schedule.join();

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

    }
}



