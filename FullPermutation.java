import java.util.*;
public class FullPermutation {

    /**
     * @author Norte
     *
     * Date:2018-07-26
     *
     * 功能：字符串的全排列
     *
     * 基本思想：每次从字符数组中选取一个元素(从第一个开始到最后一个结束)，作为结果的第一元素，剩下的元素做全排列，
     * 很明显这是一个递归的过程，递归结束标志为所选取的元素为字符数组的最后一个元素
     * */

//    public static void finishFullPermutation(char[] array) {
//        permutation(array, 0, array.length);
//    }
//
//    public static void permutation(char[] array, int start, int end) {
//        if(end < 0) { //字符数组中没有元素直接返回
//            return;
//        }
//        if(start == end) {
//            System.out.println(array);
//        }else {
//            for(int i = start; i < end; i++) {
//                swap(array, i, start); //更换前缀
//                permutation(array, start + 1, end); //递归将剩余元素全排列
//                swap(array, start, i);  //将前缀换回，以便进行上一个前缀的全排列
//            }
//        }
//    }
//
//    public static void swap(char[] array, int i, int j) { //用来交换前缀
//        char tmp = array[i];
//        array[i] = array[j];
//        array[j] = tmp;
//    }
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if(str.length() == 0) return res;
        char [] array = str.toCharArray();
        Arrays.sort(array);
        String s = new String(array);
        res.add(s);
        while(true){
            s = nextString(s);
            if(!s.equals("finish")){
                res.add(s);
            }
            else{
                break;
            }
        }
        return res;
    }

    public static String nextString(String str){
        char [] array = str.toCharArray();
        int length = str.length();
        int i = length-2;
        for(; i>=0 ; i--) {
            if (array[i] < array[i + 1]) {
                break;
            }
        }
        if(i == -1) return "finish";//注意
        int j = length-1;
        for(; j>=0; j--){
            if(array[j] >array[i]){
                break;
            }
        }
        //swap i,j
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        //swap i,j
        for(int a=i+1, b=length-1; a<b;a++,b--){//注意i+1
            tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
        }
        return new String(array);
    }

    public static void main(String[] args) {
        String s="ccab";
        ArrayList<String> res=Permutation(s);
        for (int i=0;i<res.size();i++){
            System.out.print(res.get(i)+"\n");
        }

    }

}