package com.bimforest.ems.common.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

/**
 * @author youngyanjun
 * @title: ${}
 * @date 2019-11-04 16:44
 */
public class CheckUtil {

    public static boolean checkPhoneEMail(String eMail, String phone) {
        if (StringUtils.isEmpty(eMail) | StringUtils.isEmpty(phone)) {
            return false;
        }
        String eMailTemplate = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";
        String phoneTemplate = "0?(13|14|15|17|18|19)[0-9]{9}";

        boolean isEMail = eMail.matches(eMailTemplate);
        boolean isPhone = phone.matches(phoneTemplate);

        if (isEMail && isPhone) {  //验证手机及邮箱都为真则返回 true
            return true;
        }
        return false;
    }


    public static boolean checkPhone(String phone) {
        if ( StringUtils.isEmpty(phone)) {
            return false;
        }
        String phoneTemplate = "0?(13|14|15|17|18|19)[0-9]{9}";

        boolean isPhone = phone.matches(phoneTemplate);

        if ( isPhone) {  //验证手机都为真则返回 true
            return true;
        }
        return false;
    }

    public boolean checkEMail(String eMail) {
        if (StringUtils.isEmpty(eMail)) {
            return false;
        }
        String eMailTemplate = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";

        boolean isEMail = eMail.matches(eMailTemplate);

        if (isEMail ) {  //验证手机及邮箱都为真则返回 true
            return true;
        }
        return false;
    }
}
