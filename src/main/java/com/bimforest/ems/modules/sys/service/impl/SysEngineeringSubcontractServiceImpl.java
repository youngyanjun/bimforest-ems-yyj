package com.bimforest.ems.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bimforest.ems.common.enums.StatusEnums;
import com.bimforest.ems.modules.sys.entity.SysEngineeringSubcontract;
import com.bimforest.ems.modules.sys.entity.SysUser;
import com.bimforest.ems.modules.sys.mapper.SysEngineeringSubcontractMapper;
import com.bimforest.ems.modules.sys.service.SysEngineeringSubcontractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 分包商表 服务实现类
 * </p>
 *
 * @author youngyanjun
 * @since 2019-11-04
 */
@Service
public class SysEngineeringSubcontractServiceImpl extends ServiceImpl<SysEngineeringSubcontractMapper, SysEngineeringSubcontract> implements SysEngineeringSubcontractService {
    @Autowired
    SysEngineeringSubcontractMapper sysEngineeringSubcontractMapper;
    @Override
    public IPage<Map<String, Object>> selectList(IPage<SysUser> page, String subcontractorrName) {

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper();
        queryWrapper.like(StringUtils.isNotEmpty(subcontractorrName), "unit_name", subcontractorrName)//查询条件
                .select("unit_name", "contact", "phone", "create_date")
                .ne("status", StatusEnums.ENABLED_N.getCode())//查找状态不为“-1”的值
                .orderByDesc("create_date");//根据创建时间倒叙
//        IPage<Map<String, Object>> mapIPage = sysEngineeringSubcontractMapper.selectMapsMyPage(page, queryWrapper);

        return null;
    }
}
