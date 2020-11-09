import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

public class VectorPractice {
    /**
     * Vector extends list interface
     *  add, remove, addAll, removeAll
     *  get, set
     *  replaceAll, clear, equals
     *  size, capacity
     *  isEmpty, iterator, toArray
     *  contains, containsAll
     *  indexOf, lastIndexOf
     *  listIterator, subList
    */

    public VectorPractice(){
        System.out.println("Here - VectorPractice constructor");
        testVector();
    }
    private void testVector(){
        // 타입 미설정 - Object 형으로 선언
        Vector v = new Vector();

        // Type을 명시하지 않으면 (제네릭 미사용), 여러 값들을 다 넣을 수 있다.
        // Python list처럼...!
        v.add(Integer.valueOf(2));          // 2, Integer
        v.add(new String("12"));    // 12, String
        v.add(new String("c"));     // c, String
        v.add(new StringBuffer[100]);       // StringBuffer
        v.add(1, new Arrays[100]);      // index 지정, Arrays
        System.out.println(v.getClass());
        System.out.println(Arrays.toString(v.toArray()));
        for(int i = 0; i < v.size(); ++i){
            System.out.print(v.get(i));
            System.out.print(' ');
            System.out.println(v.get(i).getClass());
        }
        v.remove(1);
        v.remove("12");
        printAllVector(v);
        printAllVectorUsingIterator(v);
        // 하지만 타입을 명시하지 않으면, 잘못된 타입에 대한 에러처리가 힘들고, 명시하는 게 좋다고 하다.

        Vector<String> stringVector = new Vector<String>();
//        Vector<String> stringVector = new Vector<>(); // 생략가능
        Vector<String> stringInitSizeVector = new Vector<>(10);
        System.out.println(stringInitSizeVector.capacity());
        System.out.println(stringInitSizeVector.size());
        for(int i = 0; i < stringInitSizeVector.capacity(); i++){
            stringInitSizeVector.add(Integer.toString(i));
            System.out.printf("string size: %d\n",stringInitSizeVector.size());
        }

        // Arrays.asList() 를 통해 초기값도 지정할 수 있다.
        stringInitSizeVector = new Vector<>(Arrays.asList("A", "B", "C"));
        System.out.println(Arrays.toString(stringInitSizeVector.toArray()));
        System.out.println(stringInitSizeVector.size());
        System.out.println(stringInitSizeVector.capacity());

        // 사실, list는 print하면 내용물이 자동으로 다 나온다.
        System.out.println(stringInitSizeVector);
    }

    private void printAllVector(Vector v){
        System.out.println("- printAllVector method");
        for (Object o : v) {
            System.out.print(o);
            System.out.print(' ');
            System.out.println(o.getClass());
        }
    }

    private void printAllVectorUsingIterator(Vector v){
        System.out.println("- printAllVectorUsingIterator method");
        Iterator iter = v.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}
