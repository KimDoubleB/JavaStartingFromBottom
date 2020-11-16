package concrete;

import framework.Item;
import framework.ItemCreator;

import java.util.Date;

public class MpCreator extends ItemCreator {
    @Override
    protected void requestItemInfo() {
        System.out.println("데이터베이스에서 마력 회복 물약의 정보를 가져온다.");
    }

    @Override
    protected void createItemLog() {
        System.out.println("마력 회복 물약을 새로 생성했다 " + new Date());
        System.out.println("마력 회복 물약의 경우, 체력 회복 물약과 달리 스페셜하다.");
    }

    @Override
    protected Item createItem() {
        return new MpPotion();
    }
}
