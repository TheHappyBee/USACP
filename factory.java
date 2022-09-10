import java.io.*;
import java.util.*;

class factory {
    static boolean[] visited;
    static int n;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("factory.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        for (int k = 0; k < n; k++) {
            adj[k] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken()) - 1; // we subtract 1 because our array is
            int b = Integer.parseInt(st2.nextToken()) - 1;
            adj[b].add(a);
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            boolean finished = true;
            visited = new boolean[n];
            dfs(i);
            for (int k = 0; k < n; k++) {
                if (visited[k] == false) {
                    finished = false;
                }
            }
            if (finished == true) {
                ans = i + 1;
                i = n;
            }
        }
        out.println(ans);
        out.close();
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int next : adj[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}