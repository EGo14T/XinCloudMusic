package com.ego14t.comments.entity;

public class CodeConsts {
	/**
	 * 默认成功码
	 */
	public static final int DEFAULT_SUCCESS_CODE = 0;
	/**
	 * 默认错误码
	 */
	public static final int DEFAULT_ERROR_CODE = 400;
	/**
	 * 默认license无效错误码
	 */
	public static final int DEFAULT_LICENSE_INVALID_ERROR_CODE = -3;
	/**
	 * 默认参数校验未通过错误码
	 */
	public static final int DEFAULT_NOTVALID_ERROR_CODE = -4;
	/**
	 * 默认参数转换错误码
	 */
	public static final int DEFAULT_HTTP_MESSAGE_CONVERSION_ERROR_CODE = -5;
	/**
	 * 默认参数不允许为空错误码
	 */
	public static final int DEFAULT_MISSING_SERVLET_REQUEST_PARAMETER_ERROR_CODE = -6;
	/**
	 * REQUEST METHOD不支持错误码
	 */
	public static final int DEFAULT_REQUEST_METHOD_NOT_SUPPORTED_ERROR_CODE = -7;
	/**
	 * 默认唯一性约束错误码
	 */
	public static final int DEFAULT_DUPLICATE_ERROR_CODE = -8;
	/**
	 * 默认基础参数设置无效错误码
	 */
	public static final int DEFAULT_BASE_SETTING_INVALID_ERROR_CODE = -9;
	/**
	 * 默认数据库操作功能无效错误码
	 */
	public static final int DEFAULT_SQL_EXECUTOR_INVALID_ERROR_CODE = -10;
	/**
	 * 默认企业微信、钉钉、金蝶云之家等接口地址访问不通错误码
	 */
	public static final int DEFAULT_CP_API_ERROR_CODE = -100;
	/**
	 * 默认企业微信、钉钉、金蝶云之家等接口地址异常错误码（可能是代码问题导致的异常）
	 */
	public static final int DEFAULT_CP_ERROR_CODE = -101;
}