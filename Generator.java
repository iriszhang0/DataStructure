package week4;
import java.time.LocalDateTime;
public class Generator implements Runnable{
    public static int total;
    public static int number_resources;
    public static String DataStructure;
    public static int maxnumber_request;
    public static int[]processid;
    public static SortedUnboundedArray sua;
    public static LinkedList list;
    public static HashTable table;
    public static PriorityQueue queue;
    public static String outputfile;

    public Generator(int total,int number_resources,String DataStructure,String outputfile,int maxnumber_request,int[]processid,SortedUnboundedArray sua,LinkedList list,HashTable table,PriorityQueue queue){
        this.total=total;
        this.number_resources=number_resources;
        this.DataStructure=DataStructure;
        this.maxnumber_request=maxnumber_request;
        this.processid=processid;
        this.outputfile=outputfile;
        this.sua=sua;
        this.list=list;
        this.queue=queue;
        this.table=table;
    }

    public void run() {
        //define writing file
        Application writeFile=new Application();
        //Application writeFile=new Application();

        // check which data structure passed in
        if(DataStructure.equals("SortedUnboundedArray")) {
            // check whether all processes are blocked
            boolean AllBlock=true;
            for(int k=1;k<=1000;k++) {
                if(processid[k]==0) {
                    AllBlock=false;
                }
            }
            //generate process requests
            while(total>0) {
                // check if the generator needs to sleep (two situation)
                if(AllBlock==false || sua.currentsize < maxnumber_request ) {
                    //random the # of request for one batch
                    int one_batch_request=(int)(Math.random()*5+1);
                    Tuple[]request=new Tuple[one_batch_request];
                    //For each request, create a Tuple to store the five parameters
                    LocalDateTime insertion_time = LocalDateTime.now();//same batch with same insertion time
                    for(int i=0;i<one_batch_request;i++) {
                        int process_id=(int)(Math.random()*1000+1);
                        while(processid[process_id]==1) {
                            process_id=(int)(Math.random()*1000+1);
                        }
                        processid[process_id]=1;
                        int resource_id=(int)(Math.random()*number_resources+1);
                        int priority=(int)(Math.random()*10+1);
                        int time =(int)(Math.random()*1000+1);
                        request[i]= new Tuple(process_id,resource_id,priority,time,insertion_time);//finish create a request
                        sua.Grow(request[i]);//insert the Tuple into data structure
                        request[i].SetIsBlock(true); //block the request
                        String output="Generated request: "+ request[i].ToString()+"\r\n";
                        writeFile.writeintoFile(output,writeFile.outputfile);
                        // sleep for a random amount of time up to 100 ms
                        int random=(int)(Math.random()*100+1);
                        try {
                            Thread.sleep(random);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    total=total-one_batch_request;
                }
                else {
                    // sleep for a random amount of time up to 100 ms
                    int random=(int)(Math.random()*100+1);
                    try {
                        Thread.sleep(random);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
        // check which data structure passed in
        // check which data structure passed in
        if(DataStructure.equals("LinkedList")) {
            // check whether all processes are blocked
            boolean AllBlock=true;
            for(int k=1;k<=1000;k++) {
                if(processid[k]==0) {
                    AllBlock=false;
                }
            }
            //generate process requests
            while(total>0) {
                // check if the generator needs to sleep (two situation)
                if(AllBlock==false || list.Size() < maxnumber_request ) {
                    //random the # of request for one batch
                    int one_batch_request=(int)(Math.random()*5+1);
                    Tuple[]request=new Tuple[one_batch_request];
                    //For each request, create a Tuple to store the five parameters
                    LocalDateTime insertion_time = LocalDateTime.now();//same batch with same insertion time
                    for(int i=0;i<one_batch_request;i++) {
                        int process_id=(int)(Math.random()*1000+1);
                        while(processid[process_id]==1) {
                            process_id=(int)(Math.random()*1000+1);
                        }
                        processid[process_id]=1;
                        int resource_id=(int)(Math.random()*number_resources+1);
                        int priority=(int)(Math.random()*10+1);
                        int time =(int)(Math.random()*1000+1);
                        request[i]= new Tuple(process_id,resource_id,priority,time,insertion_time);//finish create a request
      Node insertplace = list.InsertPlace(request[i]);
                        if(insertplace==list.head) {
                            list.InsertHead(request[i]);
                        }
                        else {
                      
                                try {
         list.InsertOther(request[i],list.FindPred(insertplace));
        } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
        }
                        }
                        request[i].SetIsBlock(true); //block the request
                        String output="Generated request: "+ request[i].ToString()+"\r\n";
                        //need to write into the file
                        writeFile.writeintoFile(output,writeFile.outputfile);
                        // sleep for a random amount of time up to 100 ms
                        int random=(int)(Math.random()*100+1);
                        try {
                            Thread.sleep(random);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    total=total-one_batch_request;
                }
                else {
                    // sleep for a random amount of time up to 100 ms
                    int random=(int)(Math.random()*100+1);
                    try {
                        Thread.sleep(random);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
        
       if(DataStructure.equals("HashTable")) {
            // check whether all processes are blocked
            boolean AllBlock=true;
            for(int k=1;k<=1000;k++) {
                if(processid[k]==0) {
                    AllBlock=false;
                }
            }
            //generate process requests
            while(total>0) {
                // check if the generator needs to sleep (two situation)
                if(AllBlock==false || table.size() < maxnumber_request ) {
                    //random the # of request for one batch
                    int one_batch_request=(int)(Math.random()*5+1);
                    Tuple[]request=new Tuple[one_batch_request];
                    //For each request, create a Tuple to store the five parameters
                    LocalDateTime insertion_time = LocalDateTime.now();//same batch with same insertion time
                    for(int i=0;i<one_batch_request;i++) {
                        int process_id=(int)(Math.random()*1000+1);
                        while(processid[process_id]==1) {
                            process_id=(int)(Math.random()*1000+1);
                        }
                        processid[process_id]=1;
                        int resource_id=(int)(Math.random()*number_resources+1);
                        int priority=(int)(Math.random()*10+1);
                        int time =(int)(Math.random()*1000+1);
                        request[i]= new Tuple(process_id,resource_id,priority,time,insertion_time);//finish create a request
                        table.Insert(request[i]);//insert the Tuple into data structure
                        request[i].SetIsBlock(true); //block the request
                        String output="Generated request: "+ request[i].ToString()+"\r\n";
                        //need to write into the file
                        writeFile.writeintoFile(output,writeFile.outputfile);
                        // sleep for a random amount of time up to 100 ms
                        int random=(int)(Math.random()*100+1);
                        try {
                            Thread.sleep(random);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    total=total-one_batch_request;
               //     System.out.println(table.size());
                }
              
                else {
                    // sleep for a random amount of time up to 100 ms
                    int random=(int)(Math.random()*100+1);
                    try {
                        Thread.sleep(random);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
          
        }


    if(DataStructure.equals("PriorityQueue")) {
            // check whether all processes are blocked
            boolean AllBlock=true;
            for(int k=1;k<=1000;k++) {
                if(processid[k]==0) {
                    AllBlock=false;
                }
            }
            //generate process requests
            while(total>0) {
                // check if the generator needs to sleep (two situation)
                if(AllBlock==false || queue.GetNumitem() < maxnumber_request ) {
                    //random the # of request for one batch
                    int one_batch_request=(int)(Math.random()*5+1);
                    Tuple[]request=new Tuple[one_batch_request];
                    //For each request, create a Tuple to store the five parameters
                    LocalDateTime insertion_time = LocalDateTime.now();//same batch with same insertion time
                    for(int i=0;i<one_batch_request;i++) {
                        int process_id=(int)(Math.random()*1000+1);
                        while(processid[process_id]==1) {
                            process_id=(int)(Math.random()*1000+1);
                        }
                        processid[process_id]=1;
                        int resource_id=(int)(Math.random()*number_resources+1);
                        int priority=(int)(Math.random()*10+1);
                        int time =(int)(Math.random()*1000+1);
                        request[i]= new Tuple(process_id,resource_id,priority,time,insertion_time);//finish create a request
                        queue.insert(request[i]);//insert the Tuple into data structure

                        request[i].SetIsBlock(true); //block the request
                        String output="Generated request: "+ request[i].ToString()+"\r\n";
                        //need to write into the file
                        writeFile.writeintoFile(output,writeFile.outputfile);
                        // sleep for a random amount of time up to 100 ms
                        int random=(int)(Math.random()*1000+1);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    total=total-one_batch_request;
                }
                else {
                    // sleep for a random amount of time up to 100 ms
                    int random=(int)(Math.random()*100+1);
                    try {
                        Thread.sleep(1000);
                 //       System.out.println("fff");

                   } catch (InterruptedException e) {
                   
                  }
                }
            }
        }


    }
}



    



    
