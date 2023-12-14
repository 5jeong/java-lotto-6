package lotto.domain;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final WinningLotto winningLotto;
    private final LottoBuyer lottoBuyer;

    private final Map<LottoRank, Integer> lottoResult = new HashMap<>();

    public LottoResult(WinningLotto winningLotto, LottoBuyer lottoBuyer) {
        this.winningLotto = winningLotto;
        this.lottoBuyer = lottoBuyer;
        initLottoResult();
    }

    private void initLottoResult() {
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoResult.put(lottoRank, 0);
        }
    }

    public void judgeLottoResult() {
        for (Lotto lotto : lottoBuyer.getPurchaseLottos()) {
            int matchCount = winningLotto.judgeMatchCount(lotto);
            boolean bonusMatch = winningLotto.judgeBonusMatch(lotto);
            applyLottoResult(matchCount, bonusMatch);
        }
    }

    private void applyLottoResult(int matchcount, boolean bonusMatch) {
        for (LottoRank lottoRank : LottoRank.values()) {
            if (bonusMatch && matchcount == 5) {
                lottoResult.put(LottoRank.SECOND, lottoResult.get(LottoRank.SECOND) + 1);
                return;
            }
            if (matchcount == lottoRank.getMatchCount()) {
                lottoResult.put(lottoRank, lottoResult.get(lottoRank) + 1);
            }
        }
    }

    private int totalPrize() {
        return lottoResult.entrySet().stream()
                .mapToInt(entry -> (int) (entry.getKey().getPrize() * entry.getValue()))
                .sum();
    }

    public Double getRateOfReturn() {
        return roundToTwoDecimalPlaces(lottoBuyer.rateOfReturn(totalPrize()));
    }

    private double roundToTwoDecimalPlaces(double number) {
        return Math.round(number * 100.0) / 100.0;
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }
}
