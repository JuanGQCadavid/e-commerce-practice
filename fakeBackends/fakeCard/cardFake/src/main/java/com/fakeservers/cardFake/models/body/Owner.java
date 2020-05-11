package com.fakeservers.cardFake.models.body;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Owner {
    @NotEmpty
    private String lastName;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String address;
}