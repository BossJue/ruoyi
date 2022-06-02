package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysScoutMapper;
import com.ruoyi.system.domain.SysScout;
import com.ruoyi.system.service.ISysScoutService;
import com.ruoyi.common.core.text.Convert;

/**
 * 侦察信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-29
 */
@Service
public class SysScoutServiceImpl implements ISysScoutService 
{
    @Autowired
    private SysScoutMapper sysScoutMapper;

    /**
     * 查询侦察信息
     * 
     * @param scoutId 侦察信息主键
     * @return 侦察信息
     */
    @Override
    public SysScout selectSysScoutByScoutId(Long scoutId)
    {
        return sysScoutMapper.selectSysScoutByScoutId(scoutId);
    }

    /**
     * 查询侦察信息列表
     * 
     * @param sysScout 侦察信息
     * @return 侦察信息
     */
    @Override
    public List<SysScout> selectSysScoutList(SysScout sysScout)
    {
        return sysScoutMapper.selectSysScoutList(sysScout);
    }

    /**
     * 新增侦察信息
     * 
     * @param sysScout 侦察信息
     * @return 结果
     */
    @Override
    public int insertSysScout(SysScout sysScout)
    {
        return sysScoutMapper.insertSysScout(sysScout);
    }

    /**
     * 修改侦察信息
     * 
     * @param sysScout 侦察信息
     * @return 结果
     */
    @Override
    public int updateSysScout(SysScout sysScout)
    {
        return sysScoutMapper.updateSysScout(sysScout);
    }

    /**
     * 批量删除侦察信息
     * 
     * @param scoutIds 需要删除的侦察信息主键
     * @return 结果
     */
    @Override
    public int deleteSysScoutByScoutIds(String scoutIds)
    {
        return sysScoutMapper.deleteSysScoutByScoutIds(Convert.toStrArray(scoutIds));
    }

    /**
     * 删除侦察信息信息
     * 
     * @param scoutId 侦察信息主键
     * @return 结果
     */
    @Override
    public int deleteSysScoutByScoutId(Long scoutId)
    {
        return sysScoutMapper.deleteSysScoutByScoutId(scoutId);
    }
}
