# Template Method Pattern

알고리즘의 구조를 메서드에 정의하고, 하위 클래스에서 알고리즘 구조의 변경없이 알고리즘을 재정의하는 패턴.  
알고리즘이 단계 별로 나누어지거나, 같은 역할을 하는 메서드이지만 여러 곳에서 다른 형태로 사용이 필요한 경우 유용한 패턴.

### Advantages
- 코드 중복을 크게 줄일 수 있다.
- 쉽게 자식 클래스(객체)를 추가하며 기능을 확장해 나갈 수 있다.

### Example
- 게임에 연결하는데 있어서 과정은 암호화 작업, 인증 작업, 권한 확인, 연결로 나누어진다고 함.
- 이 4개의 작업을 abstract method로 정의.
- Template method에 이 4개의 method를 수행하게 작성.
- 해당 클래스를 상속받아 override를 통해 기능 명시해서 사용.

### Diagram
![image](https://user-images.githubusercontent.com/37873745/99346779-c9e1d680-28d8-11eb-8365-7dd5345fb91a.png)

