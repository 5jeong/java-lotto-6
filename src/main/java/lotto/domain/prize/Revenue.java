package lotto.domain.prize;

import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.LottoService;

import java.math.BigDecimal;

public class Revenue {
    private final long income;
    private final BigDecimal yield;

    private Revenue(
            Buyer buyer,
            FinalResults finalResults
    ) {
        final int payment = buyer.getPayment();

        this.income = finalResults.calculateFinalRevenueAmount();
        this.yield = LottoService.calculateFinalYield(payment, income);
    }

    public static Revenue of(
            Buyer buyer,
            FinalResults finalResults
    ) {
        return new Revenue(buyer, finalResults);
    }

    public BigDecimal getYield() {
        return yield;
    }
}
