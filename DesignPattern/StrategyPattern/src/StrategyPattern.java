import java.util.ArrayList;
import java.util.Arrays;

public class StrategyPattern {
    /**
     * interface 개념 이해
     * - 기능에 대한 선언과 구현분리
     *  -- 선언: interface
     *  -- 구현: class (implements)
     * - 기능 사용통로
     *  -- 사용 시, interface 에 implements 받은 클래스 인스턴스를 만들어 사용
     *
     * delegate 개념 이해
     * - 위임하다, 떠넘기다
     * - 두 객체간의 관계를 나타내는데 사용된다.
     * - 다른 클래스에서 선언된 기능을 활용해 문제를 해결하는 것.
     */

    /**
     * StrategyPattern
     * - 행위를 클래스로 캡슐화해 동적으로 행위를 자유롭게 바꿀 수 있게 해주는 패턴
     * - 같은 문제를 해결하는 여러 알고리즘 => 캡슐화해 상황에 맞게 사용하여 어떤 문제를 해결
     * - 즉, 전략을 상황에 맞게 쉽게 바꿀 수 있는 디자인 패턴
     */

    public static void main(String[] args) {
        // 인터페이스를 이용해 무기 리스트를 선언
        ArrayList<Weapon> weaponList = new ArrayList<>(Arrays.asList(new Bow(), new Knife(), new Gun()));

        Client anonymousClient = new Client();
        anonymousClient.useWeapon();    // default weapon is hand

        // 알고리즘을 쉽게 변경하며 작동할 수 있다.
        for(Weapon newWeapon : weaponList){
            anonymousClient.setClientWeapon(newWeapon);
            anonymousClient.useWeapon();
        }
    }
}
