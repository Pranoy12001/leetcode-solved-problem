public class Data {
    public String value;
    public int timestamp;
    
    public Data(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {
    private Map<String, List<Data>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        
        List<Data> list = map.get(key);
        
        return binarySearch(list, timestamp);
    }
    
    private String binarySearch(List<Data> list, int timestamp) {
        int low = 0;
        int high = list.size() - 1;
        
        if (list.get(low).timestamp > timestamp) {
            return "";
        }
        
        if (list.get(high).timestamp <= timestamp) {
            return list.get(high).value;
        }
        
        while (low < high) {
            int mid = (high + low) / 2;
            int value = list.get(mid).timestamp;
            if (value == timestamp) return list.get(mid).value;
            
            if (value > timestamp) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return list.get(low - 1).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */