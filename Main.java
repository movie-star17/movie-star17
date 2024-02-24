import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//
//import java.util.LinkedList;
//        import java.util.Queue;
//        import java.util.Scanner;
//
//public class Main {
//    //dfs-> 1243 출력
//    //bfs-> 1234 출력
//    static int n, m, v;
//    static int[][] graph;
//    static boolean[] visited;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        v = sc.nextInt();
//
//        graph = new int[n+1][n+1];
//        visited = new boolean[n+1];
//
//        for(int i = 0; i < m; i++) {
//            int src = sc.nextInt();
//            int dst = sc.nextInt();
//            graph[src][dst] = graph[dst][src] =1; //무방향이므로 양쪽 다 1처리
//        }
//
//        dfs(v);
//        System.out.println();
//        visited = new boolean[n+1];
//        bfs(v);
//    }
//    public static void dfs(int node) {
//        visited[node] = true;
//        System.out.print(node + " ");
//        for(int i = 1; i <= n; i++) {
//            if(graph[node][i] == 1 && !visited[i]) {
//                dfs(i); //해당 노드에 따라 깊이 우선 탐색이여서 재귀 필요
//            }
//        }
//    }
//
//    Queue<Integer> q = new LinkedList<>();
//    public static void bfs(int node) {
//        Queue<Integer> q = new LinkedList<>();
//        q.add(node);
//        visited[node] = true;
//        while(!q.isEmpty()) {
//            int now = q.poll();//최상위 값 제거
//            System.out.print(now + " ");
//            for(int i = 1; i <= n; i++) {
//                if(graph[now][i] == 1 && !visited[i]) {
//                    q.offer(i); //값 추가
//                    visited[i] = true; // 너비우선 탐색
//                }
//            }
//        }
//    }
//}
class Main {
    //연결요소가 몇개인가?
    //
    static int n, m;
    static int[][] graph;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        //1. 정점 연결 처리
        for (int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dst = sc.nextInt();
            graph[src][dst] = graph[dst][src] = 1;

        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++; //새로운 연결 요소 찾는 것. 새로운 dfs호출의 개수를 출력하는 것 => 방문한 이력이 있다면 pass.
            }
        }
        System.out.println(cnt);
    }

    //재귀를 이용한 dfs
    static void dfsRecursion(int node) {
        visited[node] = true;
        for (int i = 1; i <= n; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfsRecursion(i);
            }
        }
    }

    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 1; i <= n; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

}
