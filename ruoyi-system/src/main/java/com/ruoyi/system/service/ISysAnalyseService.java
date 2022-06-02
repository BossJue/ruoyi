package com.ruoyi.system.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.SysAnalyse;

/**
 * 分析Service接口
 *
 * @author ruoyi
 * @date 2022-04-30
 */
public interface ISysAnalyseService
{
    /**
     * 查询分析
     *
     * @param id 分析主键
     * @return 分析
     */
    public SysAnalyse selectSysAnalyseById(Long id);

    /**
     * 查询分析列表
     *
     * @param sysAnalyse 分析
     * @return 分析集合
     */
    public List<SysAnalyse> selectSysAnalyseList(SysAnalyse sysAnalyse);

    /**
     * 新增分析
     *
     * @param sysAnalyse 分析
     * @return 结果
     */
    public int insertSysAnalyse(SysAnalyse sysAnalyse);

    /**
     * 修改分析
     *
     * @param sysAnalyse 分析
     * @return 结果
     */
    public int updateSysAnalyse(SysAnalyse sysAnalyse);

    /**
     * 批量删除分析
     *
     * @param ids 需要删除的分析主键集合
     * @return 结果
     */
    public int deleteSysAnalyseByIds(String ids);

    /**
     * 删除分析信息
     *
     * @param id 分析主键
     * @return 结果
     */
    public int deleteSysAnalyseById(Long id);

    void deleteAll();

    List<Map<String, Object>> liAnTongJi();
}
