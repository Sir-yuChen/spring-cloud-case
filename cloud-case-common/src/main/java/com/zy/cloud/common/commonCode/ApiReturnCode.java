package com.zy.cloud.common.commonCode;


import org.apache.commons.lang3.StringUtils;

/**
 * 前台返回值的枚举类，定义返回的code及message
 */
public enum ApiReturnCode {
    //操作成功状态码
    SUCCESSFUL("200", "成功"),//【前端使用】
    HTTP_ERROR("000", "系统异常"),
    PARAMS_ERROR("9999", "参数错误"),
    RESOURCE_IS_NOT("6666", "资源不存在"),
    // 服务器内部错误
    UNKNOWN_ERROR("8888", "未知错误");


    private String code;
    private String message;

    private ApiReturnCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ApiReturnCode getByCode(String code) {
        if (StringUtils.isNotBlank(code)) {
            for (ApiReturnCode e : values()) {
                if (e.getCode().equals(code)) {
                    return e;
                }
            }
        }
        return null;
    }

}