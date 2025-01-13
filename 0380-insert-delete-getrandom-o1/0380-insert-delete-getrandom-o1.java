import java.util.*;
class RandomizedSet {
    private ArrayList<Integer> lst;
    private HashMap<Integer, Integer> map;

    public RandomizedSet() {
        lst = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        lst.add(val);
        map.put(val, lst.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        lst.set(index, lst.get(lst.size() - 1));
        map.put(lst.get(index), index);
        lst.remove(lst.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        return lst.get(rand.nextInt(lst.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */