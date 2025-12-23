import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapKeystoList {
	public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");

        List<String> keyList = new ArrayList<>(map.keySet());
        System.out.println(keyList);
        System.out.println("====================================================");
        
        List<CustomObject> customList = map.entrySet().stream()
                .map(entry -> new CustomObject(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        customList.forEach(obj -> System.out.println(obj.getKey() + ": " + obj.getValue()));
        
        
        System.out.println("======>"+customList);
    }
}
class CustomObject {
    private String key;
    private String value;

    public CustomObject(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
    @Override
    public String toString() {
        return "CustomObject{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
