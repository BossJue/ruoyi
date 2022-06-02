package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysReceipt;

/**
 * 案件回执Service接口
 * 
 * @author zsq
 * @date 2022-04-29
 */
public interface ISysReceiptService 
{
    /**
     * 查询案件回执
     * 
     * @param receiptId 案件回执主键
     * @return 案件回执
     */
    public SysReceipt selectSysReceiptByReceiptId(Long receiptId);

    /**
     * 查询案件回执列表
     * 
     * @param sysReceipt 案件回执
     * @return 案件回执集合
     */
    public List<SysReceipt> selectSysReceiptList(SysReceipt sysReceipt);

    /**
     * 新增案件回执
     * 
     * @param sysReceipt 案件回执
     * @return 结果
     */
    public int insertSysReceipt(SysReceipt sysReceipt);

    /**
     * 修改案件回执
     * 
     * @param sysReceipt 案件回执
     * @return 结果
     */
    public int updateSysReceipt(SysReceipt sysReceipt);

    /**
     * 批量删除案件回执
     * 
     * @param receiptIds 需要删除的案件回执主键集合
     * @return 结果
     */
    public int deleteSysReceiptByReceiptIds(String receiptIds);

    /**
     * 删除案件回执信息
     * 
     * @param receiptId 案件回执主键
     * @return 结果
     */
    public int deleteSysReceiptByReceiptId(Long receiptId);
}
