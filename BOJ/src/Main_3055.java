import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055 {
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static Queue<Point> w = new ArrayDeque<>();
    static Queue<Point> q = new ArrayDeque<>();
    static int[][] delta = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        int x = -1;
        int y = -1;

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S') {
                    x = i;
                    y = j;
                }
                if (map[i][j] == '*') {
                    w.offer(new Point(i, j));
                }
            }
        }

        q.offer(new Point(x, y));
        visited[x][y] = true;
        int result = bfs();

        System.out.println(result != -1 ? result : "KAKTUS");
    }

    private static int bfs() {
        int time = 0;

        while (!q.isEmpty()) {
            int size = w.size();
            for (int s = 0; s < size; s++) {
                Point p = w.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + delta[d][0];
                    int ny = p.y + delta[d][1];
                    if (nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        w.offer(new Point(nx, ny));
                    }
                }
            }

            size = q.size();
            for (int s = 0; s < size; s++) {
                Point p = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + delta[d][0];
                    int ny = p.y + delta[d][1];

                    if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                        if (map[nx][ny] == 'D') {
                            return time + 1;
                        }
                        if (map[nx][ny] == '.' && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.offer(new Point(nx, ny));
                        }
                    }
                }
            }

            time++;
        }

        return -1;
    }
}
