package com.ecommercepractice.authentication.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MobileInfo")
@ApiModel(value = "Authentication", description = "All info related user's device would be represented by Authentication model.")
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
    private String operatingSystem;

    @NotEmpty
    @ApiModelProperty("Operating System version.")
    private String systemVersion;
}
