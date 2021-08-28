import java.util.Scanner;

public class main11 {
    //接受一个有向图的权重矩阵，和一个起点编号start（从0编号，顶点存在数组中)
    //返回一个int[] 数组，表示从start到它的最短路径长度
    public static int[] Dijsktra(int[][]weight,int start){
        int length = weight.length;
        int[] shortPath = new int[length];//存放从start到各个点的最短距离
        shortPath[0] = 0;//start到他本身的距离最短为0
        String path[] = new String[length];//存放从start点到各点的最短路径的字符串表示
        for(int i=0;i<length;i++){
            path[i] = start+"->"+i;
        }
        int visited[] = new int[length];//标记当前该顶点的最短路径是否已经求出，1表示已经求出
        visited[0] = 1;//start点的最短距离已经求出
        for(int count = 1;count<length;count++){
            int k=-1;
            int dmin = Integer.MAX_VALUE;
            for(int i=0;i<length;i++){
                if(visited[i]==0 && weight[start][i]<dmin){
                    dmin = weight[start][i];
                    k=i;
                }
            }
            //选出一个距离start最近的未标记的顶点     将新选出的顶点标记为以求出最短路径，且到start的最短路径为dmin。
            shortPath[k] = dmin;
            visited[k] = 1;
            //以k为中间点，修正从start到未访问各点的距离
            for(int i=0;i<length;i++){
                if(visited[i]==0 && weight[start][k]+weight[k][i]<weight[start][i]){
                    weight[start][i] = weight[start][k]+weight[k][i];
                    path[i] = path[k]+"->"+i;
                }
            }
        }
        for(int i=1;i<length;i++){
            System.out.println(shortPath[i]);
        }
        return shortPath;

    }
    static final int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t;
        int[][] weight = new int[6][6];
        for (int i =0;i<6;i++){
            for (int j=0;j<6;j++){
                t=sc.nextInt();
                if (t!=-1){
                    weight[i][j]=t;
                }else weight[i][j]=MAX;
            }
        }

        int start = 0;
        int[] dijsktra = Dijsktra(weight,start);
    }
}
