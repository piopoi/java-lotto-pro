package step3.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.concurrent.atomic.AtomicLong;

public class LottoResult {

    private static final int MIN_RANKING_COUNT = 0;

    private final EnumMap<Ranking, Integer> rankingMap;

    public LottoResult() {
        this.rankingMap = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values())
                .forEach(ranking -> rankingMap.put(ranking, MIN_RANKING_COUNT));
    }

    public void updateHitRanking(Ranking ranking) {
        rankingMap.put(ranking, rankingMap.get(ranking) + 1);
    }

    public Yield calculateYield(int inputMoney) {
        return new Yield((double) winningAmount() / inputMoney);
    }

    private long winningAmount() {
        AtomicLong winningAmount = new AtomicLong();
        rankingMap.forEach((ranking, hitCount) -> winningAmount.addAndGet(hitCount * ranking.getWinningMoney()));
        return winningAmount.get();
    }

    public int rankingCount(Ranking ranking) {
        return rankingMap.get(ranking);
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "rankingMap=" + rankingMap +
                '}';
    }
}
