# Optional
![image](https://user-images.githubusercontent.com/37873745/107869159-4bdc9e00-6ece-11eb-8af7-013997f3549e.png)

## Optional Stream (Java9)
데이터가 있는 경우의 Optional만 Stream으로 반환
![Optional stream](https://user-images.githubusercontent.com/37873745/112173782-3aa74f80-8c39-11eb-856a-b82d1a190a4b.png)


# NPE (Null Pointer Exception)

## 정의

Null 때문에 발생하는 Runtime Exception ( **`java.lang.NullPointerException` )**

- 변수의 값이 Null임에도 그것을 인지하지 못하고 해당 자료/객체형의 메서드를 호출하는 등에서 문제가 발생
- Null 자체의 의미가 모호해 개발/유지보수/디버깅 시 문제를 일으킴

## NPE를 방지하기 위해선 어떤 방법을 사용했는가?

**사용 전, Null check**

```java
public int getAllPrice(Lotto lotto) {
	if (lotto != null) {
		return lotto.getCount() * lotto.getPrice();
	}
}
```

- 간단해보이지만, Null check 해야하는 변수가 하나가 아니라면?
    - 5개의 변수를 가지고 지지고 볶는 메서드라면 내부에서 null check를 적어도 5번은 해줘야 할 것
- 만약 nested하게 참조하고 있는 변수 데이터를 가져와야 한다면?
    - 좀 억지인 예제이지만 `Lotto` <- `LottoPrice` <- `ExchangeRate(환율)` 이런 관계가 있다고 하자.

    ```java
    public Date getExchangeRateDefinedTime(Lotto lotto) {
    	if(lotto != null) {
    		LottoPrice lottoPrice = lotto.getPrice();
    		
    		if(lottoPrice != null) {
    			ExchangeRate exchangeRate = lottoPrice.getExchangeRate();
    			
    			if(exchangeRate != null) {
    				return exchangeRate.getDefinedTime();
    			}
    		}
    	}
    }
    ```

    - `ExchangeRate` 의 속성인 `definedTime` 의 Getter method를 사용한다하면 Null check가 nested하게 만들어져야 할 것

코드가 방대해지고, 내용이 늘어남에 따라 로직이 복잡해지고 코드의 가독성이 떨어지는 문제점이 발생한다.

- 또 다시 유지보수/디버깅의 어려움이 등장

# Java 8 → Optional의 등장

앞선 문제점을 해결하기 위해 등장한 `Optional (java.util.Optional<T>`

- 존재하지 않는 값을 표현하는 `null` 이 아닌 **존재할지 안 할지 모르는 값을 표현**하는 타입
- 일종의 Wrapper class

## Optional을 사용한다면

- NPE 문제를 일으키는 `null` 을 직접 사용하지 않아도 된다.
- `null` 체크를 계속해야하는 문제점을 해결해준다.
- `null` 을 포함한다는 의미를 코드에 표현할 수 있다.

# Reference

### Optional이 왜 등장했고, 어떠한 기능이 있는가?

[자바8 Optional 1부: 빠져나올 수 없는 null 처리의 늪](https://www.daleseo.com/java8-optional-before/)

[[Java] Optional이란?](https://mangkyu.tistory.com/70)

### Optional의 기능 상세

[자바 옵셔널 (Java Optional)](https://jdm.kr/blog/234)

### Optional의 베스트 패턴과 안티 패턴

[Optional 바르게 쓰기](http://homoefficio.github.io/2019/10/03/Java-Optional-%EB%B0%94%EB%A5%B4%EA%B2%8C-%EC%93%B0%EA%B8%B0/)