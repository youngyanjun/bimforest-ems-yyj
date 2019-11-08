package com.bimforest.ems.common.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 　* @description: 读取配置文件参数
 * 　* @author max.zhang
 * 　* @date 2019/9/10 13:21
 * 　* @Copyright (C) 量树科技
 */
@Component
public class ConfigConstant {

    /**
     * 　* @description: 物联网系统秘钥
     * 　* @author max.zhang
     * 　* @date 2019/9/10 13:33
     * 　* @Copyright (C) 量树科技
     */
    private static String iotKey;

    /**
     * 　* @description: 生产系统秘钥
     * 　* @author max.zhang
     * 　* @date 2019/9/10 13:33
     * 　* @Copyright (C) 量树科技
     */
    private static String productKey;

    /**
     * 　* @description: 采购系统秘钥
     * 　* @author max.zhang
     * 　* @date 2019/9/10 13:33
     * 　* @Copyright (C) 量树科技
     */
    private static String purchaseKey;

    /**
     * 　* @description: 仓库系统秘钥
     * 　* @author max.zhang
     * 　* @date 2019/9/10 13:33
     * 　* @Copyright (C) 量树科技
     */
    private static String warehouseKey;

    /**
     * 　* @description: 密码盐值
     * 　* @author max.zhang
     * 　* @date 2019/9/10 13:33
     * 　* @Copyright (C) 量树科技
     */
    private static String passwordSlat;

    /**
     * 　* @description: jwt安全
     * 　* @author max.zhang
     * 　* @date 2019/9/10 13:33
     * 　* @Copyright (C) 量树科技
     */
    private static String tokenBase64Security;

    /**
     * 　* @description: session有效期
     * 　* @author max.zhang
     * 　* @date 2019/9/10 13:33
     * 　* @Copyright (C) 量树科技
     */
    private static int sessionExpireTime;

    /**
     * 　* @description: 微信扫码仓库URL
     * 　* @author max.zhang
     * 　* @date 2019/9/10 13:33
     * 　* @Copyright (C) 量树科技
     */
    private static String scancodeWareHouseUrl;

    /**
     * 　* @description: 微信扫码物联网构件URL
     * 　* @author max.zhang
     * 　* @date 2019/9/10 13:33
     * 　* @Copyright (C) 量树科技
     */
    private static String scancodeIOTComponentUrl;

    /**
     * 　* @description: 微信扫码物联网流转URL
     * 　* @author max.zhang
     * 　* @date 2019/9/10 13:33
     * 　* @Copyright (C) 量树科技
     */
    private static String scancodeIOTDeliverUrl;

    /**
     * 　* @description: 系统域名
     * 　* @author max.zhang
     * 　* @date 2019/9/10 13:33
     * 　* @Copyright (C) 量树科技
     */
    private static String webDomain;

    @Value("${custom.system.iot.key}")
    public void setIotKey(String iotKey) {
        iotKey = iotKey;
    }
    @Autowired(required = false)
    @Value("${jwt.pwsalt}")
    public  void setPasswordSlat(String passwordSlat) {
        passwordSlat = passwordSlat;
    }

    @Value("${jwt.expire}")
    public void setSessionExpireTime(int sessionExpireTimes) {
        sessionExpireTime = sessionExpireTimes;
    }

    @Value("${jwt.tokenBase64Security}")
    public void setTokenBase64Security(String tokenBase64Securitys) {
        tokenBase64Security = tokenBase64Securitys;
    }

    @Value("${custom.system.product.key}")
    public void setProductKey(String productKey) {
        productKey = productKey;
    }

    @Value("${custom.system.purchase.key}")
    public void setPurchaseKey(String purchaseKey) {
        purchaseKey = purchaseKey;
    }

    @Value("${custom.system.warehouse.key}")
    public void setWarehouseKey(String warehouseKey) {
        warehouseKey = warehouseKey;
    }

    public static String getScancodeWareHouseUrl() {
        return scancodeWareHouseUrl;
    }

    @Value("${scancode.warehouse.url}")
    public void setScancodeWareHouseUrl(String scancodeWareHouseUrl) {
        ConfigConstant.scancodeWareHouseUrl = scancodeWareHouseUrl;
    }

    public static String getScancodeIOTComponentUrl() {
        return scancodeIOTComponentUrl;
    }

    @Value("${scancode.iot.component.url}")
    public void setScancodeIOTComponentUrl(String scancodeIOTComponentUrl) {
        ConfigConstant.scancodeIOTComponentUrl = scancodeIOTComponentUrl;
    }

    public static String getScancodeIOTDeliverUrl() {
        return scancodeIOTDeliverUrl;
    }

    @Value("${scancode.iot.deliver.url}")
    public void setScancodeIOTDeliverUrl(String scancodeIOTDeliverUrl) {
        ConfigConstant.scancodeIOTDeliverUrl = scancodeIOTDeliverUrl;
    }

    public static String getWebDomain() {
        return webDomain;
    }

    @Value("${web.domain}")
    public void setWebDomain(String webDomain) {
        ConfigConstant.webDomain = webDomain;
    }

    public static String getIotKey() {
        return iotKey;
    }

    public static String getProductKey() {
        return productKey;
    }

    public static String getPurchaseKey() {
        return purchaseKey;
    }

    public static String getWarehouseKey() {
        return warehouseKey;
    }

    public static String getPasswordSlat() {
        return passwordSlat;
    }

    public static String getTokenBase64Security() {
        return tokenBase64Security;
    }

    public static int getSessionExpireTime() {
        return sessionExpireTime;
    }


}
