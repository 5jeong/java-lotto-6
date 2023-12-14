package lotto.view;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.ConverterUtil;

public class InputView {

    public String purchaseAmountInput(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public List<Integer> winningNumberInput(){
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return ConverterUtil.convertStringToIntegerList(Console.readLine());
    }

    public String bonusNumberInput(){
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
