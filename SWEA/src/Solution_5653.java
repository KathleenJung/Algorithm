import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5653 {
	static class Point {
		int x;
		int y;
		int time;
		int amount;
		boolean active;

		public Point(int x, int y, int time, int amount, boolean alive) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.amount = amount;
			this.active = alive;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}

	static int N, M, K;
	static int[][] map;
	static Queue<Point> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N + 300][N + 300];
			q = new ArrayDeque<>();

			for (int i = 150; i < 150 + N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 150; j < 150 + M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0) {
						q.offer(new Point(i, j, map[i][j], map[i][j], false));
					}
				}
			}

			solve();

			System.out.println("#" + (t + 1) + " " + q.size());
		}
	}

	private static void solve() {
		int time = 0;
		int[][] tempMap = new int[N + 300][N + 300];
		for (int i = 0; i < tempMap.length; i++) {
			for (int j = 0; j < tempMap.length; j++) {
				tempMap[i][j] = map[i][j];
			}
		}

		while (time <= K) {
			int size = q.size();
			System.out.println(time + "시간 뒤 " + q.toString());
			for (int i = 0; i < size; i++) {
				Point p = q.poll();

				// 비활성화 상태일 때 타임이 0이 되면 활성화 시킨 후, 상하좌우로 퍼뜨림
				if (p.active == true) {
					// 활성화 상태인데 타임이 0이 아니면 세포는 안 죽음
					if (p.time != 0) {
						p.time--;
						q.offer(new Point(p.x, p.y, p.time, p.amount, true));
					}
					// 활성화 상태인데 타임 0이면 세포는 죽음
					else if (p.time == 0) {

					}
				}
				// 비활성화 상태인데 타임이 0이 아니면 타임을 감소
				else if (p.active == false) {
					if (p.time == 0) {
						// 큐에 활성화 상태로 넣어주기
						q.offer(new Point(p.x, p.y, p.amount, p.amount, true));
						
//						두 개 이상의 줄기 세포가 하나의 그리드 셀에 동시 번식하려고 하는 경우 생명력 수치가 높은 줄기 세포가 해당 그리드 셀을 혼자서 차지하게 된다.
						if (tempMap[p.x - 1][p.y] == 0) {
							tempMap[p.x - 1][p.y] = p.amount * 100;
							q.offer(new Point(p.x-1, p.y, p.amount, p.amount, false));
						}
						else if(tempMap[p.x-1][p.y] >=100) {
							if(tempMap[p.x-1][p.y] >= p.amount * 100) {
								
							}
							else if(tempMap[p.x-1][p.y] < p.amount * 100) {
								tempMap[p.x - 1][p.y] = p.amount * 100;
								q.offer(new Point(p.x-1, p.y, p.amount, p.amount, false));
							}
						}
						else if (tempMap[p.x + 1][p.y] == 0) {
							tempMap[p.x + 1][p.y] = p.amount * 100;
							q.offer(new Point(p.x+1, p.y, p.amount, p.amount, false));
						}
						else if(tempMap[p.x + 1][p.y] >=100) {
							if(tempMap[p.x + 1][p.y] >= p.amount * 100) {
								
							}
							else if(tempMap[p.x + 1][p.y] < p.amount * 100) {
								tempMap[p.x + 1][p.y] = p.amount * 100;
								q.offer(new Point(p.x+1, p.y, p.amount, p.amount, false));
							}
						}
						else if (tempMap[p.x][p.y - 1] == 0) {
							tempMap[p.x][p.y - 1] = p.amount * 100;
							q.offer(new Point(p.x, p.y-1, p.amount, p.amount, false));
						}
						else if(tempMap[p.x][p.y - 1] >=100) {
							if(tempMap[p.x][p.y - 1] >= p.amount * 100) {
								
							}
							else if(tempMap[p.x][p.y - 1] < p.amount * 100) {
								tempMap[p.x][p.y - 1] = p.amount * 100;
								q.offer(new Point(p.x, p.y-1, p.amount, p.amount, false));
							}
						}
//						else if (tempMap[p.x][p.y + 1] == 0 || (tempMap[p.x][p.y + 1] >=100 && tempMap[p.x][p.y + 1] < p.amount * 100)) {
//							tempMap[p.x][p.y + 1] = p.amount * 100;
//							q.offer(new Point(p.x, p.y+1, p.amount, p.amount, false));
//						}
						else if(tempMap[p.x][p.y + 1] >=100) {
							if(tempMap[p.x][p.y + 1] >= p.amount * 100) {
								
							}
							else if(tempMap[p.x][p.y + 1] < p.amount * 100) {
								tempMap[p.x][p.y + 1] = p.amount * 100;
								q.offer(new Point(p.x, p.y+1, p.amount, p.amount, false));
							}
						}
					} else if (p.time != 0) {
						p.time--;
						q.offer(new Point(p.x, p.y, p.time, p.amount, false));
					}
				}
			}
			for (int r = 0; r < tempMap.length; r++) {
				for (int c = 0; c < tempMap.length; c++) {
					if(tempMap[r][c] >= 100) {
						map[r][c] = tempMap[r][c]/100;
						tempMap[r][c]/=100;
					}
				}
			}
			time++;
		}
	}

}
