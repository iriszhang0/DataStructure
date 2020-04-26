import java.util.*;

public class craps {
    public int firstSide;
    public int secondSide;
    public int []faceval;
    public int []faceval2;
    public static int finResult;



    public craps(int side, int[] arr1){
        firstSide=side;
        faceval=arr1;
        secondSide=side;
        faceval2=arr1;
    }

    public int rollDice(){
        Random r=new Random();
        int result=r.nextInt(firstSide)+1;
        int result2=r.nextInt(secondSide)+1;
        finResult=result+result2;
        return finResult;
    }

    public String crapsGame(){
        int wCount=0;
        int lCount=0;
        int point=0;
        for (int i=0;i<100000;i++){
            rollDice();
            if(finResult==2||finResult==3||finResult==12){
                lCount=lCount+1;
                //System.out.println("lose lose lose");
            }
            else if(finResult==7||finResult==11){
                wCount=wCount+1;
                //System.out.println("win win win");
            }
            else{
                point=finResult;
                //System.out.println("Score "+point);
                while(true){
                    rollDice();
                    if(finResult==point){
                        //System.out.println("Continue "+finResult);
                        wCount=wCount+1;
                        break;
                    }
                    else if(finResult==7){
                        //System.out.println("instant "+finResult);
                        lCount=lCount+1;
                        break;
                    }

                }
            }
        }
        return " Win "+Integer.toString(wCount)+" Lose "+Integer.toString(lCount);
    }




    public static void main(String args[]){
        int[] data=new int[]{1,2,3,4,5,6};
        craps dice=new craps(6,data);
        System.out.println(dice.crapsGame());
    }
}
