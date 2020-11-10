import java.util.*;

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
        System.out.println("Here - ArrayListPractice constructor");
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

        ArrayList<Number> numberArrayList = new ArrayList<>(Arrays.asList(321421, 412421, 32.2, 32.5, 32.0, 1, 2.4124, 5, 21412));
        System.out.println(numberArrayList);
        if(numberArrayList.contains(1)){
            numberArrayList.replaceAll( e -> e.doubleValue() );
        }
        if(numberArrayList.contains(1.00000)){
            numberArrayList.remove(numberArrayList.indexOf(1.0000));
        }
        System.out.println(numberArrayList);

        // using Collections and explicit comparator
        Collections.sort(numberArrayList, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                int compareValue;
                if (o1.intValue() > o2.intValue())
                    compareValue = 1;
                else if (o1.intValue() == o2.intValue())
                    compareValue = 0;
                else
                    compareValue = -1;
                return compareValue;
            }
        });

        numberArrayList.sort((Number n1, Number n2) -> compareTo(n1, n2));  // using lambda
        numberArrayList.sort(this::compareTo);                              // using method reference
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

    private int compareTo(Number number1, Number number2){
        int compareValue;
        if (number1.intValue() > number2.intValue())
            compareValue = 1;
        else if (number1.intValue() == number2.intValue())
            compareValue = 0;
        else
            compareValue = -1;
        return compareValue;
    }
}
