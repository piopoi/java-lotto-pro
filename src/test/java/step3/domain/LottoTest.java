package step3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoTest {
    private List<Integer> numbers;

    @BeforeEach
    void beforeEach() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    void valid_로또_생성() {
        Assertions.assertThat(new Lotto(numbers)).isEqualTo(new Lotto(numbers));
    }

    @Test
    void invalid_로또_생성_숫자개수() {
        assertThatThrownBy(() -> {
            Lotto newLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되지 않은 6개의 숫자를 입력해주세요.");
    }
}