package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 侦察信息对象 sys_scout
 * 
 * @author ruoyi
 * @date 2022-04-29
 */
public class SysScout extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long scoutId;

    /** 侦察内容 */
    @Excel(name = "侦察内容")
    private String scoutCotent;

    /** 关联案件 */
    private Long caseId;

    public void setScoutId(Long scoutId) 
    {
        this.scoutId = scoutId;
    }

    public Long getScoutId() 
    {
        return scoutId;
    }
    public void setScoutCotent(String scoutCotent) 
    {
        this.scoutCotent = scoutCotent;
    }

    public String getScoutCotent() 
    {
        return scoutCotent;
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
            .append("scoutId", getScoutId())
            .append("scoutCotent", getScoutCotent())
            .append("caseId", getCaseId())
            .toString();
    }
}
