package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysScout;

/**
 * 侦察信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-04-29
 */
public interface SysScoutMapper 
{
    /**
     * 查询侦察信息
     * 
     * @param scoutId 侦察信息主键
     * @return 侦察信息
     */
    public SysScout selectSysScoutByScoutId(Long scoutId);

    /**
     * 查询侦察信息列表
     * 
     * @param sysScout 侦察信息
     * @return 侦察信息集合
     */
    public List<SysScout> selectSysScoutList(SysScout sysScout);

    /**
     * 新增侦察信息
     * 
     * @param sysScout 侦察信息
     * @return 结果
     */
    public int insertSysScout(SysScout sysScout);

    /**
     * 修改侦察信息
     * 
     * @param sysScout 侦察信息
     * @return 结果
     */
    public int updateSysScout(SysScout sysScout);

    /**
     * 删除侦察信息
     * 
     * @param scoutId 侦察信息主键
     * @return 结果
     */
    public int deleteSysScoutByScoutId(Long scoutId);

    /**
     * 批量删除侦察信息
     * 
     * @param scoutIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysScoutByScoutIds(String[] scoutIds);
}
