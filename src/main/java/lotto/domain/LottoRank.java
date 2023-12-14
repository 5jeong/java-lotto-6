package lotto.domain;

public enum LottoRank {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - %d개"),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - %d개");

    private int matchCount;

    private long prize;
    private String winnningMessage;

    LottoRank(int matchCount, long prize, String winnningMessage) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.winnningMessage = winnningMessage;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    public String getWinnningMessage() {
        return winnningMessage;
    }
}
