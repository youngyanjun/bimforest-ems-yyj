package com.bimforest.ems.modules.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bimforest.ems.annotation.OperationLog;
import com.bimforest.ems.common.CommonResponse;
import com.bimforest.ems.common.enums.MessageEnums;
import com.bimforest.ems.common.enums.ResponseTypeEnums;
import com.bimforest.ems.common.utils.CheckUtil;
import com.bimforest.ems.modules.sys.entity.SysEngineeringSubcontract;
import com.bimforest.ems.modules.sys.entity.SysUser;
import com.bimforest.ems.modules.sys.mapper.SysEngineeringSubcontractMapper;
import com.bimforest.ems.modules.sys.service.SysEngineeringSubcontractService;
import com.bimforest.ems.modules.sys.vo.SubcontractorVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 分包商表 前端控制器
 * </p>
 *
 * @author youngyanjun
 * @since 2019-11-04
 */
@RestController
@RequestMapping("/subcontractor/engineering-subcontract")
public class SysEngineeringSubcontractController {
    @Autowired
    SysEngineeringSubcontractService sysEngineeringSubcontractService;
    @Autowired
    SysEngineeringSubcontractMapper sysEngineeringSubcontractMapper;


    @ApiOperation(value = "分包商管理---新增分包商")
    @PostMapping("/insertUser")
    @OperationLog(module = "分包商管理",action = "新增分包商")
    @Transactional
    public CommonResponse insertUser(@RequestBody  SubcontractorVO subcontractorVO) {
        //检查电话号码是否符合规则
        if (!CheckUtil.checkPhone(subcontractorVO.getPhone())){
            return new CommonResponse(ResponseTypeEnums.FAILED,MessageEnums.FIAL_SYS_2004.getCode(),MessageEnums.FIAL_SYS_2004.getMessage());
        }
        //判断企业名称和纳税识别号是否已经存在
        QueryWrapper queryWrapperName = new QueryWrapper();
        QueryWrapper queryWrapperCode = new QueryWrapper();
        queryWrapperName.eq("unit_name" ,subcontractorVO.getUnitName());
        queryWrapperCode.eq("tax_code", subcontractorVO.getTaxCode());
        if(sysEngineeringSubcontractService.count(queryWrapperName) != 0 | sysEngineeringSubcontractService.count(queryWrapperCode) != 0 ) {
            return new CommonResponse(ResponseTypeEnums.FAILED, MessageEnums.FIAL_SYS_2010.getCode(),MessageEnums.FIAL_SYS_2010.getMessage());
        }

        SysEngineeringSubcontract engineeringSubcontract = new SysEngineeringSubcontract();
        engineeringSubcontract.setUnitName(subcontractorVO.getUnitName());
        engineeringSubcontract.setTaxCode(subcontractorVO.getTaxCode());
        engineeringSubcontract.setAddress(subcontractorVO.getAddress());
        engineeringSubcontract.setContact(subcontractorVO.getContact());
        engineeringSubcontract.setPhone(subcontractorVO.getPhone());
        engineeringSubcontract.setJuridicalPerson(subcontractorVO.getJuridicalPerson());
        engineeringSubcontract.setRemark(subcontractorVO.getRemark());

        sysEngineeringSubcontractMapper.insert(engineeringSubcontract);
        return new CommonResponse(ResponseTypeEnums.SUCCESS);
    }

    /**
     * 封包商列表查询
     * @return
     */
       public CommonResponse selectSubcontractorList(@ApiParam("通过分包商查找分包商") String subcontractorrName,
                                        @RequestParam(required = false, defaultValue = "10") @ApiParam("每页显示条数") int pageSize,
                                        @RequestParam(required = false, defaultValue = "1") @ApiParam("当前页码") int pageNum) {
        IPage<SysUser> page = new Page(pageNum, pageSize);
        IPage<Map<String, Object>> userListVOIPage = sysEngineeringSubcontractService.selectList(page, subcontractorrName);
        return new CommonResponse(ResponseTypeEnums.SUCCESS, userListVOIPage);
    }

}
