package domain.objects;

import domain.value.Score;
import lombok.*;

@Getter
@Setter
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
    }
}
