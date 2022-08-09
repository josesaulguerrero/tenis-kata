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

    private boolean someoneHasWon() {
        int playerOneScore = this.playerOne.getScore().getValue();
        int playerTwoScore = this.playerTwo.getScore().getValue();
        return this.playerOne.hasWon(playerTwoScore) || this.playerTwo.hasWon(playerOneScore);
    }
    private Player findWinner() {
        return this.playerOne.hasWon(this.playerTwo.getScore().getValue())
                ? this.playerOne
                : this.playerTwo;
    }

    private boolean someoneIsLeading() {
        int playerOneScore = this.playerOne.getScore().getValue();
        int playerTwoScore = this.playerTwo.getScore().getValue();
        return this.playerOne.isLeading(playerTwoScore) || this.playerTwo.isLeading(playerOneScore);
    }

    private Player findLeader() {
        return this.playerOne.isLeading(this.playerTwo.getScore().getValue())
                ? this.playerOne
                : this.playerTwo;
    }

    public String getScore() {
        String gameScore = Player.parseScore(
                this.playerOne.getScore().getValue(),
                this.playerTwo.getScore().getValue()
        );
        if (someoneHasWon()) {
            Player winner = this.findWinner();
            gameScore = "Win for " + winner.getName();
        }
        if (someoneIsLeading()) {
            Player leader = this.findLeader();
            gameScore = "Advantage " + leader.getName();
        }
        return gameScore;
    }
}
