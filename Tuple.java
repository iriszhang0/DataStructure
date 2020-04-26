package week4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tuple{
    private int process_id;
    private int resource_id;
    private int priority;
    private int time;
    private LocalDateTime insertion_time;
    private boolean IsBlock;

    public Tuple(int process_id, int resource_id,int priority, int time, LocalDateTime insertion_time) {
        this.process_id=process_id;
        this.resource_id=resource_id;
        this.priority=priority;
        this.time=time;
        this.insertion_time=insertion_time;
    }

    public int GetProcess_id() {
        return process_id;
    }

    public int GetResource_id() {
        return resource_id;
    }

    public int GetPriority() {
        return priority;
    }

    public int Gettime() {
        return time;
    }

    public void SetTime(LocalDateTime t) {
        insertion_time=t;
    }

    public LocalDateTime GetInsertion_time() {
        return insertion_time;
    }

    public boolean GetIsBlock() {
        return IsBlock;
    }

    public void SetIsBlock(boolean x) {
        IsBlock=x;
    }

    public boolean compareTo(Tuple t) {
        if(t.GetPriority()>priority) {
            return true;
        }
        if(t.GetPriority()<priority){
            return false;
        }
        else {
            if(t.GetInsertion_time().compareTo(insertion_time)<=0) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public boolean compareToforArr(Tuple t) {
        if(t.GetPriority()<priority) {
            return true;
        }
        if(t.GetPriority()>priority){
            return false;
        }
        else {
            if(t.GetInsertion_time().compareTo(insertion_time)>=0) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public String ToString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String currenttime=dtf.format(insertion_time);
        String res=process_id+" " +resource_id+" "+priority+" "+time+" at "+currenttime;
        return res;
    }
}