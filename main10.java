public class main10 {
    public static void main(String[] args) {
        int[] list= {1,2,3};
        perm(list,0,list.length-1);
    }
    public static void perm(int[] list,int k,int m) {

        if(k==m) {//判断k是否和m相等，相等表示此种数组全排列种类完全，判断条件终止。
            for(int i=0;i<=m;i++) {
                System.out.print (list[i]);
            }
            System.out.println();

        }else {
            for(int i=k;i<=m;i++) {
                swap(list ,i,k);//交换数字，得到新顺序的数组
                perm(list,k+1,m);//对新顺序的数组进行递归得到此种情况的全排列
                swap(list,k,i);//返回原来的数组
            }
        }
    }
    public static void swap(int arr[],int i,int j) {//交换数组数字
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
