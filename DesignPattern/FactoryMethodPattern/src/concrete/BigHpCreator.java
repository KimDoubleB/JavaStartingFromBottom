package concrete;

import framework.Item;

public class BigHpCreator extends HpCreator{
    @Override
    protected void requestItemInfo() {
//        super.requestItemInfo();
        System.out.println("더더더 큰 물약의 정보를 가져온다.");
    }

    @Override
    protected void createItemLog() {
//        super.createItemLog();
        System.out.println("더더더 큰 물약 사용.");
    }

    @Override
    protected Item createItem() {
        return new BigHpPortion();
    }
}
