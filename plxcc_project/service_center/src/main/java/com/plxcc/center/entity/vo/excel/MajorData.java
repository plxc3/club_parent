package com.plxcc.center.entity.vo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @PackgeName: com.plxcc.center.entity.vo.excel
 * @ClassName: MajorData
 * @Author: plxc
 * Date: 2020/8/13 5:04
 * project name: club_parent
 * @Version:
 * @Description:
 */

@Data
public class MajorData {

    @ExcelProperty(index = 0)
    private String college;

    @ExcelProperty(index = 1)
    private String major;

}
