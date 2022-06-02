package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysReceiptMapper;
import com.ruoyi.system.domain.SysReceipt;
import com.ruoyi.system.service.ISysReceiptService;
import com.ruoyi.common.core.text.Convert;

/**
 * 案件回执Service业务层处理
 * 
 * @author zsq
 * @date 2022-04-29
 */
@Service
public class SysReceiptServiceImpl implements ISysReceiptService 
{
    @Autowired
    private SysReceiptMapper sysReceiptMapper;

    /**
     * 查询案件回执
     * 
     * @param receiptId 案件回执主键
     * @return 案件回执
     */
    @Override
    public SysReceipt selectSysReceiptByReceiptId(Long receiptId)
    {
        return sysReceiptMapper.selectSysReceiptByReceiptId(receiptId);
    }

    /**
     * 查询案件回执列表
     * 
     * @param sysReceipt 案件回执
     * @return 案件回执
     */
    @Override
    public List<SysReceipt> selectSysReceiptList(SysReceipt sysReceipt)
    {
        return sysReceiptMapper.selectSysReceiptList(sysReceipt);
    }

    /**
     * 新增案件回执
     * 
     * @param sysReceipt 案件回执
     * @return 结果
     */
    @Override
    public int insertSysReceipt(SysReceipt sysReceipt)
    {
        sysReceipt.setCreateTime(DateUtils.getNowDate());
        return sysReceiptMapper.insertSysReceipt(sysReceipt);
    }

    /**
     * 修改案件回执
     * 
     * @param sysReceipt 案件回执
     * @return 结果
     */
    @Override
    public int updateSysReceipt(SysReceipt sysReceipt)
    {
        return sysReceiptMapper.updateSysReceipt(sysReceipt);
    }

    /**
     * 批量删除案件回执
     * 
     * @param receiptIds 需要删除的案件回执主键
     * @return 结果
     */
    @Override
    public int deleteSysReceiptByReceiptIds(String receiptIds)
    {
        return sysReceiptMapper.deleteSysReceiptByReceiptIds(Convert.toStrArray(receiptIds));
    }

    /**
     * 删除案件回执信息
     * 
     * @param receiptId 案件回执主键
     * @return 结果
     */
    @Override
    public int deleteSysReceiptByReceiptId(Long receiptId)
    {
        return sysReceiptMapper.deleteSysReceiptByReceiptId(receiptId);
    }
}
