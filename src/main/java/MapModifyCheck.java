import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MapModifyCheck {

	public MapModifyCheck() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<MyKey, String> map = new HashMap<>();
		MyKey key = new MyKey("sarat");
		MyKey key1 = new MyKey("bharat");
		MyKey key2 = new MyKey("rama");
		map.put(key, "value");
		map.put(key1, "value1");
		map.put(key2, "value2");

		key.setName("saratmodified"); // modify the key object
		map.put(key, "new value"); // this will create a new entry in the map
		System.out.println(map.entrySet().stream().map(entry -> new CustomObjectO(entry.getKey(), entry.getValue()))
				.collect(Collectors.toList()));
		System.out.println(map.get(new MyKey("sarat"))); // prints "value"
		System.out.println(map.get(new MyKey("saratmodified"))); // prints "new value"

	}

}

class MyKey {
	private String name;

	public MyKey(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof MyKey))
			return false;
		MyKey other = (MyKey) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return "MyKey [name=" + name + ", hashCode()=" + hashCode()+" ]";
	}

}

class CustomObjectO {
	private MyKey key;
	private String value;

	public CustomObjectO(MyKey myKey, String value) {
		this.key = myKey;
		this.value = value;
	}

	public MyKey getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "CustomObject{" + "key='" + key + '\'' + ", value='" + value + '\'' + '}';
	}
}
