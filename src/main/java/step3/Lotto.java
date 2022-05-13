package step3;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final Set<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lotto = new HashSet<>(lottoNumbers);
        validate();
    }

    private void validate() {
        if (isInvalidNumberCount()) {
            throw new IllegalArgumentException("중복되지 않은 6개의 숫자를 입력해주세요.");
        }
    }

    private boolean isInvalidNumberCount() {
        return lotto.size() != LOTTO_SIZE;
    }

    public static int getLottoSize() {
        return LOTTO_SIZE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return lotto != null ? lotto.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lotto=" + lotto +
                '}';
    }
}
