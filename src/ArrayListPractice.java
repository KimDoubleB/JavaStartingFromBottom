import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayListPractice {
    /**
     * ArrayList extends list interface
     *  add, remove, addAll, removeAll
     *  get, set
     *  replaceAll, clear, equals
     *  size
     *  isEmpty, iterator, toArray
     *  contains, containsAll
     *  indexOf, lastIndexOf
     *  listIterator, subList
     */

    public ArrayListPractice(){
        testArrayList();
    }

    private void testArrayList(){
        ArrayList<Number> arrayList = new ArrayList();
        arrayList.add(2);
        arrayList.add(2.3123213);
        arrayList.add(42121312);
        arrayList.add(242141);
        arrayList.add(53.423423);
        System.out.println(arrayList);
        System.out.println(arrayList.size());

        arrayList.remove(1);
        arrayList.remove(Integer.valueOf(2));

        ArrayList<Number> numberArrayList = new ArrayList<>(Arrays.asList(1, 2.4124, 5, 21412));
        System.out.println(numberArrayList);
        if(numberArrayList.contains(1)){
            numberArrayList.replaceAll( e -> e.doubleValue() );
        }
        if(numberArrayList.contains(1.00000)){
            numberArrayList.remove(numberArrayList.indexOf(1.0000));
        }
        System.out.println(numberArrayList);

        numberArrayList.clear();
        System.out.println(numberArrayList);
    }

    private void printAllArrayList(ArrayList al) {
        for (Object o : al) {
            System.out.printf("%s %d\n", o.getClass(), o);
        }
    }

    private void printAllArrayListUsingIterator(ArrayList<Object> al) {
        Iterator<Object> iter = al.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
