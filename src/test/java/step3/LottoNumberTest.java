package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
    @Test
    void 로또번호_생성() {
        assertThat(LottoNumber.of(1)).isEqualTo(LottoNumber.of(1));
    }

    @ParameterizedTest(name = "invalid_로또번호_생성")
    @ValueSource(ints = {-1, 100, 0})
    void invalid_로또번호_범위() {
        assertThatThrownBy(() -> {
            LottoNumber lottoNumber = LottoNumber.of(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~45의 숫자만 입력해주세요.");
    }
}
