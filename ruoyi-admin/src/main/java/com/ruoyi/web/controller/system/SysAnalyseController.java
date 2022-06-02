package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.SimilarityHelperUtils;
import com.ruoyi.system.domain.SysAnalyse;
import com.ruoyi.system.domain.SysCase;
import com.ruoyi.system.service.ISysAnalyseService;
import com.ruoyi.system.service.ISysCaseService;
import com.ruoyi.system.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/system/analyse")
public class SysAnalyseController extends BaseController {

    @Autowired
    private ISysCaseService sysCaseService;

    @Autowired
    private ISysAnalyseService sysAnalyseService;

    @Autowired
    private ISysDeptService sysDeptService;

    private String prefix = "system/syscase";

    @GetMapping("/analyse")
    public String analyse() {
        return prefix + "/sysanalyse";
    }
    @GetMapping("/tongji")
    public String tongji() {
        return prefix + "/tongji";
    }

    @RequestMapping("/liAnTongJi")
    @ResponseBody
    public List<Map<String,Object>> liAnTongJi(){
        List<Map<String,Object>> list= sysAnalyseService.liAnTongJi();
        List<SysDept> sysDepts = sysDeptService.selectDeptList(new SysDept());
        List<Map<String,Object>> mapList=new ArrayList<>();
        for (int i = 0; i < sysDepts.size(); i++) {
            Map<String,Object> map=new HashMap();
            map.put("deptName",sysDepts.get(i).getDeptName());
            SysCase sysCase=new SysCase();
            sysCase.setDeptId(sysDepts.get(i).getDeptId());
            map.put("liAn",sysCaseService.selectSysCaseList(sysCase).size());
            for (int j = 0; j < list.size(); j++) {
                if ((list.get(j).get("deptName")+"").equals(sysDepts.get(i).getDeptName())){
                map.put("tongJi",list.get(j).get("tongJi"));
                break;
                }
                map.put("tongJi",0);
            }
            mapList.add(map);
        }
        return mapList;
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysAnalyse sysAnalyse) {
        sysAnalyseService.deleteAll();
        List<SysAnalyse> list=new ArrayList<>();
        List<SysCase> sysCases = sysCaseService.selectSysCaseList(new SysCase());
        for (int i = 0; i < sysCases.size(); i++) {
        List<Map<String,Object>> list1=new ArrayList<>();
            SysCase sysCasei = sysCases.get(i);
            String a=sysCasei.getCaseName()+sysCasei.getAddress()+sysCasei.getCaseWay()+sysCasei.getOffenderChar();
            for (int j = 0; j < sysCases.size(); j++) {
                if (i==j){
                    continue;
                }
                SysCase sysCasej = sysCases.get(j);
                String b=sysCasej.getCaseName()+sysCasej.getAddress()+sysCasej.getCaseWay()+sysCasej.getOffenderChar();
                float analyse = SimilarityHelperUtils.jaccard(a, b);
                Map<String,Object> map=new HashMap<>();
                map.put("caseId",sysCasei.getCaseId());
                map.put("toCaseId",sysCasej.getCaseId());
                map.put("caseName",sysCasei.getCaseName());
                map.put("toCaseName",sysCasej.getCaseName());
                map.put("analyse",analyse);
                list1.add(map);

            }
            List<Map<String, Object>> list2 = list1.stream().sorted((h1, h2) -> ((Float)h2.get("analyse")).compareTo((Float)h1.get("analyse"))).collect(Collectors.toList());
            SysAnalyse sysAnalyse1 = new SysAnalyse();
            sysAnalyse1.setCaseId(Long.parseLong(list2.get(0).get("caseId")+""));
            sysAnalyse1.setToCaseId(Long.parseLong(list2.get(0).get("toCaseId")+""));
            sysAnalyse1.setCaseName(list2.get(0).get("caseName")+"");
            sysAnalyse1.setToCaseName(list2.get(0).get("toCaseName")+"");
            sysAnalyseService.insertSysAnalyse(sysAnalyse1);
            //list.add(sysAnalyse1);
        }

        startPage();
        list = sysAnalyseService.selectSysAnalyseList(sysAnalyse);
        return getDataTable(list);
    }

}
