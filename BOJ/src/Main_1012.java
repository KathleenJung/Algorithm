import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012 {
    static int[][] delta = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static boolean[][] visited;
    static int[][] map;
    static int M, N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            visited = new boolean[M][N];
            int cnt = 0;

            for(int k=0;k<K;k++) {
                st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());

                map[m][n] = 1;
            }

            for(int i=0;i<M;i++) {
                for(int j=0;j<N;j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void dfs(int x, int y) {
        for(int d=0;d<4;d++) {
            int dx = x + delta[d][0];
            int dy = y + delta[d][1];

            if(dx>=0 && dy>=0 && dx<M && dy<N) {
                if(!visited[dx][dy] && map[dx][dy] == 1) {
                    visited[dx][dy] = true;
                    dfs(dx, dy);
                }
            }
        }
    }
}
