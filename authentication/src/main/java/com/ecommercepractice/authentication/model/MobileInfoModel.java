package com.ecommercepractice.authentication.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MobileInfo")
@ApiModel(value = "Authentication",
        description = "All info related user's device would be represented by Authentication model."
)
public class MobileInfoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty("Primary Key -> Auto generated.")
    private int idMobileInfo;

    @NotEmpty
    @ApiModelProperty("Mobile brand aka Motorola, Samsung and so on.")
    private String mobileBrand;

    @NotEmpty
    @ApiModelProperty("iOs, Android ...")
    private String OperatingSystem;

    @NotEmpty
    @ApiModelProperty("Operating System version.")
    private String SystemVersion;


}
