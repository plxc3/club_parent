package com.plxcc.admin.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackgeName: com.plxcc.admin.utils
 * @ClassName: EasyExcelListener
 * @Author: plxc
 * Date: 2020/9/2 16:26
 * project name: club_parent
 * @Version:
 * @Description:
 */
public class ExcelListener extends AnalysisEventListener {

    private List<Object> datas = new ArrayList<>();

    @Override
    public void invoke(Object obj, AnalysisContext context) {

        datas.add(obj);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        //   datas.clear();//解析结束销毁不用的资源
    }
    public List<Object> getDatas() {

        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }

    public List<Object> getDataList() {
        return datas;
    }

}