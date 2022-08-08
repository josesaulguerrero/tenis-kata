package domain.value;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Score {
    private Integer value;

    private Score() {
        this.value = 0;
    }

    public Score(Integer value) {
        this.value = value;
    }

    public static Score of(Integer value) {
        return new Score(value);
    }

    public static Score of() {
        return new Score();
    }
}
