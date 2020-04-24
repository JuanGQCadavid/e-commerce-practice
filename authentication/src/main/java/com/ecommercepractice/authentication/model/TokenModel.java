package com.ecommercepractice.authentication.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="Token")
@ApiModel(value = "Token",
        description = "This model represents the table associated to Tokens. This one are use for user Auth across the platform")
public class TokenModel {

    @Id
    @ApiModelProperty(value = "Unique user token, used by the client to identified itself after log in.")
    private String tokenId;

    @ApiModelProperty(value = "Indicated the time when the Token was generate")
    private LocalDate generatedDate;

    @ApiModelProperty("Indicates when the token becomes rottens")
    private LocalDate expiredDate;

    public TokenModel(LocalDate generatedDate, LocalDate expiredDate ){
        this.tokenId = UUID.randomUUID().toString();
        this.generatedDate = generatedDate;
        this.expiredDate = expiredDate;
    }
}
