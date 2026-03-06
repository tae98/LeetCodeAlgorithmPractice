class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs[0].isEmpty()){
            return "";
        }
        int len = strs[0].length();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < len; i ++){
            char tmp = strs[0].charAt(i);
            for(int j =0; j < strs.length; j++){
                if(i > strs[j].length() - 1 || strs[j].charAt(i) != tmp){
                    return sb.toString();
                }
            }
            sb.append(tmp);
        }
        return sb.toString();
    }
}