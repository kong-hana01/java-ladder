package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

    private static final String INVALID_PRIZE_COUNT_ERROR_MESSAGE = "사다리 게임의 실행 결과는 사람 수와 동일하게 입력해야합니다.";

    private final List<Prize> prizes;

    public Prizes(List<String> prizes, int personCount) {
        validate(prizes, personCount);
        this.prizes = generatePrizes(prizes);
    }

    private void validate(List<String> prizes, int personCount) {
        validatePrizesCount(prizes, personCount);
    }

    private void validatePrizesCount(List<String> prizes, int personCount) {
        if (!isSameCount(prizes, personCount)) {
            throw new IllegalArgumentException(INVALID_PRIZE_COUNT_ERROR_MESSAGE);
        }
    }

    private boolean isSameCount(List<String> prizes, int personCount) {
        return prizes.size() == personCount;
    }

    public Prize getOnePrizeByIndex(int index) {
        return prizes.get(index);
    }

    private List<Prize> generatePrizes(List<String> prizes) {
        return prizes.stream()
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
