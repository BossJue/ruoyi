package com.ruoyi.web.controller.system;

import com.ruoyi.common.utils.SimilarityHelperUtils;

public class Demo {
    public static void main(String[] args) {
        String a="你好呀，我不好，111.";
        String b="你title是mysql的关键字吗";
        float jaccard = SimilarityHelperUtils.jaccard(a, b);
        System.out.println(jaccard);

    }
}
