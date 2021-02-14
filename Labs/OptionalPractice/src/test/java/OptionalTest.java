import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OptionalTest {

    /*
    Optional.empty()
    Optional.of(value)
    Optional.ofNullable(value)
     */
    @DisplayName("Optional 객체 생성")
    @Test
    public void optionalGenerationTest(){
        // 참조변수 선언
        // 제네릭으로 타입 명시
        Optional<Integer> integerOptionalObject;
        Optional<Double> doubleOptionalObject;
        Optional<String> stringOptionalObject;
        Optional<Lotto> lottoOptionalObject;
        Optional<Lotto> lottoOptionalObject2;

        // Optional 객체 생성
        // empty ()
        integerOptionalObject = Optional.empty();

        // of(value)
        // null이 아니라고 확신하는 객체를 Optional에 넣는 것
        // value로 null이 들어오는 경우 NPE를 던지기 때문에 주의해 사용해야한다.

        doubleOptionalObject = Optional.of(2.3);

        assertThatThrownBy(() -> {
            String someData = null;
            Optional.of(someData);
        }).isInstanceOf(NullPointerException.class);


        // ofNullable(value)
        // null인지 아닌지 확신할 수 없는 객체를 Optional에 넣는 것
        // value가 null이라면 Optional.empty()를 갖게 되고, NPE가 발생하지 않는다.

        String nullString = null;
        stringOptionalObject = Optional.ofNullable(nullString);
        assertThat(stringOptionalObject)
                .isEqualTo(Optional.empty());
        assertThat(stringOptionalObject.toString())
                .isEqualTo(Optional.empty().toString());


        Lotto newLotto = new Lotto(1000);
        lottoOptionalObject = Optional.ofNullable(newLotto);
        assertThat(lottoOptionalObject)
                .isNotEqualTo(Optional.empty());

    }

    /*
    OptionalInt
    OptionalLong
    OptionalDouble
     */
    @DisplayName("Optional Number type 객체 생성")
    @Test
    public void optionalNumberTypeGenerationTest(){
        // Optional에 담길 값이 int, long, double인 경우, Optional<>로 담는 것은 비효율적임.
        // Auto boxing, unboxing이 일어나기 때문 !

        // 고로, OptionalInt, OptionalLong, OptionalDouble 을 사용하자.
        OptionalInt optionalIntegerData = OptionalInt.empty();
        OptionalLong optionalLongData = OptionalLong.of(1L);
        OptionalDouble optionalDoubleData = OptionalDouble.of(2.3);

        assertThat(optionalIntegerData.isPresent()).isFalse();
        assertThat(optionalDoubleData.isPresent()).isTrue();

    }


    /*
    get()
    orElse(default value)
    orElseGet(supplier)
    orElseThrow(Exception)
     */
    @DisplayName("래핑한 객체 가져오기")
    @Test
    public void optionalGetObjectTest(){
        Optional<Lotto> lottoOptionalObject;
        Optional<Lotto> lottoOptionalObject2;

        Lotto newLotto = new Lotto(1000);
        lottoOptionalObject = Optional.ofNullable(newLotto);
        lottoOptionalObject2 = Optional.empty();

        // get()
        // 래핑한 객체를 가져오되, empty인 경우 NoSuchElementException을 던진다.
        assertThat(lottoOptionalObject.get().getPrice())
                .isEqualTo(1000);

        assertThatThrownBy(() -> Optional.empty().get())
                .isInstanceOf(NoSuchElementException.class);

        // orElse(default value)
        // 래핑한 객체를 가져오되, empty인 경우 default 값을 반환한다.
        // Optional 객체가 비어있든, 비어있지 않든 반드시 실행하게 된다. -> 기본값을 만드는 과정을 무조건 수행함.
        Lotto defaultLotto = new Lotto(2000);

        // 객체가 있는 경우
        assertThat(lottoOptionalObject.orElse(defaultLotto).getPrice())
                .isEqualTo(1000);

        // 객체가 비어있을 경우 -> default 값 들어감
        assertThat(lottoOptionalObject2.orElse(defaultLotto).getPrice())
                .isEqualTo(2000);

        // orElseGet ( supplier )
        // 래핑한 객체를 가져오되, empty인 경우 기본값으로 제공할 공급자 함수를 지정
        // Optional 객체가 비어있을 때만 실행한다. -> 기본값을 만드는 과정이 비어있지 않은 경우엔 수행되지 않음.
        // orElse 보다 효율적.
        assertThat(lottoOptionalObject.orElseGet(() -> new Lotto(5000)).getPrice())
                .isEqualTo(1000);
        assertThat(lottoOptionalObject2.orElseGet(() -> new Lotto(5000)).getPrice())
                .isEqualTo(5000);

        // orElseThrow ( Exception )
        // 래핑한 객체를 가져오되, empty인 경우 Exception 던짐
        assertThatThrownBy(() -> {
            lottoOptionalObject2.orElseThrow(IllegalArgumentException::new);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    /*
    isPresent()
    ifPresent()
    ifPresentOrElse()
     */
    @DisplayName("isPresent, ifPresent")
    @Test
    public void optionalPresentTest(){
        // isPresent()
        // 객체 존재여부 boolean 값 리턴
        Optional<String> optionalString = Optional.empty();
        assertThat(optionalString.isPresent()).isFalse();
        optionalString = Optional.ofNullable("Hello");
        assertThat(optionalString.isPresent()).isTrue();

        // ifPresent()
        // 객체가 존재하면 입력값(파라미터)으로 주어짐 -> 작업수행하면 된다.
        // 객체가 없으면 내부 아무 작업도 수행하지 않는다.
        optionalString.ifPresent(System.out::println);
        Optional.ofNullable(null).ifPresent(System.out::println);

        // ifPresentOrElse()
        // Java 9 이상
        // 객체가 존재할 때의 작업수행과 객체가 존재하지 않을 때의 작업수행을 모두 다 정의
        optionalString.ifPresentOrElse(
                (value) -> System.out.println(value),
                () -> System.out.println("Not Here")
        );

        Optional.ofNullable(null).ifPresentOrElse(
                (value) -> System.out.println("Not Here"),
                () -> System.out.println("Default message ! This is null !")
        );
    }
}
