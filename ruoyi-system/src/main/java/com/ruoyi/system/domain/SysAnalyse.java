package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 分析对象 sys_analyse
 *
 * @author ruoyi
 * @date 2022-04-30
 */
public class SysAnalyse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /**  */

    private Long caseId;

    /**  */

    private Long toCaseId;

    /**  */

    private String caseAnalyse;


    private String caseName;


    private String toCaseName;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCaseId(Long caseId)
    {
        this.caseId = caseId;
    }

    public Long getCaseId()
    {
        return caseId;
    }
    public void setToCaseId(Long toCaseId)
    {
        this.toCaseId = toCaseId;
    }

    public Long getToCaseId()
    {
        return toCaseId;
    }
    public void setCaseAnalyse(String caseAnalyse)
    {
        this.caseAnalyse = caseAnalyse;
    }

    public String getCaseAnalyse()
    {
        return caseAnalyse;
    }
    public void setCaseName(String caseName)
    {
        this.caseName = caseName;
    }

    public String getCaseName()
    {
        return caseName;
    }
    public void setToCaseName(String toCaseName)
    {
        this.toCaseName = toCaseName;
    }

    public String getToCaseName()
    {
        return toCaseName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("caseId", getCaseId())
            .append("toCaseId", getToCaseId())
            .append("caseAnalyse", getCaseAnalyse())
            .append("caseName", getCaseName())
            .append("toCaseName", getToCaseName())
            .toString();
    }
}
