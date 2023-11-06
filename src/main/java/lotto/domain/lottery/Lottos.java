package lotto.domain.lottery;

import lotto.domain.prize.MatchingResult;
import lotto.domain.prize.Prize;

import java.util.List;
import java.util.function.Function;

public class Lottos {
    private final List<Lotto> lottoTickets;

    // Constructor
    private Lottos(final Buyer buyer) {
        final int ticketCount = buyer.getTicketCount();

        this.lottoTickets = LottoService.generateLottos(ticketCount);
    }

    // Static Factory Method
    public static Lottos from(final Buyer buyer) {
        return new Lottos(buyer);
    }

    // Utility Method
    public List<MatchingResult> generateMatchingResultList(final Prize prize) {
        return lottoTickets.stream()
                .map(generateMatchingResult(prize))
                .toList();
    }

    private static Function<Lotto, MatchingResult> generateMatchingResult(Prize prize) {
        return lotto -> MatchingResult.of(lotto, prize);
    }

    // Getter
    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
