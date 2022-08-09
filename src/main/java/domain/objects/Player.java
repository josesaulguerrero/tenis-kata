package domain.objects;

import domain.value.Score;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
public class Player {
    private static Integer idCount = 1;
    // ---
    private final Integer id;
    private Score score;
    private final String name;

    public Player(String name) {
        this.id = idCount++;
        this.name = name;
        this.score = Score.of(0);
    }

    public void addPoint() {
        this.score = this.score.sum();
    }

    public boolean hasWon(int opponentScore) {
        return this.score.isGreaterThanOrEquals(4) && this.score.isGreaterThanOrEquals(opponentScore + 2);
    }

    public boolean isLeading(int opponentScore) {
        boolean bothPlayersScoreIsOverThree = Score.of(opponentScore).isGreaterThanOrEquals(3) && this.score.isGreaterThanOrEquals(3);
        boolean localPlayerIsLeading = this.score.isGreaterThanOrEquals(opponentScore + 1);
        return bothPlayersScoreIsOverThree && localPlayerIsLeading && !this.hasWon(opponentScore);
    }

    public static String parseScore(int localScore, int opponentScore) {
        return Score.of(localScore).parse(Score.of(opponentScore));
    }
}
