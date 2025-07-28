class Solution {
    public int[][] merge(int[][] intervals) {
        //시작 기준 정렬
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++){
            int[] cur = intervals[i];
            if(merged.isEmpty()){
                merged.add(cur);//아무것도 없으면 첫 구간 넣기
            }else{
                int[] last = merged.get(merged.size()-1);
                if(last[1] >= cur[0]){
                    //곂칠시 병합
                    last[1] = Math.max(last[1], cur[1]);
                }else{
                    //안걸릴시 추가
                    merged.add(cur);
                }
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}