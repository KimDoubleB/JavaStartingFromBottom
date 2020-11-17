# Adapter Pattern

한 클래스의 인터페이스를 사용하고자 하는 다른 인터페이스로 변환할 때 주로 사용하며, 이를 이용하면 인터페이스 호환성이 맞지 않아 사용할 수 없는 클래스를 연관관계로 연결해서 사용할 수 있게 해주는 패턴

### Advantages
- 관계가 없는 인터페이스 간 같이 사용 가능하다.
- 프로그램 검사하기가 용이하다.
- 클래스 재활용성이 증가한다.

### Example
Dog class - Cat class 간의 Adapter 작성
Cat interface에 Dog instance를 넣어도 Cat에 정의된 mewMew, eat method를 수행할 수 있다.

### Diagram

![image](https://user-images.githubusercontent.com/37873745/99345901-bcc3e800-28d6-11eb-837d-b536aa660c24.png)