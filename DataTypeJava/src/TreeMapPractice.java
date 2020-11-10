import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapPractice {
    /*
    map: key-value pair 형식
    - key 와 value 매칭
    - put, get, remove

    TreeMap
    - HashMap 과 거의 비슷하다. 하지만 정렬의 개념이 추가되었다.
    - key 값을 기준으로 정렬하여 Map 형태로 저장하는 자료구조
    - 숫자 > 알파벳 대문자 > 알파벳 소문자 > 한글 : 아스키코드 순으로 정렬되는 듯
    - 순서개념이 있어 HashMap 과 달리 First, Last, Higher, Lower 메서드가 존재한다.
    - Entry 로 접근해서 getKey, getValue 식으로 진행을 자주하는 듯
        -- Map.Entry<K, V> => getKey(), getValue()

    - keySet(), values()
    - entrySet() -> key, value 둘 다 가져올 수 있다. getkey(), getValue()
    - containsKey(), containsValue()
 */
    public static void testTreeMap(){
        System.out.println("Here - testTreeMap");

        TreeMap<String, String> stringTreeMap = new TreeMap<>();
        stringTreeMap.put("1 Second", "1 data");
        stringTreeMap.put("0 First", "0 data");
        stringTreeMap.put("2 Third", "2 data");
        stringTreeMap.put("4 Fifth", "4 data");
        stringTreeMap.put("3 Fourth", "3 data");
        System.out.println(stringTreeMap);

        // 랜덤하게 넣었음에도 정렬되어 나온다.
        Set<Map.Entry<String, String>> stringEntries = stringTreeMap.entrySet();
        for (Map.Entry<String, String> tempStringEntry : stringEntries){
            System.out.println("KEY - VALUE");
            System.out.println(tempStringEntry.getKey() + " - " + tempStringEntry.getValue() + "\n");
        }

        // 순서 개념이 있다보니 first, last, higher, lower 에 대한 개념이 있다.

        // first, last key
        System.out.println("First Last key");
        System.out.println(stringTreeMap.firstKey());
        System.out.println(stringTreeMap.get(stringTreeMap.firstKey()));
        System.out.println(stringTreeMap.firstEntry());

        System.out.println(stringTreeMap.lastKey());
        System.out.println(stringTreeMap.get(stringTreeMap.lastKey()));
        System.out.println(stringTreeMap.lastEntry());

        // higher, lower
        System.out.println("Higher Lower key");
        // "2" key 보다 높거나 같은 key
        System.out.println(stringTreeMap.higherKey("2"));
        // "2" key 보다 낮은 key
        System.out.println(stringTreeMap.lowerKey("2"));
    }
}
