package lotto.controller;

import lotto.InputHandler.InputTemplate;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputVIew;

public class LottoController {
    private final InputView inputView;
    private final OutputVIew outputView;
    private final LottoMachine lottoMachine;

    public LottoController(LottoMachine lottoMachine) {
        this.inputView = new InputView();
        this.outputView = new OutputVIew();
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        LottoBuyer lottoBuyer = generateLottoBuyerStep();
        generateLottoStep(lottoBuyer);
        WinningLotto winningLotto = generateWinningLottoStep();
        lottoResultStep(winningLotto, lottoBuyer);
    }

    private WinningLotto generateWinningLottoStep() {
        return InputTemplate.execute(() -> {
            Lotto winningNumbers = new Lotto(inputView.winningNumberInput());
            String bonusNumber = inputView.bonusNumberInput();
            return new WinningLotto(winningNumbers, bonusNumber);
        });
    }

    private LottoBuyer generateLottoBuyerStep() {
        return InputTemplate.execute(() -> {
            String purchaseAmount = inputView.purchaseAmountInput();
            return new LottoBuyer(purchaseAmount);
        });
    }

    private void generateLottoStep(LottoBuyer lottoBuyer) {
        int purchaseCount = lottoBuyer.purchaseCount();
        outputView.purchaseOutput(purchaseCount);
        for (int i = 0; i < purchaseCount; i++) {
            Lotto purchaseLotto = new Lotto(lottoMachine.generate());
            outputView.purchaseLottoOutput(purchaseLotto);
            lottoBuyer.purchaseLotto(purchaseLotto);
        }
    }

    private void lottoResultStep(WinningLotto winningLotto, LottoBuyer lottoBuyer) {
        LottoResult lottoResult = new LottoResult(winningLotto, lottoBuyer);
        lottoResult.judgeLottoResult();
        outputView.resultMessageOutput();
        outputView.lottoResultOutput(lottoResult.getLottoResult());
        outputView.rateOfReturnOutput(lottoResult.getRateOfReturn());
    }
}