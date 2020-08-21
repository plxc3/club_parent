package com.plxcc.admin.utils;

import com.plxcc.admin.entity.Proxy;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 * @PackgeName: com.plxcc.admin.utils
 * @ClassName: SchoolSort
 * @Author: plxc
 * Date: 2020/8/19 9:48
 * project name: club_parent
 * @Version:
 * @Description:
 */
public class SchoolSort implements Comparator<Proxy> {
    Collator collator = Collator.getInstance(Locale.CHINA);
    @Override
    public int compare(Proxy o1, Proxy o2) {
        return collator.compare(o1.getUniName(),o2.getUniName());
    }
}
