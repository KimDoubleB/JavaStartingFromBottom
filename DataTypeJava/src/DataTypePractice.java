import javax.management.ValueExp;
import java.util.Arrays;

public class DataTypePractice {
    public static void main(String[] args){
        // 정수
        int integer = 10;
        long longInteger = 987654321L;

        // 실수
        // Java에서는 double이 default이므로, flaot형에 값 대입시 F를 입력해주어야한다.
        float pi = 3.14F;
        double morePi = 3.14159265358979323846;
        double morePi2 = 0.314159265358979323846e2;

        // 8진수와 16진수
        int octalNumber = 023;  // 19
        int hexNumber = 0xC;    // 12

        int operationResult;
        operationResult = integer + integer;
        operationResult = operationResult - integer;
        operationResult = operationResult / integer;
        operationResult = operationResult % integer;

        operationResult++;
        operationResult--;
        ++operationResult;
        --operationResult;

        boolean isSucess = true;
        boolean isFail = false;
        if (isSucess){
            integer = 1;
        }

        if (integer == 1 && !isFail){
            integer = 2;
        }

        boolean isEven  = integer % 2 == 0;
        boolean isOdd   = integer % 2 == 1;

        char characterValue = 'c';
        int integerValue = (int)characterValue;

        // String data type -> immutable
        String stringData = "Hello Java, Long time no see.";
        String stringData2 = new String("Hello Java, Long time no see.");

        // 값은 같으나, 가리키는 주소는 다르다.
        if (stringData.equals(stringData2)){
            System.out.println("String1 equals string2");
        }

        if (stringData != stringData2){
            System.out.println("String1 memory address: " + System.identityHashCode(stringData));
            System.out.println("String2 memory address: " + System.identityHashCode(stringData2));
        }

        // print '6'
        System.out.println(stringData.indexOf("Java"));
        // print 'Hello Javascript, Long time no see.'
        System.out.println(stringData.replaceAll("Java", "Javascript"));
        // print 'Hello'
        System.out.println(stringData.substring(0, 5));
        // print all upper case, all lower case
        System.out.println(stringData.toUpperCase());
        System.out.println(stringData.toLowerCase());

        // immutable data type
        // String 데이터가 변경되면, 아예 새로운 String을 만들어버린다.
        String stringData3 = "Hello Java";
        System.out.println(stringData3);
        System.out.println("Before data address: " + System.identityHashCode(stringData3));
        stringData3 += 11;
        System.out.println(stringData3);

        // StringBuffer -> mutable
        StringBuffer stringBufferData = new StringBuffer("Hello Java");
        System.out.println("Before data address: " + System.identityHashCode(stringBufferData));
        stringBufferData.append(", Long time ");
        stringBufferData.append("no see.");
        System.out.println(stringBufferData);
        // equal address -> before data address
        System.out.println("After data address: " + System.identityHashCode(stringBufferData));

        // indexOf, substring 같은 String method는 똑같이 활용 가능하다.
        // 원하는 위치에 문자열 추가하기
        stringBufferData.insert(stringBufferData.indexOf(","), "11");
        System.out.println(stringBufferData);

        ArrayPractice.printArray();
        printLine(15);

        new VectorPractice();
        printLine(15);

        new ArrayListPractice();
        printLine(15);

        new LinkedListPractice();
        printLine(15);

        HashSetPractice.testHashSet();
        printLine(15);

        TreeSetPractice.testTreeSet();
        printLine(15);
    }


    public static void printLine(int length){
        StringBuffer line = new StringBuffer();
        for (int i = 0; i < length; ++i){
            line.append("-");
        }
        System.out.println(line);
    }
}
