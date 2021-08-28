
import java.util.*;

public class main12 {

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            int capacity = sc.nextInt(); // 背包容量
            int[] weight = new int[number + 1];
            int[] value = new int[number + 1];
            weight[0] = 0;
            for (int i = 1; i < number + 1; i++) {
                weight[i] = sc.nextInt();
            }
            value[0] = 0;
            for (int i = 1; i < number + 1; i++) {
                value[i] = sc.nextInt();
            }
            int[][] v = new int[number + 1][capacity + 1];

            for (int i = 0; i <= number; i++) {
                v[i][0] = 0;
            }
            for (int j = 0; j <= capacity; j++) {
                v[0][j] = 0;
            }
            for (int i = 1; i < number + 1; i++) {
                for (int j = 1; j < capacity + 1; j++) {
                    v[i][j] = v[i - 1][j];
                    if (j - weight[i] >= 0) {
                        v[i][j] = Math.max(v[i][j], v[i - 1][j - weight[i]] + value[i]);
                    }
                }
                System.out.println(v[number][capacity]);
            }
        }
}
