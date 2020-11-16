import concrete.BigHpCreator;
import concrete.HpCreator;
import concrete.MpCreator;
import framework.Item;
import framework.ItemCreator;

import java.util.ArrayList;
import java.util.Arrays;

public class FactoryMethodPattern {
    /**
     * Factory method pattern
     * 객체 생성 처리를 서브 클래스로 분리해 처리하도록 캡슐화하는 패턴
     * 객체의 생성코드를 별도의 클래스/메서드로 분리함으로서 객체생성의 변화에 대비하는데 유용
     *
     * 조건에 따라 객체를 다르게 생성해야 할 때가 존재한다.
     * - 조건문, 분기에 따라 객체를 다르게 생성해야 했음.
     * - Factory method 에서는 분기에 따른 객체의 생성을 직접하는 것이 아니라 팩토리라는 클래스에 위임하여 객체를 생성하도록 하는 방식
     *
     * 즉, 객체를 만들어내는 공장 (Factory)을 만드는 패턴
     */
    public static void main(String[] args) {
        ItemCreator creator;
        Item item;

        /*
        장점
        - create 하는데 있어서 내부에서 기능적 변화가 있더라도, main 클래스는 변화할 것이 하나도 없다.
        - 단순히 creator 를 상속받은 클래스에서 기능적으로 변화를 주면 알아서 작동하게 된다.
        - 또한, create 하는 것에 있어서 여러 기능의 클래스별로 한 코드 내에서 다르게 생성하는 것이 아닌 클래스로 만들고,
        상속받은 메서드만을 수정하여 다르게 만들어 작동하게 만들 수 있다.
         */

        creator = new HpCreator();
        item = creator.create();
        item.use();

        creator = new MpCreator();
        item = creator.create();
        item.use();

        ItemCreator[] creatorArray = {new HpCreator(), new MpCreator(), new BigHpCreator()};
        ArrayList<ItemCreator> creators = new ArrayList<>(Arrays.asList(creatorArray));
        for (ItemCreator c : creators){
            item = c.create();
            item.use();
        }

        // 결국, 새로운 기능을 만들기 위해서는 미리 만들어놓은 생성 클래스와 인터페이스를 상속받아 새로운 클래스들을 만들면 된다.
        // 이 과정속에서 template method 구조를 활용하고, 유지보수를 용이하게 만든다.
        // -> 이 총체적인 과정이 Factory method pattern
    }
}
