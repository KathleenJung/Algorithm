import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2583 {
    static int M, N, K;
    static int[][] map;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;
    static int area;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for(int k=0;k<K;k++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            for(int i=x1;i<x2;i++) {
                for(int j=y1;j<y2;j++) {
                    map[i][j] = 1;
                }
            }
        }

        int cnt = 0;

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j] == 0 && !visited[i][j]) {
                    area = 1;
                    visited[i][j] = true;
                    cnt++;
                    dfs(i, j);
                    list.add(area);
                }
            }
        }

        Collections.sort(list);

        System.out.println(cnt);
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static void dfs(int x, int y) {
        for(int d=0;d<4;d++) {
            int nx = x + delta[d][0];
            int ny = y + delta[d][1];

            if(nx>=0 && ny>=0 && nx<M && ny<N && !visited[nx][ny]) {
                if(map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    area++;
                    dfs(nx, ny);
                }
            }
        }
    }
}
