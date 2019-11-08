package com.bimforest.ems.autofill;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.bimforest.ems.common.enums.StatusEnums;
import com.bimforest.ems.modules.sys.entity.SysUser;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author youngyanjun
 * @date 2019-11-06 13:22
 */
@Component
public class MPMetaHandler implements MetaObjectHandler {







    /**
     *  新增数据执行
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Date date = new Date();
     //        SysUser userEntity = ShiroUtil.getUser();
        this.setFieldValByName("createDate", date, metaObject);
//        this.setFieldValByName("createBy", userEntity.getLoginName(), metaObject);
        this.setFieldValByName("updateDate", new Date(), metaObject);
//        this.setFieldValByName("updateBy", userEntity.getLoginName(), metaObject);
        this.setFieldValByName("status", StatusEnums.ENABLED_Y.getCode(), metaObject);
        System.out.println("-------------------------------");
    }

    /**
     * 更新数据执行
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
  //        SysUser userEntity = ShiroUtil.getUser();
        this.setFieldValByName("updateTime", new Date(), metaObject);
//        this.setFieldValByName("updateBy", SysUser.getLoginName(), metaObject);
    }
}
