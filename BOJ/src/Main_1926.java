import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1926 {
    static int M, N;
    static int[][] map;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        int max = 0;
        int cnt = 0;

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    c = 1;
                    cnt++;
                    visited[i][j] = true;
                    dfs(i, j);
                    max = Math.max(max, c);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }

    public static void dfs(int x, int y) {
        for(int d=0;d<4;d++) {
            int dx = x + delta[d][0];
            int dy = y + delta[d][1];

            if(dx>=0 && dy>=0 && dx<M && dy<N && !visited[dx][dy]) {
                if(map[dx][dy] == 1) {
                    c++;
                    visited[dx][dy] = true;
                    dfs(dx, dy);
                }
            }
        }
    }
}
