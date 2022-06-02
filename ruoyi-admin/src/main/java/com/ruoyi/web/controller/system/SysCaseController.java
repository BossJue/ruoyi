package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysCase;
import com.ruoyi.system.service.ISysCaseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 案件管理Controller
 *
 * @author zsq
 * @date 2022-04-01
 */
@Controller
@RequestMapping("/system/syscase")
public class SysCaseController extends BaseController
{
    private String prefix = "system/syscase";

    @Autowired
    private ISysCaseService sysCaseService;

    @RequiresPermissions("system:syscase:view")
    @GetMapping()
    public String syscase()
    {
        return prefix + "/syscase";
    }


    @RequiresPermissions("system:syscase:checkCase")
    @GetMapping("/checkCase")
    public String checkCase() {
        return prefix + "/checkCase";
    }
    @RequiresPermissions("system:syscase:shouli")
    @GetMapping("/shouLi")
    public String shouLi() {
        return prefix + "/shouli";
    }
    @RequiresPermissions("system:syscase:putCase")
    @GetMapping("/putCase")
    public String putCase()
    {
        return prefix + "/putcase";
    }

    /**
     * 查询案件管理列表
     */
    @RequiresPermissions("system:syscase:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysCase sysCase)
    {
        startPage();
        List<SysCase> list = sysCaseService.selectSysCaseList(sysCase);
        return getDataTable(list);
    }

    /**
     * 导出案件管理列表
     */
    @RequiresPermissions("system:syscase:export")
    @Log(title = "案件管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysCase sysCase)
    {
        List<SysCase> list = sysCaseService.selectSysCaseList(sysCase);
        ExcelUtil<SysCase> util = new ExcelUtil<SysCase>(SysCase.class);
        return util.exportExcel(list, "案件管理数据");
    }

    /**
     * 新增案件管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存案件管理
     */
    @RequiresPermissions("system:syscase:add")
    @Log(title = "案件管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysCase sysCase)
    {
        SysUser sysUser = ShiroUtils.getSysUser();
        sysCase.setUserId(sysUser.getUserId());
        sysCase.setDeptId(sysUser.getDeptId());
        sysCase.setShouLi("0");
        return toAjax(sysCaseService.insertSysCase(sysCase));
    }

    /**
     * 修改案件管理
     */
    @RequiresPermissions("system:syscase:edit")
    @GetMapping("/edit/{caseId}")
    public String edit(@PathVariable("caseId") Long caseId, ModelMap mmap)
    {
        SysCase sysCase = sysCaseService.selectSysCaseByCaseId(caseId);
        mmap.put("sysCase", sysCase);
        return prefix + "/edit";
    }
    @GetMapping("/checkCaseEdit/{caseId}")
    public String checkCaseEdit(@PathVariable("caseId") Long caseId, ModelMap mmap)
    {
        SysCase sysCase = sysCaseService.selectSysCaseByCaseId(caseId);
        mmap.put("sysCase", sysCase);
        return prefix + "/checkCaseEdit";
    }
    /*@RequiresPermissions("system:syscase:edit")*/
    @GetMapping("/detail/{caseId}")
    public String detail(@PathVariable("caseId") Long caseId, ModelMap mmap)
    {
        SysCase sysCase = sysCaseService.selectSysCaseByCaseId(caseId);
        mmap.put("sysCase", sysCase);
        return prefix + "/detail";
    }

    /**
     * 修改保存案件管理
     */
    @RequiresPermissions("system:syscase:edit")
    @Log(title = "案件管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysCase sysCase)
    {
        return toAjax(sysCaseService.updateSysCase(sysCase));
    }


    @Log(title = "案件管理", businessType = BusinessType.UPDATE)
    @GetMapping("/updateShouLi/{caseId}")
    @ResponseBody
    public AjaxResult updateShouLi(@PathVariable("caseId") Long caseId)
    {
        SysCase sysCase=new SysCase();
        sysCase.setCaseId(caseId);
        sysCase.setShouLi("1");
        return toAjax(sysCaseService.updateSysCase(sysCase));
    }

    /**
     * 删除案件管理
     */
    @RequiresPermissions("system:syscase:remove")
    @Log(title = "案件管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysCaseService.deleteSysCaseByCaseIds(ids));
    }
}
