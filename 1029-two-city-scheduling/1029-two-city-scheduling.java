class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // A 도시와 B 도시에 각각 보내야 할 인원 수
        int aCount = costs.length / 2;
        int bCount = costs.length / 2;

        // A 도시로 보내는 것이 더 이득인 사람부터 앞으로 정렬
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        int total = 0;

        // 정렬된 순서대로 사람들을 배치
        for (int[] tmp : costs) {
            if (aCount > 0) {
                // 아직 A 도시에 보낼 자리가 남아 있다면 A로 보냄
                total += tmp[0];
                aCount--;
            } else {
                // 아니면 B 도시에 보냄
                total += tmp[1];
                bCount--;
            }
        }

        return total;
    }
}
