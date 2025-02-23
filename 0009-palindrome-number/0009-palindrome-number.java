class Solution {
    public boolean isPalindrome(int x) {
        
        String tmp = Integer.toString(x);
        int len = tmp.length() -1;
        int mid = len/2;
        Boolean answer = false;
        if(x < 0){
            return answer;
        }
        for(int i=0; i <= mid; i++){
            if(tmp.charAt(i) == tmp.charAt(len-i)){
                answer = true;
            }else{
                answer = false;
                break;
            }
        }
        return answer;
    }
}