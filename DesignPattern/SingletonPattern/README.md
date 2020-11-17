# Singleton Pattern

전역 변수를 사용하지 않고 객체를 하나만 생성 하도록 하며, 생성된 객체를 어디에서든지 참조할 수 있도록 하는 패턴
하나의 인스턴스만을 생성하는 책임이 있으며 getInstance 메서드를 통해 모든 클라이언트에게 동일한 인스턴스를 반환하는 작업을 수행

### Advantages
- 한 번의 new로 인스턴스를 사용하기 때문에 메모리 낭비를 방지할 수 있다.
- 전역 인스턴스이기 때문에 다른 클래스의 인스턴스들이 데이터를 공유하기 쉽다.
- DBCP (DataBase Connection Pool)처럼 공통된 객체를 여러개 생성해 사용해야하는 상황에서 많이 사용된다.

### Disadvantages
- 하나의 싱글톤 인스턴스가 너무 많은 일을 하거나, 많은 데이터를 공유시킬 경우, 사용하는 인스턴스들간의 결합도가 높아져 [Open-Closed Principle(OCP)](https://ko.wikipedia.org/wiki/%EA%B0%9C%EB%B0%A9-%ED%8F%90%EC%87%84_%EC%9B%90%EC%B9%99)를 위반하게 된다. 즉, 유지보수가 어려워진다.
- 멀티 스레드 환경에서 동기화처리를 하지 않으면 인스턴스가 2개 이상 생성되는 문제가 발생할 수 있다. Thread-safe 한 싱글톤 클래스, 인스턴스 생성이 필요하다. (추후 작성예정)

### Example
SystemSpeakerSingleton class는 시스템 소리를 관리하는 클래스. -> 모든 다른 작업에서도 같이 작동해야 하므로 싱글톤 패턴을 사용한다.  
메인에서 보듯, 여러 인스턴스를 생성하는 거서럼 보여도 처음 만들게 된 인스턴스만을 계속 사용하는 것을 볼 수 있다.  
결국, 인스턴스를 계속 가져와 사용하더라도 하나의 인스턴스만을 통해 데이터 조작을 하는 것.  
- 디버깅을 통한 주소값 확인, hashCode()를 통한 데이터 값 일치 여부

### Diagram
![image](https://user-images.githubusercontent.com/37873745/99348023-e5021580-28db-11eb-8150-e15f4c918108.png)

### References
https://gmlwjd9405.github.io/2018/07/06/singleton-pattern.html
https://jeong-pro.tistory.com/86
