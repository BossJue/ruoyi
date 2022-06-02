package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 案件管理对象 sys_case
 *
 * @author zsq
 * @date 2022-04-01
 */
public class SysCase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long caseId;

    /** 案件名称 */
    @Excel(name = "案件名称")
    private String caseName;

    /** 案件编号 */
    @Excel(name = "案件编号")
    private String caseNum;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 案发时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "案发时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date caseDate;

    /** 案发地点 */
    @Excel(name = "案发地点")
    private String address;

    /** 作案方式 */
    @Excel(name = "作案方式")
    private String caseWay;

    /** 嫌疑人特征 */
    @Excel(name = "嫌疑人特征")
    private String offenderChar;

    /** 报警人信息 */
    @Excel(name = "报警人信息")
    private String callPoliceInfo;

    /** 案件状态 */
    @Excel(name = "案件状态")
    private String caseStatus;

    @Excel(name = "是否受理")
    private String shouLi;

    /** 图片 */
    @Excel(name = "图片")
    private String casePic;

    /** 审批建议 */
    @Excel(name = "审批建议")
    private String caseSuggest;

    private Long userId;

    private Long deptId;

    public String getShouLi() {
        return shouLi;
    }

    public void setShouLi(String shouLi) {
        this.shouLi = shouLi;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public void setCaseId(Long caseId)
    {
        this.caseId = caseId;
    }

    public Long getCaseId()
    {
        return caseId;
    }
    public void setCaseName(String caseName)
    {
        this.caseName = caseName;
    }

    public String getCaseName()
    {
        return caseName;
    }
    public void setCaseNum(String caseNum)
    {
        this.caseNum = caseNum;
    }

    public String getCaseNum()
    {
        return caseNum;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setCaseDate(Date caseDate)
    {
        this.caseDate = caseDate;
    }

    public Date getCaseDate()
    {
        return caseDate;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setCaseWay(String caseWay)
    {
        this.caseWay = caseWay;
    }

    public String getCaseWay()
    {
        return caseWay;
    }
    public void setOffenderChar(String offenderChar)
    {
        this.offenderChar = offenderChar;
    }

    public String getOffenderChar()
    {
        return offenderChar;
    }
    public void setCallPoliceInfo(String callPoliceInfo)
    {
        this.callPoliceInfo = callPoliceInfo;
    }

    public String getCallPoliceInfo()
    {
        return callPoliceInfo;
    }
    public void setCaseStatus(String caseStatus)
    {
        this.caseStatus = caseStatus;
    }

    public String getCaseStatus()
    {
        return caseStatus;
    }
    public void setCasePic(String casePic)
    {
        this.casePic = casePic;
    }

    public String getCasePic()
    {
        return casePic;
    }
    public void setCaseSuggest(String caseSuggest)
    {
        this.caseSuggest = caseSuggest;
    }

    public String getCaseSuggest()
    {
        return caseSuggest;
    }

    @Override
    public String toString() {
        return "SysCase{" +
                "caseId=" + caseId +
                ", caseName='" + caseName + '\'' +
                ", caseNum='" + caseNum + '\'' +
                ", content='" + content + '\'' +
                ", caseDate=" + caseDate +
                ", address='" + address + '\'' +
                ", caseWay='" + caseWay + '\'' +
                ", offenderChar='" + offenderChar + '\'' +
                ", callPoliceInfo='" + callPoliceInfo + '\'' +
                ", caseStatus='" + caseStatus + '\'' +
                ", shouLi='" + shouLi + '\'' +
                ", casePic='" + casePic + '\'' +
                ", caseSuggest='" + caseSuggest + '\'' +
                ", userId=" + userId +
                ", deptId=" + deptId +
                '}';
    }
}
