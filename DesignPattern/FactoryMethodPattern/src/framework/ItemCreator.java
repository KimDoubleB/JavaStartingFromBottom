package framework;

public abstract class ItemCreator {

    // Template method pattern
    // 어떠한 순서의 알고리즘이 있고, 상세 메서드의 경우 상속되어 기능이 명시된다.

    // 이 method 를 Factory method 라고 한다. -> 템플릿 메서드와 같이 활용된다.
    public Item create(){
        Item item;

        requestItemInfo();      // step 1
        item = createItem();    // step 2
        createItemLog();        // step 3

        return item;
    }

    // 아이템 생성 전, 데이터베이스에서 아이템 정보를 요청
    abstract protected void requestItemInfo();

    // 아이템 생성 후, 아이템 복제 등의 불법을 방지하기 위해 데이터베이스에 아이템 생성.
    abstract protected void createItemLog();

    // 아이탬 생성하는 알고리즘
    abstract protected Item createItem();
}
