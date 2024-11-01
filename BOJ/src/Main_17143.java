import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17143 {
    static class Shark {
        int r, c, s, d, z;
        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
    static int R, C, M;
    static Shark[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R][C];

        int ans = 0;

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            map[r][c] = new Shark(r, c, s, d, z);
        }

        for(int c=0; c<C; c++) {
            for(int r=0;r<R;r++) {
                if(map[r][c] != null) {
                    ans += map[r][c].z;
                    map[r][c] = null;
                    break;
                }
            }

            Queue<Shark> q = new ArrayDeque<>();
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    if(map[i][j] != null) {
                        q.offer(new Shark(i, j, map[i][j].s, map[i][j].d, map[i][j].z));
                    }
                }
            }

            map = new Shark[R][C];

            while(!q.isEmpty()) {
                Shark s = q.poll();

                int speed = s.s;

                if (s.d == 1 || s.d == 2) {
                    int range = 2 * (R - 1);
                    speed %= range;

                    while (speed > 0) {
                        if (s.d == 1) {
                            if (s.r - speed >= 0) {
                                s.r -= speed;
                                speed = 0;
                            } else {
                                speed -= s.r;
                                s.r = 0;
                                s.d = 2;
                            }
                        } else {
                            if (s.r + speed < R) {
                                s.r += speed;
                                speed = 0;
                            } else {
                                speed -= (R - 1 - s.r);
                                s.r = R - 1;
                                s.d = 1;
                            }
                        }
                    }
                } else if (s.d == 3 || s.d == 4) {
                    int range = 2 * (C - 1);
                    speed %= range;

                    while (speed > 0) {
                        if (s.d == 3) {
                            if (s.c + speed < C) {
                                s.c += speed;
                                speed = 0;
                            } else {
                                speed -= (C - 1 - s.c);
                                s.c = C - 1;
                                s.d = 4;
                            }
                        } else {
                            if (s.c - speed >= 0) {
                                s.c -= speed;
                                speed = 0;
                            } else {
                                speed -= s.c;
                                s.c = 0;
                                s.d = 3;
                            }
                        }
                    }
                }

                if(map[s.r][s.c] == null || map[s.r][s.c].z < s.z) {
                    map[s.r][s.c] = s;
                }
            }
        }

        System.out.println(ans);
    }
}
