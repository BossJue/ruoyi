package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysCaseMapper;
import com.ruoyi.system.domain.SysCase;
import com.ruoyi.system.service.ISysCaseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 案件管理Service业务层处理
 *
 * @author zsq
 * @date 2022-04-01
 */
@Service
public class SysCaseServiceImpl implements ISysCaseService
{
    @Autowired
    private SysCaseMapper sysCaseMapper;

    /**
     * 查询案件管理
     *
     * @param caseId 案件管理主键
     * @return 案件管理
     */
    @Override
    @DataScope(deptAlias = "sys_dept")
    public SysCase selectSysCaseByCaseId(Long caseId)
    {
        return sysCaseMapper.selectSysCaseByCaseId(caseId);
    }

    /**
     * 查询案件管理列表
     *
     * @param sysCase 案件管理
     * @return 案件管理
     */
    @Override
    @DataScope(deptAlias = "sys_dept")
    public List<SysCase> selectSysCaseList(SysCase sysCase)
    {
        return sysCaseMapper.selectSysCaseList(sysCase);
    }

    /**
     * 新增案件管理
     *
     * @param sysCase 案件管理
     * @return 结果
     */
    @Override
    public int insertSysCase(SysCase sysCase)
    {
        return sysCaseMapper.insertSysCase(sysCase);
    }

    /**
     * 修改案件管理
     *
     * @param sysCase 案件管理
     * @return 结果
     */
    @Override
    public int updateSysCase(SysCase sysCase)
    {
        return sysCaseMapper.updateSysCase(sysCase);
    }

    /**
     * 批量删除案件管理
     *
     * @param caseIds 需要删除的案件管理主键
     * @return 结果
     */
    @Override
    public int deleteSysCaseByCaseIds(String caseIds)
    {
        return sysCaseMapper.deleteSysCaseByCaseIds(Convert.toStrArray(caseIds));
    }

    /**
     * 删除案件管理信息
     *
     * @param caseId 案件管理主键
     * @return 结果
     */
    @Override
    public int deleteSysCaseByCaseId(Long caseId)
    {
        return sysCaseMapper.deleteSysCaseByCaseId(caseId);
    }
}
