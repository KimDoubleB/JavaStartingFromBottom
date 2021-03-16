package lab;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    private static final int MAGIC_NUMBER = 27;
    public static void main(String[] args)
            throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        // 클래스를 가져오자.
        Class class1 = Secret.class;
        Class class2 = Class.forName("lab.Secret"); // package + class name
        System.out.println(class1);
        System.out.println(class2);
        /*
        출력

        class lab.Secret
        class lab.Secret
         */


        // 클래스의 생성자를 가져오자 - 모든 클래스 생성자 가져오기 (private, public)
        Constructor[] constructor = class2.getDeclaredConstructors();
        for(var cons : constructor){
            System.out.println(cons);
        }

        // 클래스의 메서드를 가져오자 - 모든 메서드 가져오기
        Method[] methods = class2.getDeclaredMethods();
        for(var method : methods){
            System.out.println(method);
        }

        Field[] fields = class2.getDeclaredFields();
        for(var field : fields){
            System.out.println(field);
        }
        /*
        출력

        public lab.Secret()
        private lab.Secret(java.lang.String)

        public void lab.Secret.openMethod()
        private void lab.Secret.secretMethod()
        private java.lang.String lab.Secret.getSecretEncryptKey(int)

        private java.lang.String lab.Secret.encryptKey
        private java.lang.String lab.Secret.secretInfo
        public java.lang.String lab.Secret.openInfo
         */

        
        // 생성자 호출하기
        Class realClass = Class.forName("lab.Secret");  // 클래스 가져오기
        Class[] parameterTypes = {String.class};        // 파라미터 타입 가져오기
        Constructor realConstructor = realClass.getDeclaredConstructor(parameterTypes); // 해당 클래스에서 파라미터 타입에 맞는 생성자 가져오기
        realConstructor.setAccessible(true);    // private 생성자를 호출할 수 있게 변환 !
//        Secret obj = (Secret) realConstructor.newInstance(); // 파라미터 하나가 필요한데, 컴파일 에러가 안남. (런타임 에러)
        Secret secret = (Secret) realConstructor.newInstance("encrypt Key!!!");

        // 메서드 호출하기 - invoke
        Method method = methods[2]; // private java.lang.String lab.Secret.getSecretEncryptKey(int)
        method.setAccessible(true); // private -> 접근허용
        System.out.println(method.invoke(secret, MAGIC_NUMBER));
        /*
        출력

        사실 멤버 encrypt key 값은 이상한거에요ㅋㅋ
        이게 진짭니다.
        encrypt Key!!!1000028
         */


        // 필드 값 변경하기
        Field field = fields[0];    // private java.lang.String lab.Secret.encryptKey
        field.setAccessible(true);  // private -> 접근허용
        System.out.println(field.get(secret));
        field.set(secret, "changed key !!!");  // 필드 값 변경
        System.out.println(field.get(secret));
        /*
        출력

        encrypt Key!!!
        changed key !!!
         */



        // 다시 암호화 키 가져오는 메서드 호출
        System.out.println(method.invoke(secret, MAGIC_NUMBER));
        /*
        출력

        사실 멤버 encrypt key 값은 이상한거에요ㅋㅋ
        이게 진짭니다.
        changed key !!!1000028
         */
    }
}
