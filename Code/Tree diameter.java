import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//核心思想：
// 1. 首先，我们需要找到最远的节点Maxdistance，即从节点1开始，找到最远的节点，并记录其距离。
// 2. 然后，我们需要从节点Maxdistance开始，第二次DFS，更新距离数组，直到所有节点都被遍历到。
// 3. 最后，我们可以计算出直径，即距离数组中最大值。

public class Main
{

    static int n, Maxdistance;
    static int[] distance;

    //存储节点i的所有邻居
    static List<Integer>[] Et;

    public static void main(String[] args)
    {

            Scanner scanner = new Scanner(System.in);

            // 读取节点数量
            n = scanner.nextInt();

            // 初始化距离数组和邻接表
            distance = new int[n + 1];
            Et = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++)
            {
                Et[i] = new ArrayList<>();
            }

            // 读取边并构建树
            for (int i = 1; i < n; i++)
            {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                Et[u].add(v);
                Et[v].add(u);
            }

            // 第一次DFS：从节点1开始，找到最远的节点
            dfs(1, 0);

            // 重置距离数组，从节点Maxdistance开始第二次DFS
            distance[Maxdistance] = 0;
            dfs(Maxdistance, 0);

            // 输出直径（最远距离）
            System.out.println(distance[Maxdistance]);
    }

        static void dfs(int cunrrent, int fu)
        {
            // 遍历当前节点的所有邻居
            for (int i : Et[cunrrent])
            {
                // 避免回溯到父节点
                if (i == fu) {continue;}


                // 计算到邻居节点的距离
                distance[i] = distance[cunrrent] + 1;

                // 更新最远节点
                if (distance[i] > distance[Maxdistance])
                {
                    Maxdistance = i;
                }

                // 递归DFS
                dfs(i, cunrrent);
            }
        }
}
