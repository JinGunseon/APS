package APS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16236 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int[][] map;
    static int n, time, sharkSize = 2, eatCount = 0;
    static int sharkR, sharkC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkR = i;
                    sharkC = j;
                    map[i][j] = 0; // 아기 상어 위치 초기화
                }
            }
        }

        time = 0;
        while (true) {
            int[] nextFish = findNearestFish();
            if (nextFish == null) break; // 더 이상 먹을 수 있는 물고기 없음

            // 상어 이동 및 상태 갱신
            sharkR = nextFish[0];
            sharkC = nextFish[1];
            time += nextFish[2]; // 이동 시간 추가
            eatCount++;

            // 먹은 개수와 현재 크기가 같다면 크기 증가
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }

            // 물고기 먹었으므로 해당 위치 0으로 변경
            map[sharkR][sharkC] = 0;
        }

        System.out.println(time);
    }

    // 최적의 물고기를 BFS로 한 번만 탐색하여 찾기
    private static int[] findNearestFish() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.add(new int[]{sharkR, sharkC, 0});
        visited[sharkR][sharkC] = true;

        int minDist = Integer.MAX_VALUE;
        int fishR = -1, fishC = -1, fishDist = -1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], dist = cur[2];

            // 더 멀리 있는 물고기는 탐색할 필요 없음 (BFS 특성상 최단 거리 우선 탐색)
            if (dist > minDist) break;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc]) continue;
                if (map[nr][nc] > sharkSize) continue; // 큰 물고기는 못 지나감

                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc, dist + 1});

                // 먹을 수 있는 물고기 발견
                if (map[nr][nc] > 0 && map[nr][nc] < sharkSize) {
                    if (dist + 1 < minDist) {
                        // 더 가까운 물고기 발견하면 업데이트
                        minDist = dist + 1;
                        fishR = nr;
                        fishC = nc;
                        fishDist = minDist;
                    } else if (dist + 1 == minDist) {
                        // 거리가 같다면, 더 위쪽 -> 더 왼쪽 우선
                        if (nr < fishR || (nr == fishR && nc < fishC)) {
                            fishR = nr;
                            fishC = nc;
                            fishDist = minDist;
                        }
                    }
                }
            }
        }

        return (fishR == -1) ? null : new int[]{fishR, fishC, fishDist};
    }
}
