import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {
    static class Point {
        int x, y, cnt;
        public Point(int x, int y, int cnt) {
            super();
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int[][] delta = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Point> q;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        q = new ArrayDeque<>();
        visited[0][0] = true;
        q.offer(new Point(0, 0, 1));

        solution();
        System.out.println(cnt);
    }

    private static void solution() {
        while(!q.isEmpty()) {
            int size = q.size();
            for(int s=0;s<size;s++) {
                Point p = q.poll();

                if(p.x == N-1 && p.y == M-1) {
                    cnt = p.cnt;
                    return;
                }

                for(int d=0;d<4;d++) {
                    int dx = p.x + delta[d][0];
                    int dy = p.y + delta[d][1];

                    if(dx>=0 && dy>=0 && dx<N && dy<M) {
                        if(arr[dx][dy] == 1 && !visited[dx][dy]) {
                            visited[dx][dy] = true;
                            q.offer(new Point(dx,dy, p.cnt+1));
                        }
                    }
                }
            }
        }
    }
}
