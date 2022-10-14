import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_2382 {
    static class Mi {
        int x, y, m, d, a;
 
        public Mi(int x, int y, int m, int d, int a) {
            super();
            this.x = x;
            this.y = y;
            this.m = m;
            this.d = d;
            this.a = a;
        }
    }
 
    static Mi[][] map;
    static int N, K, M;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
 
            map = new Mi[N][N];
 
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
 
                Mi msm = new Mi(x, y, m, d, m);
                map[x][y] = msm;
            }
 
            solve(0);
            System.out.println("#" + (t + 1) + " " + countMi());
        }
    }
 
    private static void solve(int time) {
//      System.out.println(time + " " + M);
        if (time == M) {
            return;
        }
 
        Mi[][] tempMap = new Mi[N][N];
 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != null) {
                    // 상
                    if (map[i][j].d == 1) {
                        // 복사하려는 곳이 비어있을 경우
                        if (tempMap[i - 1][j] == null) {
                            if (i - 1 > 0) {
                                tempMap[i - 1][j] = map[i][j];
                            }
                            // 빨간색 라인에 들어오면
                            else if (i - 1 == 0) {
                                tempMap[0][j] = map[i][j];
                                tempMap[0][j].m /= 2;
                                tempMap[0][j].d = 2;
                            }
                        }
                        // 충돌할 경우
                        else {
                            // 원래 값이 더 큰 경우
                            if (tempMap[i - 1][j].a > map[i][j].m) {
                                tempMap[i - 1][j].m += map[i][j].m;
                            }
                            // 맵의 값이 더 큰 경우
                            else {
                                int temp = tempMap[i - 1][j].m;
                                tempMap[i - 1][j] = map[i][j];
                                tempMap[i - 1][j].m += temp;
                            }
                        }
                    }
                    // 하
                    else if (map[i][j].d == 2) {
                        // 복사하려는 곳이 비어있을 경우
                        if (tempMap[i + 1][j] == null) {
                            if (i + 1 < N - 1) {
                                tempMap[i + 1][j] = map[i][j];
                            }
                            // 빨간색 라인에 들어오면
                            else {
                                tempMap[i + 1][j] = map[i][j];
                                tempMap[i + 1][j].m /= 2;
                                tempMap[i + 1][j].d = 1;
                            }
                        }
                        // 충돌할 경우
                        else {
                            if (tempMap[i + 1][j].a > map[i][j].m) {
                                tempMap[i + 1][j].m += map[i][j].m;
                            } else {
                                int temp = tempMap[i + 1][j].m;
                                tempMap[i + 1][j] = map[i][j];
                                tempMap[i + 1][j].m += temp;
                            }
                        }
                    }
                    // 좌
                    else if (map[i][j].d == 3) {
                        // 복사하려는 곳이 비어있을 경우
                        if (tempMap[i][j - 1] == null) {
                            if (j - 1 > 0) {
                                tempMap[i][j - 1] = map[i][j];
                            }
                            // 빨간색 라인에 들어오면
                            else {
                                tempMap[i][j - 1] = map[i][j];
                                tempMap[i][j - 1].m /= 2;
                                tempMap[i][j - 1].d = 4;
                            }
                        }
                        // 충돌할 경우
                        else {
                            if (tempMap[i][j - 1].a > map[i][j].m) {
                                tempMap[i][j - 1].m += map[i][j].m;
                            } else {
                                int temp = tempMap[i][j - 1].m;
                                tempMap[i][j - 1] = map[i][j];
                                tempMap[i][j - 1].m += temp;
                            }
                        }
                    }
                    // 우
                    else if (map[i][j].d == 4) {
                        // 복사하려는 곳이 비어있을 경우
                        if (tempMap[i][j + 1] == null) {
                            if (j + 1 < N - 1) {
                                tempMap[i][j + 1] = map[i][j];
                            }
                            // 빨간색 라인에 들어오면
                            else {
                                tempMap[i][j + 1] = map[i][j];
                                tempMap[i][j + 1].m /= 2;
                                tempMap[i][j + 1].d = 3;
                            }
                        }
                        // 충돌할 경우
                        else {
                            if (tempMap[i][j + 1].a > map[i][j].m) {
                                tempMap[i][j + 1].m += map[i][j].m;
                            } else {
                                int temp = tempMap[i][j + 1].m;
                                tempMap[i][j + 1] = map[i][j];
                                tempMap[i][j + 1].m += temp;
                            }
                        }
                    }
 
                }
            }
        }
        copyMap(map, tempMap);
//      printMap(tempMap);
        solve(time + 1);
    }
 
    private static void printMap(Mi[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] != null) {
                    System.out.print(m[i][j].m + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
 
    public static int countMi() {
        int ans = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != null) {
                    ans += map[i][j].m;
                }
            }
        }
        return ans;
    }
 
    public static void copyMap(Mi[][] resultMap, Mi[][] copyMap) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                resultMap[i][j] = copyMap[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != null) {
                    if (resultMap[i][j].m != resultMap[i][j].a) {
                        resultMap[i][j].a = resultMap[i][j].m;
                    }
                }
            }
        }
    }
}