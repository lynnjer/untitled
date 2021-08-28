import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

/**
 * 选择不相交区间
 * @author administrator
 *
 */
public class main7{
    private static class Zone{
        int a;
        int b;
        public Zone(){

        }
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int l=in.nextInt();
        Zone z[]=new Zone[l];
        for(int i=0;i<z.length;i++){
            z[i]=new Zone();
        }
        for(int i=0;i<z.length;i++){
            z[i].a = in.nextInt();
            z[i].b = in.nextInt();
        }
        //按照zone.b进行排序
        Arrays.sort(z, new Comparator<Zone>() {
            @Override
            public int compare(Zone z1, Zone z2) {
                return z1.b-z2.b;
            }
        });
        Stack<Zone> stack  = new Stack<>();
        int i=1;
        Zone key=z[0];
        stack.push(z[0]);
        while(i<z.length){
            if(key.b<=z[i].a){
                stack.push(z[i]);
                key=z[i];
            }
            i++;
        }

        System.out.println(stack.size());

    }

}
