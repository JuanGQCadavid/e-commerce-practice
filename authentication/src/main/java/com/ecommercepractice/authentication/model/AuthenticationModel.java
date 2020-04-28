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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "Authentication")
@ApiModel(value = "Authentication",
    description = "Holds the information related to user Authentication"
)
public class AuthenticationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idAuthentication;

    @ApiModelProperty(value = "Unique user token, used by the client to identified itself after log in.")
    private String idToken;

    @NotEmpty
    @ApiModelProperty(value = "User's email")
    private String userEmail;

    @NotNull
    @Size(min= 6, max = 24)
    @ApiModelProperty(value = "User's password")
    private String userPassword;
}
