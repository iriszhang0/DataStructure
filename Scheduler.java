package week4;

import java.time.LocalDateTime;

public class Scheduler implements Runnable{
    int total;
    int number_resources;
    String DataStructure;
    int maxnumber_request;
    int[]processid;
    int resource[];
    SortedUnboundedArray sua;
    LinkedList list;
    HashTable table;
    PriorityQueue queue;

    public Scheduler(int total,int number_resources,String DataStructure,int maxnumber_request,int[]processid,SortedUnboundedArray sua,
                     LinkedList list,HashTable table,PriorityQueue queue,int resource[]) {
        this.total=total;
        this.number_resources=number_resources;
        this.DataStructure=DataStructure;
        this.maxnumber_request=maxnumber_request;
        this.processid=processid;
        this.sua=sua;
        this.list=list;
        this.table=table;
        this.queue=queue;
        this.resource=resource;
    }


    public void run(){
        Application writeFile=new Application();
        if(DataStructure.equals("SortedUnboundedArray")){
            //process the request until all the request are finished
            while (sua.currentsize> 0) {
                //delete from the data structure to get the request tuple
                Tuple x=sua.Shrink();
                //check if the resource is available
                if(resource[x.GetResource_id()]==0){
                    //Tell the resource is been occupied
                    resource[x.GetResource_id()]=1;
                    //spawn a new thread to to process the request tuple
                    Thread thread = new Thread();
                    thread.start();
                    LocalDateTime startTime= LocalDateTime.now();
                    x.SetTime(startTime);
                    String start="Started to process request: "+ x.ToString()+"\r\n";//change the place
                    writeFile.writeintoFile(start,writeFile.outputfile);
                    try {
                        Thread.sleep(x.Gettime());
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    thread.isInterrupted();
                    LocalDateTime endTime= LocalDateTime.now();
                    x.SetTime(endTime);
                    String end="Finished to process request: "+ x.ToString()+"\r\n";
                    writeFile.writeintoFile(end,writeFile.outputfile);
                    resource[x.GetResource_id()]=0;
                    //write into file
                }
            }
        }



        if(DataStructure.equals("LinkedList")) {
            // check whether the head is null or not
            while(list.head.key!=null){
                //delete the head that satisfy the condition
                Tuple x=list.head.key;
                try {
                    list.DeleteHead();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                int id=x.GetResource_id();
                //check if the resource is available
                if(resource[x.GetResource_id()]==0){
                    //Tell the resource is been occupied
                    resource[x.GetResource_id()]=1;
                    //spawn a new thread to to process the request tuple
                    Thread thread = new Thread();
                    thread.start();
                    LocalDateTime startTime= LocalDateTime.now();
                    x.SetTime(startTime);
                    String start="Started to process request: "+ x.ToString()+"\r\n";//change place
                    try {
                        Thread.sleep(x.Gettime());
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    //  String start="Started to process request: "+ x.ToString();
                    thread.isInterrupted();
                    LocalDateTime endTime= LocalDateTime.now();
                    x.SetTime(endTime);
                    String end="Finished to process request: "+ x.ToString()+"\r\n";
                    writeFile.writeintoFile(end,writeFile.outputfile);
                    resource[x.GetResource_id()]=0;
                    //write into file
                }
            }
        }


     if(DataStructure.equals("HashTable")){
        // System.out.println("111111");
            while (table.size()>0) {
                Tuple x=table.FindMax();
                table.remove(x); 
                    //check if the resource is available
                    if(resource[x.GetResource_id()]==0){
                        //Tell the resource is been occupied
                        resource[x.GetResource_id()]=1;
                        //spawn a new thread to to process the request tuple
                        Thread thread = new Thread();
                        thread.start();
                        LocalDateTime startTime= LocalDateTime.now();
                        x.SetTime(startTime);
                        String start="Started to process request: "+ x.ToString()+"\r\n";
                        writeFile.writeintoFile(start,writeFile.outputfile);
                        try {
       Thread.sleep(x.Gettime());
      } catch (InterruptedException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
      }
                       // String start="Started to process request: "+ x.ToString();
                       // writeFile.writeintoFile(start,writeFile.outputfile);
                        thread.isInterrupted();
                        LocalDateTime endTime= LocalDateTime.now();
                        x.SetTime(endTime);
                        String end="Finished to process request: "+ x.ToString()+"\r\n";
                        writeFile.writeintoFile(end,writeFile.outputfile);
                        resource[x.GetResource_id()]=0;
                        //write into file
                    }

            }

        }

        if(DataStructure.equals("PriorityQueue")){
            while(queue.GetNumitem()>0){
                Tuple x=queue.delete();
                //System.out.println(queue.GetNumitem());
                //check if the resource is available
                if(resource[x.GetResource_id()]==0){
                    //Tell the resource is been occupied
                    resource[x.GetResource_id()]=1;
                    //spawn a new thread to to process the request tuple
                    Thread thread = new Thread();
                    thread.start();
                    LocalDateTime startTime= LocalDateTime.now();
                    x.SetTime(startTime);
                    String start="Started to process request: "+ x.ToString()+"\r\n";
                    writeFile.writeintoFile(start,writeFile.outputfile);
                    try {
                        Thread.sleep(x.Gettime());


                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    //   String start="Started to process request: "+ x.ToString();
                    
                    thread.isInterrupted();
                    LocalDateTime endTime= LocalDateTime.now();
                    x.SetTime(endTime);
                    String end="Finished to process request: "+ x.ToString()+"\r\n";
                    writeFile.writeintoFile(end,writeFile.outputfile);
                    resource[x.GetResource_id()]=0;
                    //write into file
                }
            }

        }



    }



}




