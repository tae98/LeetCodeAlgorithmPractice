class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stck = new Stack<>();

        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                int n1 = stck.pop();
                int tmp = n1 + stck.pop();
                stck.push(tmp);
            }else if(tokens[i].equals("-")){
                int n1 = stck.pop();
                int tmp = stck.pop() - n1;
                stck.push(tmp);
            }else if(tokens[i].equals("*")){
                int n1 = stck.pop();
                int tmp = n1 * stck.pop();
                stck.push(tmp);
            }else if(tokens[i].equals("/")){
                int n1 = stck.pop();
                int tmp = stck.pop() / n1;
                stck.push(tmp);
            }else{
                int x = Integer.parseInt(tokens[i]);
                stck.push(x);
            }
        }
        return stck.pop();
    }
}