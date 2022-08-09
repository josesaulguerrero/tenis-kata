package domain.value;

import lombok.*;

import java.util.Map;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Score {
    private static final Map<Integer, String> possibleScores = Map.of(
            0, "Love",
            1, "Fifteen",
            2, "Thirty",
            3, "Forty"
    );
    // ---
    private Integer value;

    public Score sum() {
        return new Score(this.value + 1);
    }

    public static Score of(Integer value) {
        return new Score(value);
    }

    public static Score of() {
        return new Score();
    }

    public boolean isGreaterThanOrEquals(Integer value) {
        return this.value >= value;
    }

    public static boolean isDeuce(Score localScore, Score opponentScore) {
        return localScore.getValue() >= 3 && localScore.equals(opponentScore);
    }

    public String parse(Score opponentScore) {
        String localScoreParsed = possibleScores.get(this.value);
        String opponentScoreParsed = possibleScores.get(opponentScore.getValue());

        String parsedScore = this.equals(opponentScore)
                ? localScoreParsed + "-All"
                : localScoreParsed + "-" + opponentScoreParsed;
        if (Score.isDeuce(this, opponentScore)) {
            parsedScore = "Deuce";
        }
        return parsedScore;
    }
}
