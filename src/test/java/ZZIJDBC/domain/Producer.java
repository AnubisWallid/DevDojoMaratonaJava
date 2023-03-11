package ZZIJDBC.domain;

import lombok.*;

@Value
@Builder
@ToString
@Getter
@EqualsAndHashCode
public final class Producer {
    private final Integer id;
    private final String name;
}
