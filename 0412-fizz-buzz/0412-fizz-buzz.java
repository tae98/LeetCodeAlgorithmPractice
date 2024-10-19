class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> tmp = new ArrayList<>();

        for(int i =1; i <= n; i++){
            if(i % 3 == 0 && i % 5 ==0){
                tmp.add("FizzBuzz");
            }else if(i % 3 ==0 && i % 5 !=0){
                tmp.add("Fizz");
            }else if(i % 5 ==0 && i % 3 !=0){
                tmp.add("Buzz");
            }else{
                tmp.add(String.valueOf(i));
            }
        }
        return tmp;
    }
}