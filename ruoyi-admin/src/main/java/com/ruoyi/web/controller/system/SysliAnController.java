package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysCase;
import com.ruoyi.system.domain.SysReceipt;
import com.ruoyi.system.service.ISysCaseService;
import com.ruoyi.system.service.ISysReceiptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 案件管理Controller
 *
 * @author zsq
 * @date 2022-04-01
 */
@Controller
@RequestMapping("/system/syslian")
public class SysliAnController extends BaseController
{
    private String prefix = "system/syscase";

    @Autowired
    private ISysCaseService sysCaseService;

    @Autowired
    private ISysReceiptService receiptService;

    @RequiresPermissions("system:syslian:liAn")
    @GetMapping("/liAn")
    public String syscase()
    {
        return prefix + "/syslian";
    }

    @GetMapping("/receiptaddpage/{caseId}")
    public String receiptaddpage(@PathVariable("caseId") Long caseId,ModelMap modelMap)
    {
        SysCase sysCase = sysCaseService.selectSysCaseByCaseId(caseId);
        SysReceipt sysReceipt = new SysReceipt();
        sysReceipt.setCreateTime(new Date());
        sysReceipt.setCaseId(sysCase.getCaseId());
        sysReceipt.setCaseName(sysCase.getCaseName());
        sysReceipt.setPoliceMan(sysCase.getCallPoliceInfo());
        sysReceipt.setDeptName(ShiroUtils.getSysUser().getDept().getDeptName());
        if (receiptService.selectSysReceiptList(sysReceipt).size()==0){
            receiptService.insertSysReceipt(sysReceipt);
            sysCase.setCaseStatus("3");
            sysCaseService.updateSysCase(sysCase);
        }

        modelMap.put("sysReceipt", sysReceipt);
        return prefix + "/receiptadd";
    }


    /**
     * 查询案件管理列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysCase sysCase)
    {
        startPage();
        List<SysCase> list = sysCaseService.selectSysCaseList(sysCase);
        return getDataTable(list);
    }
    @GetMapping("/detail/{caseId}")
    public String detail(@PathVariable("caseId") Long caseId, ModelMap mmap)
    {
        SysCase sysCase = sysCaseService.selectSysCaseByCaseId(caseId);
        mmap.put("sysCase", sysCase);
        return prefix + "/detail";
    }


}
