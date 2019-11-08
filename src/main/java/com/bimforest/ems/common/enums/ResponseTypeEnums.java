package com.bimforest.ems.common.enums;

/**
　* @description: 返回结果状态
　* @author max.zhang
　* @date 2019/9/10 9:29
　* @Copyright (C) 量树科技
　*/
public enum ResponseTypeEnums {

	/**
	 * 成功
	 */
	SUCCESS,
	/**
	 * 失败
	 */
	FAILED,
	/**
	 * 处理中（异步处理，后续需要查询或回调的）
	 */
	PROCESSING,
	/**
	 * 异常（内部系统异常，后续需要查询的）
	 */
	EXCEPTION
}
