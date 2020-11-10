import javax.sound.sampled.Line;
import java.util.*;
import static java.util.Arrays.*;

public class HashMapPractice {
    /*
    map: key-value pair 형식
    - key 와 value 매칭
    - put, get, remove

    HashMap
    - key, value 에 null 저장가능
    - not thread safe
        -- thread safe 사용하고 싶다면 HashTable 사용
        -- 대신, key-value 에 null 사용불가
    - keySet(), values()
    - entrySet() -> key, value 둘 다 가져올 수 있다. getkey(), getValue()
    - containsKey(), containsValue()
     */
    public static void testHashMap(){
        System.out.println("Here - testHashMap");

        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("A", "ABCDED");
        stringMap.put("B", "adfdsa");
        stringMap.put("B", "안뇽");   // 중복 key인 경우, 덮어씌워진다.
        stringMap.put("C", "gfdhfd");
        stringMap.put("D", "twetwre");
        stringMap.put("E", "qewewq");
        stringMap.put("F", "yku");
        System.out.println(stringMap);

        Map<String, List<Integer>> stringIntegerListMap = new HashMap<>();
        stringIntegerListMap.put("List", asList(1, 2, 3, 4, 5));
        stringIntegerListMap.put("Empty", Collections.emptyList());
        stringIntegerListMap.put("Singleton", Collections.singletonList(123));
        stringIntegerListMap.put("Null", null);
        // keySet, values
        System.out.println(stringIntegerListMap);
        System.out.println(stringIntegerListMap.keySet());
        System.out.println(stringIntegerListMap.values());

        // using Map.Entry -> getKey, getValue
        Set<Map.Entry<String, List<Integer>>> entries = stringIntegerListMap.entrySet();
        System.out.println(entries);
        for(Map.Entry<String, List<Integer>> tempEntry : entries){
            System.out.println(tempEntry);
            System.out.println(tempEntry.getKey() + " " + tempEntry.getValue());
        }

        // containsKey, containsValue
        if(stringIntegerListMap.containsKey("Null") ||
            stringIntegerListMap.containsKey("null")){
            System.out.println("Contains Key \"NULL\"");
            stringIntegerListMap.remove("Null");
            stringIntegerListMap.remove("null");
            stringIntegerListMap.put("NotNull", new LinkedList<>());
        }

        // 그냥 한 것. hashMap 은 순서가 없다.
        if(stringMap.containsValue("twetwre")){
            System.out.println("Contains Value \"twetwre\"");
            Iterator<String> iter = stringMap.values().iterator();
            int index = 0;
            while(iter.hasNext()){
                if (iter.next().equals("twetwre"))
                    break;
                index++;
            }

            for (int i = 0; i < stringMap.keySet().size(); ++i){
                if (i == index){
                    System.out.println(stringMap.keySet().toArray()[i]);
                    System.out.println(stringMap.get(stringMap.keySet().toArray()[i]));
                }
            }
        }




    }
}
