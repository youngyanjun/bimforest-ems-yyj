package com.bimforest.ems.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.bimforest.ems.modules.sys.entity.SysEngineeringSubcontract;
import com.bimforest.ems.modules.sys.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Wrapper;
import java.util.Map;

/**
 * <p>
 * 分包商表 Mapper 接口
 * </p>
 *
 * @author youngyanjun
 * @since 2019-11-04
 */
public interface SysEngineeringSubcontractMapper extends BaseMapper<SysEngineeringSubcontract> {
    @Select("")
    IPage<Map<String, Object>> selectMapsMyPage( IPage<SysUser> page,@Param(Constants.WRAPPER) Wrapper wrapper);
}
