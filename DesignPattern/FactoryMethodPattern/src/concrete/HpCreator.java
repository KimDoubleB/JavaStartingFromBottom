package concrete;

import framework.Item;
import framework.ItemCreator;

import java.util.Date;

public class HpCreator extends ItemCreator {
    @Override
    protected void requestItemInfo() {
        System.out.println("데이터베이스에서 체력 회복 물약의 정보를 가져온다.");
    }

    @Override
    protected void createItemLog() {
        System.out.println("체력 회복 물약을 새로 생성했다 " + new Date());
    }

    @Override
    protected Item createItem() {
        // 원래라면 어떠한 파라미터들을 통해 데이터를 만들어내는 작업을 수행할 것
        return new HpPotion();
    }
}
