class Solution {
    public boolean isPalindrome(int x) {
        ArrayList<Integer> tmp = new ArrayList<>();
        boolean answer = true;
        
        if(x < 0){
            return false;
        }else if(x <10){
            return true;
        }

        while(x > 0){
            tmp.add(x % 10);
            x /= 10;
        }
        int length = tmp.size();
        
        for(int i =0; i <=length/2; i++){
            int left = tmp.get(i); 
            int right = tmp.get(length -1 -i); 
            // System.out.println("left : " + left + " right: " + right) ;
            if(left != right){
                answer = false;
            }
        }

        return answer;
    }
}