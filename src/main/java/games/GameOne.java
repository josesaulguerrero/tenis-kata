package games;

import domain.objects.Player;
import interfaces.TennisGame;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public class GameOne implements TennisGame {

    private final Player playerOne;
    private final Player playerTwo;

    public GameOne(String playerOneName, String playerTwoName) {
        this.playerOne = new Player(playerOneName);
        this.playerTwo = new Player(playerTwoName);
    }

    public void wonPoint(String playerName) {
        Player player = this.playerOne.getName().equals(playerName)
                ? this.playerOne
                : this.playerTwo;
        player.addPoint();
    }

    private boolean playersScoreAreEqual() {
        return this.playerOne.getScore().equals(
                this.playerTwo.getScore()
        );
    }

    public String getScore() {
        Integer playerTwoScore = this.playerTwo.getScore().getValue();
        return this.playerOne.parseScore(playerTwoScore);
    }
}
