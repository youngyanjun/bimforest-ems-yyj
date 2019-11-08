package com.bimforest.ems.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bimforest.ems.modules.sys.entity.SysEngineeringSubcontract;
import com.bimforest.ems.modules.sys.entity.SysUser;

import java.util.Map;

/**
 * <p>
 * 分包商表 服务类
 * </p>
 *
 * @author youngyanjun
 * @since 2019-11-04
 */
public interface SysEngineeringSubcontractService  extends IService<SysEngineeringSubcontract> {
    //查询分包商列表
    IPage<Map<String, Object>> selectList(IPage<SysUser>  page, String subcontractorrName);

}
