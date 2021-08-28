import java.util.HashSet;
import java.util.Scanner;

public class main {
    public static int res;
    public static void main(String[] arges) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        ss(0,k);
        System.out.print(res);


    }

    public static void ss(int i,int r){
        if (r<0){
            return;
        }
        if (r==0){
            res+=1;
            return ;
        }
        if(i==2){
            ss(1,r-1);
        }else {
            ss(1,r-1);
            ss(2,r-2);
        }
    }
}
