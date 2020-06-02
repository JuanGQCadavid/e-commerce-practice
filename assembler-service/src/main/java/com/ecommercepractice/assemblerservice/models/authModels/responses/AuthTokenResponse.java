package com.ecommercepractice.assemblerservice.models.authModels.responses;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthTokenResponse {
    @ApiModelProperty(value = "Unique user token, used by the client to identified itself after log in.")
    private String tokenId;

    @ApiModelProperty(value = "Indicated the time when the Token was generate")
    private String generatedDate;

    @ApiModelProperty("Indicates when the token becomes rottens")
    private String expiredDate;
}
