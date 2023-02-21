package jiumin.yu.third.ocean.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;

/**
 * @author Yujiumin
 * @date 2022/11/23
 */
@Data
public class AccessToken {

    @JsonAlias("access_token")
    private String accessToken;

    @JsonAlias("expires_in")
    private Integer expiresIn;

    @JsonAlias("refresh_token")
    private String refreshToken;

    @JsonAlias("refresh_token_expires_in")
    private Integer refreshTokenExpiresIn;

    @JsonAlias("advertiser_ids")
    private List<String> advertiserIds;

}
