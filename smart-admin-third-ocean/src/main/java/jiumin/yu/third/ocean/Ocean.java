package jiumin.yu.third.ocean;

import jiumin.yu.common.http.HttpClient;
import jiumin.yu.common.http.HttpResponse;
import jiumin.yu.common.json.SmartAdminJson;
import jiumin.yu.third.ocean.response.AccessToken;
import jiumin.yu.third.ocean.response.Clue;
import jiumin.yu.third.ocean.response.RefreshToken;
import jiumin.yu.third.ocean.response.base.OceanPageResponse;
import jiumin.yu.third.ocean.response.base.OceanResponse;
import jiumin.yu.third.ocean.typereference.AccessTokenReference;
import jiumin.yu.third.ocean.typereference.ClueTypeReference;
import jiumin.yu.third.ocean.typereference.RefreshTokenReference;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yujiumin
 * @date 2022/11/23
 */
@Slf4j
public class Ocean {

    /**
     * <a href="https://open.oceanengine.com/labels/7/docs/1696710505596940">获取AccessToken</a>
     * <p>
     * Access-Token是调用授权关系接口的调用凭证，用于服务端对API请求鉴权。所有接口均通过请求参数中传递的 Access_Token来进行身份认证和鉴权。
     *
     * @param appId
     * @param secret
     * @param grantType
     * @param authCode
     * @param debug
     * @return
     */
    public static OceanResponse<AccessToken> auth2AccessToken(String appId, String secret, String grantType, String authCode, boolean debug) {
        Map<String, String> paramMap = new LinkedHashMap<>();
        paramMap.put("app_id", appId);
        paramMap.put("secret", secret);
        paramMap.put("grant_type", grantType);
        paramMap.put("auth_code", authCode);

        Map<String, Serializable> headerMap = new LinkedHashMap<>();
        headerMap.put("Content-Type", "application/json");
        if (debug) {
            headerMap.put("X-Debug-Mode", 1);
        }

        String url = "https://ad.oceanengine.com/open_api/oauth2/access_token/";
        final HttpResponse httpResponse = HttpClient.post(url, headerMap, SmartAdminJson.toJsonString(paramMap, false));
        if (!httpResponse.isSuccessful()) {
            throw new RuntimeException(httpResponse.getMessage());
        }

        final String body = httpResponse.getBody();
        if (log.isDebugEnabled()) {
            log.debug("[OCEAN] 获取AccessToken: {}", body);
        }

        return SmartAdminJson.toBean(body, new AccessTokenReference(), false);
    }

    /**
     * <a href="https://open.oceanengine.com/labels/7/docs/1696710506097679">刷新Refresh Token</a>
     * <p>
     * 由于Access_Token有效期（默认1天）较短,当Access_Token超时后，可以使用refresh_token进行刷新，每次刷新都会产生新的access_token和Refresh_Token，同时重置二者的有效期。
     * <p>
     * Refresh_Token有效期是30天，但是刷新后会产生新的Refresh_token，老的Refresh_token会过期
     *
     * @param appId
     * @param secret
     * @param grantType
     * @param refreshToken
     * @return
     */
    public static OceanResponse<RefreshToken> refreshToken(String appId, String secret, String grantType, String refreshToken, boolean debug) {
        Map<String, String> paramMap = new LinkedHashMap<>();
        paramMap.put("app_id", appId);
        paramMap.put("secret", secret);
        paramMap.put("grant_type", grantType);
        paramMap.put("refresh_token", refreshToken);

        Map<String, Serializable> headerMap = new LinkedHashMap<>();
        headerMap.put("Content-Type", "application/json");
        if (debug) {
            headerMap.put("X-Debug-Mode", 1);
        }

        String url = "https://ad.oceanengine.com/open_api/oauth2/refresh_token/";
        final HttpResponse httpResponse = HttpClient.post(url, headerMap, SmartAdminJson.toJsonString(paramMap, false));
        if (!httpResponse.isSuccessful()) {
            throw new RuntimeException(httpResponse.getMessage());
        }

        final String body = httpResponse.getBody();
        if (log.isDebugEnabled()) {
            log.debug("[OCEAN] 刷新AccessToken: {}", body);
        }

        return SmartAdminJson.toBean(body, new RefreshTokenReference(), false);
    }

    /**
     * <a href="https://open.oceanengine.com/labels/7/docs/1696710631271436">获取线索列表</a>
     * <p>
     * 该接口用于获取广告主的飞鱼线索列表。
     *
     * @param accessToken
     * @param advertiserIds
     * @param startTime
     * @param endTime
     * @param page
     * @param pageSize
     * @param debug
     * @return
     */
    public static OceanPageResponse<Clue> getClueList(String accessToken, List<String> advertiserIds, String startTime, String endTime, Integer page, Integer pageSize, boolean debug) {
        Map<String, Serializable> paramMap = new LinkedHashMap<>();
        paramMap.put("advertiser_ids", Arrays.toString(advertiserIds.toArray()));
        paramMap.put("start_time", startTime);
        paramMap.put("end_time", endTime);
        paramMap.put("page", page);
        paramMap.put("page_size", pageSize);

        Map<String, Serializable> headerMap = new LinkedHashMap<>();
        headerMap.put("Access-Token", accessToken);
        if (debug) {
            headerMap.put("X-Debug-Mode", 1);
        }

        String url = "https://ad.oceanengine.com/open_api/2/tools/clue/get/";
        final HttpResponse httpResponse = HttpClient.get(url, headerMap, paramMap);
        if (!httpResponse.isSuccessful()) {
            throw new RuntimeException(httpResponse.getMessage());
        }

        final String body = httpResponse.getBody();
        if (log.isDebugEnabled()) {
            log.debug("[OCEAN] 获取线索列表: {}", body);
        }

        return SmartAdminJson.toBean(body, new ClueTypeReference(), false);
    }
}
