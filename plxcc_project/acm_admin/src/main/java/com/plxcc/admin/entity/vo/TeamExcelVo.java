package com.plxcc.admin.entity.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

/**
 * @PackgeName: com.plxcc.admin.entity.vo
 * @ClassName: TeamExcelVo
 * @Author: plxc
 * Date: 2020/9/2 16:20
 * project name: club_parent
 * @Version:
 * @Description:
 */
@Data
@ContentRowHeight(20)
@HeadRowHeight(25)
@ColumnWidth(25)
public class TeamExcelVo {

    @ExcelProperty(value = "序号",index = 0)
    private String id;

    @ExcelProperty(value = "队名",index = 1)
    private String teamName;

    @ExcelProperty(value = "英文队名",index = 2)
    private String teamEngName;

}
