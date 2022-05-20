package step3.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinnerLottoTest {

    final WinnerLotto winnerLotto = new WinnerLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 10);

    @Test
    void valid_당첨로또생성() {
        assertThat(winnerLotto).isEqualTo(new WinnerLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 10));
    }

    @Test
    void invalid_당첨로또생성_숫자개수초과() {
        assertThatThrownBy(() -> {
            new WinnerLotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 10);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "당첨순위확인")
    @MethodSource("listAndRankingProvider")
    void 당첨순위확인(List<Integer> numbers, Ranking exoected) {
        Lotto lotto = LottoFactory.createManualLotto(numbers);
        Ranking actual = winnerLotto.matchRanking(lotto);
        assertThat(actual).isEqualTo(exoected);
    }

    static Stream<Arguments> listAndRankingProvider() {
        return Stream.of(
                arguments(Arrays.asList(1, 2, 3, 4, 5, 6), Ranking.FIRST),
                arguments(Arrays.asList(1, 2, 3, 4, 5, 10), Ranking.SECOND),
                arguments(Arrays.asList(1, 2, 3, 4, 5, 16), Ranking.THIRD),
                arguments(Arrays.asList(1, 2, 3, 4, 15, 16), Ranking.FOURTH),
                arguments(Arrays.asList(1, 2, 3, 14, 15, 16), Ranking.FIFTH)
        );
    }
}