package jiumin.yu.third.ocean.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * @author Yujiumin
 * @date 2022/11/24
 */
@Data
public class Clue {

    @JsonAlias("clue_id")
    private String clueId;

    @JsonAlias("advertiser_id")
    private String advertiserId;

    @JsonAlias("advertiser_name")
    private String advertiserName;

    @JsonAlias("ad_id")
    private String adId;

    @JsonAlias("ad_name")
    private String adName;

    @JsonAlias("creative_id")
    private String creativeId;

    @JsonAlias("site_id")
    private String siteId;

    @JsonAlias("site_name")
    private String siteName;

    @JsonAlias("intention_estimation")
    private String intentionEstimation;

    @JsonAlias("external_url")
    private String externalUrl;

    @JsonAlias("clue_type")
    private Integer clueType;

    @JsonAlias("module_name")
    private String moduleName;

    @JsonAlias("module_id")
    private String moduleId;

    @JsonAlias("create_time")
    private String createTime;

    @JsonAlias("create_time_detail")
    private String createTimeDetail;

    private String date;

    @JsonAlias("clue_source")
    private Integer clueSource;

    private String name;

    private String telephone;

    private Integer gender;

    private Integer age;

    private String email;

    private String weixin;

    private String qq;

    @JsonAlias("province_name")
    private String provinceName;

    @JsonAlias("city_name")
    private String cityName;

    private String address;

    private String location;

    private String remark;

    @JsonAlias("remark_dict")
    private Object remarkDict;

    @JsonAlias("form_remark")
    private String formRemark;

    @JsonAlias("app_name")
    private String appName;

    @JsonAlias("convert_status")
    private String convertStatus;

    @JsonAlias("req_id")
    private String reqId;

    @JsonAlias("clue_state")
    private String clueState;

    @JsonAlias("clue_state_name")
    private String clueStateName;

    @JsonAlias("clue_owner_name")
    private String clueOwnerName;

    @JsonAlias("follow_state_name")
    private String followStateName;

    @JsonAlias("country_name")
    private String countryName;

    @JsonAlias("system_tags")
    private String[] systemTags;

    private String[] tags;

    @JsonAlias("allocation_status")
    private String allocationStatus;

    private Store store;

    @Data
    public static class Store {

        @JsonAlias("store_id")
        private Long storeId;

        @JsonAlias("store_name")
        private String storeName;

        @JsonAlias("store_pack_id")
        private Long storePackId;

        @JsonAlias("store_pack_name")
        private String storePackName;

        @JsonAlias("store_location")
        private String storeLocation;

        @JsonAlias("store_address")
        private String storeAddress;

        @JsonAlias("store_remark")
        private String storeRemark;

        @JsonAlias("store_pack_remark")
        private String storePackRemark;
    }

}
