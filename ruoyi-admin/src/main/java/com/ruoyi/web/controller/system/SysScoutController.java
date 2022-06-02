package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.domain.SysCase;
import com.ruoyi.system.domain.SysReceipt;
import com.ruoyi.system.domain.SysScout;
import com.ruoyi.system.service.ISysCaseService;
import com.ruoyi.system.service.ISysReceiptService;
import com.ruoyi.system.service.ISysScoutService;
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
@RequestMapping("/system/sysscout")
public class SysScoutController extends BaseController
{
    private String prefix = "system/syscase";

    @Autowired
    private ISysCaseService sysCaseService;

    @Autowired
    private ISysReceiptService receiptService;

    @Autowired
    private ISysScoutService sysScoutService;

    @RequiresPermissions("system:sysscout:scout")
    @GetMapping("/scout")
    public String scout()
    {
        return prefix + "/sysscout";
    }


    @GetMapping("/add/{id}")
    public String add(@PathVariable("id")Long id,ModelMap mmap)
    {
        SysScout sysScout = new SysScout();
        mmap.put("sysScout", sysScout);
        sysScout.setCaseId(id);
        return prefix + "/scoutadd";
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
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysScout sysScout = new SysScout();
        sysScout.setCaseId(id);
        List<SysScout> sysScouts = sysScoutService.selectSysScoutList(sysScout);
        mmap.put("sysScout", sysScouts.get(0));
        return prefix + "/scoutedit";
    }

    @Log(title = "侦察信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysScout sysScout,String caseStatus) {
        SysCase sysCase = new SysCase();
        sysCase.setCaseId(sysScout.getCaseId());
        sysCase.setCaseStatus(caseStatus);
        sysCaseService.updateSysCase(sysCase);
        return toAjax(sysScoutService.insertSysScout(sysScout));
    }


}
