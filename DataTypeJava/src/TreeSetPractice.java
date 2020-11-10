import java.util.*;

public class TreeSetPractice {
    /*
    Set Collection class
    - 요소의 저장순서를 유지하지 않는다.
    - 같은 요소의 중복저장을 허용하지 않는다.

    SortedSet <Interface> <- NavigableSet <Interface> <- TreeSet <Class>

    TreeSet class
    - 데이터가 정렬된 상태로 저장되는 이진검색트리의 형태로 요소 저장
        -- 모든 노드는 최대 두 개의 자식노드를 가질 수 있다.
        -- 왼쪽 자식노드의 값은 부모노드의 값보다 작고, 오른쪽 자식노드의 값은 부모노드보다 크다.
        -- 노드의 추가 및 삭제에 시간이 걸린다.
        -- 검색과 정렬에 유리하다.
    - 기존 이진검색트리의 성능을 향상시킨 레드-블랙 트리로 구현
    - 이진검색트리 형태로서 정렬, 검색, 범위검색에서 높은 성능을 보임

    - 어떻게보면 결과론적으로 Priority Queue 와 비슷하다고 느꼈다.
    - 또한, 둘다 add/remove/contains 에 O(logN)의 시간복잡도를 가지며, not thread-safe 하다.
    - 하지만, 차이점이 여럿 존재한다.
        -- TreeSet 은 unique value 만 가지고있으며, Queue API 를 제공하지 않는다.
        -- TreeSet 은 iterator 를 통해 순차적인 element 접근이 가능하나, PriorityQueue 는 불가능하다. peek/poll 을 통해 접근 가능.
    */

    public static void testTreeSet(){
        TreeSet<Integer> integerTreeSet = new TreeSet<>(Arrays.asList(5, 7, 1, 0, 5124121, -1, 421421));
        System.out.println(integerTreeSet); // 자동 정렬
        integerTreeSet.add(42);
        integerTreeSet.add(-42);
        System.out.println(integerTreeSet); // 자동 정렬
        integerTreeSet.add(-1); // duplicate value
        System.out.println(integerTreeSet); // 역시나 안들어감

        integerTreeSet.addAll(new ArrayList<>(Arrays.asList(421,312321,1232,123321,12,-1231,21412,321,2,66,24,-231,-214214,-9,-123, 214212)));
        System.out.println(integerTreeSet);

        // contains, containsAll 지원
        System.out.println(integerTreeSet.contains(1) + " " + integerTreeSet.containsAll(Arrays.asList(1, -1, 0)));

        // 최소 및 최대
        System.out.println(integerTreeSet.first() + " " + integerTreeSet.last());

        // -2와 가장 가까이 있는 값 -> -2보다 높은 값, -2보다 낮은 값
        // 없으면 Null
        System.out.println(integerTreeSet.ceiling(-2) + " " + integerTreeSet.floor(-2));
        System.out.println(integerTreeSet.higher(-2) + " " + integerTreeSet.lower(-2));

        // poll 지원 -> 값 빼내며 반환
        System.out.println(integerTreeSet.pollFirst());
        System.out.println(integerTreeSet.pollLast());
        System.out.println(integerTreeSet);

        // 반대 정렬로 전환
        System.out.println(integerTreeSet.descendingSet());
        System.out.println(integerTreeSet.descendingSet().getClass());

        // 시작범위, 끝범위로 set 나누기
        Set<Integer> headToSmaller10 = integerTreeSet.headSet(10);
        Set<Integer> tailToGreater10 = integerTreeSet.tailSet(10);
        System.out.println(headToSmaller10);
        System.out.println(tailToGreater10);

        // 문자열 Tree
        TreeSet<String> stringTreeSet = new TreeSet<String>();
        for(int i = 0; i < 100; ++i)
            stringTreeSet.add(getRandomString().toString());
        System.out.println(stringTreeSet);

        // 'a' ~ 'e' 사이의 set을 구해보자
        Set<String> aToeSet = stringTreeSet.subSet("a", "e");
        System.out.println(aToeSet);

        // '0' ~ '9' 사이의 set을 구해보자
        Set<String> From0To9Set = stringTreeSet.subSet("0", "9");
        System.out.println(From0To9Set);

    }

    public static StringBuffer getRandomString(){
        StringBuffer temp = new StringBuffer();
        Random rnd = new Random();
        for (int i = 0; i < 20; i++) {
            int rIndex = rnd.nextInt(3);
            switch (rIndex) {
                case 0:
                    // a-z
                    temp.append((char) ((int) (rnd.nextInt(26)) + 97));
                    break;
                case 1:
                    // A-Z
                    temp.append((char) ((int) (rnd.nextInt(26)) + 65));
                    break;
                case 2:
                    // 0-9
                    temp.append((rnd.nextInt(10)));
                    break;
            }
        }
        return temp;
    }
}
