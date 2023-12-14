package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class OutputVIew {
    DecimalFormat decimalFormat = new DecimalFormat("#,###.#");

    public void purchaseOutput(int purchaseAmount){
        System.out.println();
        System.out.println(String.format("%d개를 구매했습니다.",purchaseAmount));
    }

    public void purchaseLottoOutput(Lotto purchaseLotto){
        System.out.println(purchaseLotto.getNumbers());
    }

    public void resultMessageOutput(){
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void lottoResultOutput(Map<LottoRank, Integer> lottoResult){
        System.out.println(String.format(LottoRank.FIFTH.getWinnningMessage(),lottoResult.get(LottoRank.FIFTH)));
        System.out.println(String.format(LottoRank.FOURTH.getWinnningMessage(),lottoResult.get(LottoRank.FOURTH)));
        System.out.println(String.format(LottoRank.THIRD.getWinnningMessage(),lottoResult.get(LottoRank.THIRD)));
        System.out.println(String.format(LottoRank.SECOND.getWinnningMessage(),lottoResult.get(LottoRank.SECOND)));
        System.out.println(String.format(LottoRank.FIRST.getWinnningMessage(),lottoResult.get(LottoRank.FIRST)));

    }

    public void rateOfReturnOutput(Double rateOfReturn){
        System.out.println(String.format("총 수익률은 %s%%입니다.", decimalFormat.format(rateOfReturn)));
    }

}
