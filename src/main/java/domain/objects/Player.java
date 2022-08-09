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

    public Boolean hasWon(Integer opponentScore) {
        return this.score.getValue() >= opponentScore + 2;
    }

    public Boolean isDeuce(Integer opponentScore) {
        return this.score.getValue() >= 3 && this.score.getValue().equals(opponentScore);
    }
}
