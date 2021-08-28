import java.util.Scanner;

public class main2 {
    public static void main(String[] arges) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int[] nums=new int[k];
        for (int i=0;i<k;i++){
            nums[i]=sc.nextInt();
        }
        int res=0;
        int cur=0;
        for (int i=0;i<k;i++){
            cur=findj(nums,i)*findk(nums,i);
            if (cur>res){
                res=cur;
            }
        }
        System.out.print(res);


    }
    public static int findj (int []num,int i){
        int res=0;
        if(i==0){
            return 0;
        }
        for (int q=i-1;q>=0;q--){
            if(num[q]>num[i]);{
                res=q;
                break;
            }
        }
        return res;
    }
    public static int findk (int []num,int i){
        int res=0;
        if(i==num.length-1){
            return 0;
        }
        for (int q=i+1;q<num.length;q++){
            if(num[q]<num[i]);{
                res=q;
                break;
            }
        }
        return res;
    }
}
