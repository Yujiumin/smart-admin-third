package jiumin.yu.third.ocean.response.base;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * @author Yujiumin
 * @date 2022/11/23
 */
@Data
public class OceanResponse<T> {

    private Long code;

    private String message;

    private T data;

    @JsonAlias("request_id")
    private String requestId;

}
