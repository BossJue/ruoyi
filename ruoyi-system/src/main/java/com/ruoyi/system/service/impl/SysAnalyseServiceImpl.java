package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysAnalyseMapper;
import com.ruoyi.system.domain.SysAnalyse;
import com.ruoyi.system.service.ISysAnalyseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 分析Service业务层处理
 *
 * @author ruoyi
 * @date 2022-04-30
 */
@Service
public class SysAnalyseServiceImpl implements ISysAnalyseService
{
    @Autowired
    private SysAnalyseMapper sysAnalyseMapper;

    /**
     * 查询分析
     *
     * @param id 分析主键
     * @return 分析
     */
    @Override
    public SysAnalyse selectSysAnalyseById(Long id)
    {
        return sysAnalyseMapper.selectSysAnalyseById(id);
    }

    /**
     * 查询分析列表
     *
     * @param sysAnalyse 分析
     * @return 分析
     */
    @Override
    public List<SysAnalyse> selectSysAnalyseList(SysAnalyse sysAnalyse)
    {
        return sysAnalyseMapper.selectSysAnalyseList(sysAnalyse);
    }

    /**
     * 新增分析
     *
     * @param sysAnalyse 分析
     * @return 结果
     */
    @Override
    public int insertSysAnalyse(SysAnalyse sysAnalyse)
    {
        return sysAnalyseMapper.insertSysAnalyse(sysAnalyse);
    }

    /**
     * 修改分析
     *
     * @param sysAnalyse 分析
     * @return 结果
     */
    @Override
    public int updateSysAnalyse(SysAnalyse sysAnalyse)
    {
        return sysAnalyseMapper.updateSysAnalyse(sysAnalyse);
    }

    /**
     * 批量删除分析
     *
     * @param ids 需要删除的分析主键
     * @return 结果
     */
    @Override
    public int deleteSysAnalyseByIds(String ids)
    {
        return sysAnalyseMapper.deleteSysAnalyseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除分析信息
     *
     * @param id 分析主键
     * @return 结果
     */
    @Override
    public int deleteSysAnalyseById(Long id)
    {
        return sysAnalyseMapper.deleteSysAnalyseById(id);
    }

    @Override
    public void deleteAll() {
        sysAnalyseMapper.deleteAll();
    }

    @Override
    public List<Map<String, Object>> liAnTongJi() {
        return sysAnalyseMapper.liAnTongJi();
    }
}
