import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11123 {
    static int[][] delta = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static char[][] map;
    static boolean[][] visited;
    static int cnt;
    static int H, W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            visited = new boolean[H][W];
            cnt = 0;

            for(int i=0;i<H;i++) {
                String str = br.readLine();
                for(int j=0;j<W;j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            for(int i=0;i<H;i++) {
                for(int j=0;j<W;j++) {
                    if(map[i][j] == '#' && !visited[i][j]) {
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

            if(dx>=0 && dy>=0 && dx<H && dy<W) {
                if(!visited[dx][dy] && map[dx][dy] == '#') {
                    visited[dx][dy] = true;
                    dfs(dx, dy);
                }
            }
        }
    }
}
