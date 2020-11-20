public class PrototypePattern {
    /**
     * Prototype Pattern
     * 생산비용이 높은 인스턴스 또는 다수의 인스턴스 생성을 복사를 통해 쉽게 생성할 수 있도록 만든 패턴
     * 원형이 되는 (Prototypical) 인스턴스를 사용하여 생성할 객체의 종류를 명시하고, 이렇게 만든 견본을 복사해 새로운 객체를 생성한다.
     *
     * 복사
     * - Object clone () 을 사용한다. (deep copy)
     * - 이를 사용하기 위해서는 Java 에서 제공하는 Cloneable interface 를 사용한다.
     *
     * 사용 이유
     * - DB 에서 데이터를 가져오는데 한번 요청한 데이터는 계속해서 요청하는 흐름이 있는 경우, 데이터를 한 번 가져와 프로토타입으로 두고 클론해 사용한다.
     * -> 네트워크 또는 데이터베이스에 접근해서 데이터를 가져오는 것보다 복사하는 것이 훨씬 빠르다고 하다.
     *
     * 에제
     * - 그림 그리기 툴을 개발 중 -> 어떤 모양을 그릴 수 있도록 하고 복사 및 붙여넣기 기능이 필요하다.
     * - 복사 시에 도형이 완전히 겹치지 않도록 도형의 위치를 약간 움직여서 복사되도록 한다.
     *
     * 이 예제에서는 단순히 도형의 위치만을 사용했지만, 데이터가 많이 복잡해지고 하면 할수록 더 유용하게 활용될 수 있다.
     */

    public static void main(String[] args) throws CloneNotSupportedException {
        Circle circle1 = new Circle(1, 1, 3);
        Circle circle2 = circle1.copy();    // deep copy
        Circle circle3 = circle1;           // shallow copy

        System.out.println(circle1.getX() + " " + circle1.getY() + " " + circle1.getR());
        System.out.println(circle2.getX() + " " + circle2.getY() + " " + circle2.getR());

        System.out.println(circle1.hashCode());
        System.out.println(circle2.hashCode());
        System.out.println(circle3.hashCode());
    }
}
