package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 案件回执对象 sys_receipt
 * 
 * @author zsq
 * @date 2022-04-29
 */
public class SysReceipt extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 回执id */
    private Long receiptId;

    /** 报警人 */
    @Excel(name = "报警人")
    private String policeMan;

    /** 案件名 */
    @Excel(name = "案件名")
    private String caseName;

    /** 立案部门名称 */
    @Excel(name = "立案部门名称")
    private String deptName;

    /** 关联案件 */
    @Excel(name = "关联案件")
    private Long caseId;

    public void setReceiptId(Long receiptId) 
    {
        this.receiptId = receiptId;
    }

    public Long getReceiptId() 
    {
        return receiptId;
    }
    public void setPoliceMan(String policeMan) 
    {
        this.policeMan = policeMan;
    }

    public String getPoliceMan() 
    {
        return policeMan;
    }
    public void setCaseName(String caseName) 
    {
        this.caseName = caseName;
    }

    public String getCaseName() 
    {
        return caseName;
    }
    public void setDeptName(String deptName) 
    {
        this.deptName = deptName;
    }

    public String getDeptName() 
    {
        return deptName;
    }
    public void setCaseId(Long caseId) 
    {
        this.caseId = caseId;
    }

    public Long getCaseId() 
    {
        return caseId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("receiptId", getReceiptId())
            .append("policeMan", getPoliceMan())
            .append("caseName", getCaseName())
            .append("createTime", getCreateTime())
            .append("deptName", getDeptName())
            .append("caseId", getCaseId())
            .toString();
    }
}
