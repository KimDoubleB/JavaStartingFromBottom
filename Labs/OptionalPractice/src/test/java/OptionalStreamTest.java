import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalStreamTest {

    List<String> expected = Arrays.asList("foo", "bar");
    List<Optional<String>> listOfOptionals;

    @BeforeEach
    void setUp() {
        listOfOptionals = Arrays.asList(
                Optional.empty(),
                Optional.of("foo"),
                Optional.empty(),
                Optional.of("bar")
        );
    }

    @DisplayName("Using filter()")
    @Test
    void useFilter() {
        var result = listOfOptionals.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("Using flatMap()")
    @Test
    void useFlatMap() {
        var result = listOfOptionals.stream()
                .flatMap(l -> l.map(Stream::of).orElseGet(Stream::empty))
                .collect(Collectors.toList());

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("Using Java9 Optional::stream")
    @Test
    void useOptionalStream() {
        // 데이터가 존재하는 경우만을 뽑아서 Stream 형태로 만들어 반환
        var result = listOfOptionals.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
        assertThat(result).isEqualTo(expected);
    }
}
