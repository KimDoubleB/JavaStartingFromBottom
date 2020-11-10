import java.util.Arrays;

public class ArrayPractice {
    public ArrayPractice(){
        System.out.println("Here - ArrayPractice constructor");
        printArray();
    }
    private void printArray(){
        int[] integers = {1, 2, 3, 4, 5, 6};
        String[] people = {"mike", "bob", "john"};
        StringBuffer[] cafeMaker = new StringBuffer[10];
        // ArrayIndexOutOfBoundsException 조심하자.
        for (int i = 0; i < cafeMaker.length; ++i){
            cafeMaker[i] = new StringBuffer("starbucks " + (i+1));
            System.out.println(cafeMaker[i]);
        }

        // 그냥 출력하면 reference 출력
        System.out.println(integers);
        System.out.println(people);

        // python 의 array 처럼 출력을 하고싶다면, java.util.Arrays 를 이용하자.
        System.out.println(Arrays.deepToString(cafeMaker));
        System.out.println(Arrays.toString(cafeMaker));
    }
}
