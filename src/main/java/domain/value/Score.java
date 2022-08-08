package domain.value;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Score {
    private static final Map<Integer, String> possibleScores = new HashMap<>() {{
        put(0, "Love");
        put(1, "Fifteen");
        put(2, "Thirty");
        put(3, "Forty");
    }};
    // ---
    private Integer value;

    public static Score of(Integer value) {
        return new Score(value);
    }

    public static Score of() {
        return new Score();
    }

    public String parse() {
        return possibleScores.get(this.value);
    }
}
