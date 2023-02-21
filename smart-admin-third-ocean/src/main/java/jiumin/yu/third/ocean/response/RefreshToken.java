package jiumin.yu.third.ocean.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * @author Yujiumin
 * @date 2022/11/23
 */
@Data
public class RefreshToken {

    @JsonAlias("access_token")
    private String accessToken;

    @JsonAlias("expires_in")
    private Long expiresIn;

    @JsonAlias("refresh_token")
    private String refreshToken;

    @JsonAlias("refresh_token_expires_in")
    private Long refreshTokenExpiresIn;

}
