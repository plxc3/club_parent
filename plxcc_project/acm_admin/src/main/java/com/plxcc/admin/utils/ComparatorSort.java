package com.plxcc.admin.utils;

import com.plxcc.admin.entity.vo.AdminListVo;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 * @PackgeName: com.plxcc.admin.utils
 * @ClassName: ComparatorSort
 * @Author: plxc
 * Date: 2020/8/17 21:36
 * project name: club_parent
 * @Version:
 * @Description:
 */
public class ComparatorSort implements Comparator<AdminListVo> {

    Collator collator = Collator.getInstance(Locale.CHINA);
    @Override
    public int compare(AdminListVo o1, AdminListVo o2) {
        // TODO Auto-generated method stub
        return collator.compare(o1.getUniName(),o2.getUniName());
    }
}
