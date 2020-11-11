import connect.helper.example.AbstGameConnectHelper;
import connect.helper.example.DefaultGameConnectHelper;

public class TemplateMethod {
    /**
     * Template method pattern
     * - 알고리즘의 구조를 메서드에 정의하고,
     * - 하위 클래스에서 알고리즘 구조의 변경없이 알고리즘을 재정의 하는 패턴
     *
     * - [Abstract Class] 알고리즘을 여러 단계로 나눈다.
     * - [Abstract Class] 나눠진 알고리즘의 단계를 메서드로 선언한다.
     * - [Abstract Class] 알고리즘을 수행할 템플릿 메서드를 만든다.
     * - [Concrete Class] 하위 클래스에서 나눠진 메서드들을 구현한다.
     *  -- 상속받아 나눠진 알고리즘의 단계 내부를 명세하는 것
     *  -- 단계는 일정하되<핵심>, 내부적으로 돌아가는 알고리즘이 다 다른경우 클래스마다 다르게 만들어 적용시킬 수 있다.
     *
     * - 구현하려는 알고리즘이 일정한 프로세스가 있는 경우
     * - 구현하려는 알고리즘이 변경 가능성이 있는 경우
     *
     * - 지금은 GameConnectHelper concrete class 가 하나만 정의되어 있지만,
     *  -- PaidGameConnectHelper, WebGameConnectHelper 등 여러 다른 concrete class 가 정의된다고 하자.
     * - 그러면, 기존 알고리즘 선언방식은 유지되지만 내부 메서드들의 처리가 달리 작동해야하므로 AbstGameConnectHelper interface 를 상속받아 내부에서 구현해줘야한다.
     */
    public static void main(String[] args) {
        AbstGameConnectHelper helper = new DefaultGameConnectHelper();
        // 메서드를 사용하는 측에서는 단순히 알고리즘이 구현되어있는 메서드만 활용하면 된다.
        String connectionMessage = helper.requestConnection("ID:HelloJava/PW:YouKnowJavaDesignPattern");
        System.out.println(connectionMessage);

        connectionMessage = helper.requestConnection("ID:HelloJava2/PW:YouKnowJavaDesignPattern");
        System.out.println(connectionMessage);

        connectionMessage = helper.requestConnection("ID:HelloJava3/PW:YouKnowJavaDesignPattern");
        System.out.println(connectionMessage);
    }
}
