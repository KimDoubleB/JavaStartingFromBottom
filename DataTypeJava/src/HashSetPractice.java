import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetPractice {
    /*
    Set Collection class
    - 요소의 저장순서를 유지하지 않는다.
    - 같은 요소의 중복저장을 허용하지 않는다.

    HashSet Class
    - HashSet class 는 hash algorithm 을 사용해 검색속도가 매우 빠르다.
    - Set 형식을 따르므로 요소를 순서에 상관없이 저장하고, 중복된 값은 저장하지 않는다.
    - 저장순서를 유지해야하는 경우, LinkedHashSet 을 이용해야만 한다.
    - 이미 존재하는 요소인지 파악하기 위해서는 내부적으로 hashCode() 메서드를 이용한다.
        -- 각 요소에서 hashCode() 메서드를 호출해 반환 한 해시값으로 다른 요소들간의 equals() 를 통해 비교한다.

     */
    public static void testHashSet(){
        System.out.println("Here - testHashSet");

        HashSet<String> hashSetData = new HashSet<String>();
        ArrayList<HashSet<String>> arrayListHashSetData = new ArrayList<>(10);
        HashSet<ArrayList<String>> hashSetArrayListData = new HashSet<>();

        hashSetData.add("Hello");
        hashSetData.add("Java");
        hashSetData.add("Collections");
        hashSetData.add("HashSet");
        hashSetData.add("Collections"); // 중복데이터 - 저장안됨

        System.out.println(hashSetData);

        if(hashSetData.contains("HashSet")){
            // duplicated "HashSet"
            hashSetData.add("Hash set");
        }
        else if(hashSetData.isEmpty()){
            hashSetData.add("Empty Hash set");
        }
        else{
            hashSetData.add("HashSet");
        }
        System.out.println(hashSetData + " " + hashSetData.size());
        hashSetData.remove("Collections");
        System.out.println(hashSetData + " " + hashSetData.size());

        Iterator<String> hashSetIter = hashSetData.iterator();
        while (hashSetIter.hasNext()){
            String currentString = hashSetIter.next();
            System.out.println(currentString);
            if (currentString.hashCode() == "HashSet".hashCode()){
//            if (currentString.equals("HashSet")){ // Same above
                System.out.println("Here Duplicated \"HashSet\" String");
                break;
            }
        }

        System.out.println(System.identityHashCode(hashSetData) + " " + hashSetData.hashCode());
        arrayListHashSetData.add(hashSetData);
        for(HashSet<String> hs : arrayListHashSetData){
            System.out.println(hs);
        }

    }
}
