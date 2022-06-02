package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysCase;

/**
 * 案件管理Service接口
 * 
 * @author zsq
 * @date 2022-04-01
 */
public interface ISysCaseService 
{
    /**
     * 查询案件管理
     * 
     * @param caseId 案件管理主键
     * @return 案件管理
     */
    public SysCase selectSysCaseByCaseId(Long caseId);

    /**
     * 查询案件管理列表
     * 
     * @param sysCase 案件管理
     * @return 案件管理集合
     */
    public List<SysCase> selectSysCaseList(SysCase sysCase);

    /**
     * 新增案件管理
     * 
     * @param sysCase 案件管理
     * @return 结果
     */
    public int insertSysCase(SysCase sysCase);

    /**
     * 修改案件管理
     * 
     * @param sysCase 案件管理
     * @return 结果
     */
    public int updateSysCase(SysCase sysCase);

    /**
     * 批量删除案件管理
     * 
     * @param caseIds 需要删除的案件管理主键集合
     * @return 结果
     */
    public int deleteSysCaseByCaseIds(String caseIds);

    /**
     * 删除案件管理信息
     * 
     * @param caseId 案件管理主键
     * @return 结果
     */
    public int deleteSysCaseByCaseId(Long caseId);
}
