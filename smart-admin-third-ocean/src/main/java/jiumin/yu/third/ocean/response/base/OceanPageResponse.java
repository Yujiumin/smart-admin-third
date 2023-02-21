package jiumin.yu.third.ocean.response.base;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;

/**
 * 分页数据
 *
 * @author Yujiumin
 * @date 2022/11/24
 */
@Data
public class OceanPageResponse<T> {

    public OceanPageResponse() {
    }

    private Long code;

    private String message;

    private PageData<T> data;

    @JsonAlias("request_id")
    private String requestId;

    @Data
    public static class PageData<T> {

        @JsonAlias("page_info")
        private PageInfo pageInfo;

        private List<T> list;
    }

    @Data
    public static class PageInfo {

        private Long page;

        @JsonAlias("page_size")
        private Long pageSize;

        @JsonAlias("total_number")
        private Long totalNumber;

        @JsonAlias("total_page")
        private Long totalPage;
    }
}
