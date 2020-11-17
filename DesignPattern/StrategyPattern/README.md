# Strategy Pattern

객체가 할 수 있는 행위들 각각을 전략으로 만들어 놓고, 동적으로 행위의 수정이 필요한 경우 전략을 바꾸는 것만으로 행위의 수정이 가능하도록 만든 패턴

### Advantages
Context 코드의 변경없이 새로운 전략(interface 활용하는)을 추가할 수 있다.
즉, 기존의 코드를 변경하지 않아도 쉽게 사용이 가능하다.

### Example
Weapon interface를 implements 한 클래스들이 Weapon 인스턴스에 할당되면서 어떤 무기로 변경이되더라도 attack method를 수행할 수 있다.  
즉, 상황에 맞게 무기가 변하여도 그 무기를 사용하는 코드에서는 수정할 사항이 없다.


### Diagram

![image](https://user-images.githubusercontent.com/37873745/99345480-bed97700-28d5-11eb-85cd-0e2cc284b31f.png)
