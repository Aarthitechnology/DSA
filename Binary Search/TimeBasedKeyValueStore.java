import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {
    Map<String,List<Integer>> timemap;
    Map<String,List<String>> valuemap;
    public TimeBasedKeyValueStore() {
       timemap = new HashMap<>();
       valuemap = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        timemap.putIfAbsent(key,new ArrayList<>());
        valuemap.putIfAbsent(key,new ArrayList<>());
        timemap.get(key).add(timestamp);
        valuemap.get(key).add(value);
    }
    
    public String get(String key, int timestamp) {
        if(!timemap.containsKey(key))
        {
            return "";
        }
        List<Integer> time = timemap.get(key);
        List<String> value = valuemap.get(key);
        int low = 0 , high = time.size()-1;
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(time.get(mid)<=timestamp)
            {
                ans = mid;
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        if(ans==-1)
        {
            return "";
        }
        return value.get(ans);
    }
}
