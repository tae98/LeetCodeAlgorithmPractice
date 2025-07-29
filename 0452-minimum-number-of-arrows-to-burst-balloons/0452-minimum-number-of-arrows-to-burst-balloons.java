class Solution {
    public int findMinArrowShots(int[][] points) {
        // 풍선이 하나도 없으면 화살도 필요 없음
        if(points.length == 0) return 0;

        // 끝나는 지점(end)을 기준으로 오름차순 정렬
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));

        // 첫 번째 화살은 반드시 필요하므로 초기값 1
        int arrows = 1;

        // 첫 번째 풍선의 끝나는 지점을 현재 화살의 도달 범위로 설정
        int end = points[0][1];

        // 두 번째 풍선부터 탐색
        for(int i = 1; i < points.length; i++) {
            // 현재 풍선의 시작점이 현재 화살 범위를 넘으면
            // → 새로운 화살 필요
            if(points[i][0] > end) {
                arrows++;                  // 화살 추가
                end = points[i][1];        // 새 화살의 도달 가능 범위 갱신
            }
            // 겹치는 풍선이면 현재 화살로 커버되므로 아무 처리 안함
        }

        // 필요한 최소 화살 수 반환
        return arrows;
    }
}
