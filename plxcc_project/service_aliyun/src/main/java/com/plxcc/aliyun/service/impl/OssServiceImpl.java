package com.plxcc.aliyun.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.plxcc.aliyun.service.OssService;
import com.plxcc.aliyun.utils.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * @PackgeName: com.plxcc.aliyun.service.impl
 * @ClassName: OssServiceImpl
 * @Author: plxc
 * Date: 2020/8/7 22:42
 * project name: club_parent
 * @Version:
 * @Description:
 */
@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadAvatar(MultipartFile file) {

        //工具类获取值
        String ednpoint= ConstantPropertiesUtils.ENDPOINT;
        String accessKeyId=ConstantPropertiesUtils.KEY_ID;
        String accessKeySecret=ConstantPropertiesUtils.KEY_SERCERT;
        String bucketName=ConstantPropertiesUtils.BUCKET_NAME;

        //创建oss实例
        OSS ossClient=new OSSClientBuilder()
                .build(ednpoint,accessKeyId,accessKeySecret);

        try{
            //获取上传文件的上传流
            InputStream inputStream=file.getInputStream();

            //获取文件名称
            String filename=file.getOriginalFilename();



            //把上传之后的文件返回
            //需要吧上传到阿里云oss的路径手动拼接出来，同时添加随机数避免文件名重复而出现覆盖
            String uuid= UUID.randomUUID().toString().replaceAll("-","");
            filename=uuid+filename;

            //把文件按照日期进行分类存储
            String datePath=new DateTime().toString("yyyy/MM/dd");
            filename=datePath+"/"+filename;

            //调用oss方法实现上传
            //第一个参数 Bucket名称，第二个参数 上传的Oss的文件路径和文件名称
            //第三个参数上传文件的输入流
            ossClient.putObject(bucketName,filename,inputStream);
            ossClient.shutdown();

            String url="https://"+bucketName+"."+ednpoint+"/"+filename;
            return url;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
