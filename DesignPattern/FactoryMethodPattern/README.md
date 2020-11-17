# Factory Method Pattern

객체 생성 처리를 서브 클래스로 분리해 처리하도록 캡슐화하는 패턴  
객체의 생성코드를 별도의 클래스/메서드로 분리함으로서 객체생성의 변화에 대비하는데 유용

### Advantages
- create 하는데 있어서 내부에서 기능적 변화가 있더라도, main 클래스는 변화할 것이 하나도 없다.
- 단순히 creator 를 상속받은 클래스에서 기능적으로 변화를 주면 알아서 작동하게 된다.
  - 여기서 Template method pattern이 사용된다.
  - create하는 부분은 상위 추상 클래스에서 과정을 선언해놓고, 상속받아 그 명시적은 과정에 대한 메서드를 override하게 작성한다.
- 또한, create 하는 것에 있어서 여러 기능의 클래스별로 한 코드 내에서 다르게 생성하는 것이 아닌 클래스(creator class)로 만들고,
상속받은 메서드만을 수정하여 다르게 만들어 작동하게 만들 수 있다.

### Example
Main에서 아이템을 만들어내기 위해서는 ItemCreator만을 사용하면 된다. 여기에 원하는 아이템 creator class를 사용해서 create (template method)를 이용하면 된다.
- HpCreator, MpCreator, BigHpCreator 같이 ItemCreator 추상 클래스를 상속받은 클래스들에서 create 과정 method들을 override 하고 있어 Main에서는 단순히 create로 접근해서 아이템을 만들어낼 수 있다.
- 아이템도 마찬가지로 Item interface를 implements 하고 있어 아이템 사용하는 메서드마다 다르게 구현이 가능하며, 각 creator에서 알맞은 인스턴스를 만들어 반환하면 된다. 


### Diagram
![image](https://user-images.githubusercontent.com/37873745/99347428-76708800-28da-11eb-97f5-04852548db75.png)
![image](https://user-images.githubusercontent.com/37873745/99347438-7bcdd280-28da-11eb-9ef4-a251482d96b2.png)