package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lottos;
import lotto.dto.LottoNumberResponses;
import lotto.view.OutputView;

public class PurchaseController {
    private PurchaseController() {
    }

    public static Lottos purchase(final Buyer buyer) {
        Lottos lottos = Lottos.create(buyer);

        LottoNumberResponses lottoResponses =
                LottoNumberResponses.buildLottoResponses(buyer, lottos);

        OutputView.printPurchaseCount(lottoResponses);
        OutputView.printPurchaseLottoNumbers(lottoResponses);

        return lottos;
    }
}
