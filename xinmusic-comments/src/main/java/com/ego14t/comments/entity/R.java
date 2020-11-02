package com.ego14t.comments.entity;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public static final String ERR_CODE_KEY = ParamterConsts.ERR_CODE_KEY;

	public static final String ERR_MSG_KEY = ParamterConsts.ERR_MSG_KEY;

	public static final String ERR_URL_KEY = ParamterConsts.ERR_URL_KEY;

	public static final int DEFAULT_ERR_CODE_VALUE = CodeConsts.DEFAULT_SUCCESS_CODE;


	public R() {
		put(ERR_CODE_KEY, DEFAULT_ERR_CODE_VALUE);
	}
	public static R error(String errmsg) {
		return error(CodeConsts.DEFAULT_ERROR_CODE, errmsg);
	}

	public static R error(int errcode, String errmsg) {
		R r = new R();
		r.put(ERR_CODE_KEY, errcode);
		r.put(ERR_MSG_KEY, errmsg);
		return r;
	}

	public static R ok(String errmsg) {
		R r = new R();
		r.put(ERR_MSG_KEY, errmsg);
		return r;
	}

	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}

	public static R ok() {
		return new R();
	}

	public int getErrorCode() {
		return (int) super.get(ERR_CODE_KEY);
	}

	public String getErrorMsg() {
		return (String) super.get(ERR_MSG_KEY);
	}

	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}

	public void setUrl(String url) {
		put(ERR_URL_KEY, url);
	}
}