package com.tsinghuan.springbootsqlite.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tsinghuan.springbootsqlite.model.dto.PoiDataUploadFileDto;
import com.tsinghuan.springbootsqlite.model.entity.PoiCollectInfo;
import com.tsinghuan.springbootsqlite.model.entity.PoiOriginalInfo;
import com.tsinghuan.springbootsqlite.service.IPoiCollectInfo2Service;
import com.tsinghuan.springbootsqlite.service.IPoiCollectInfoService;
import com.tsinghuan.springbootsqlite.service.IPoiOriginalInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.FileSystems;
import java.util.List;

@Slf4j
@Api(tags = "poi数据")
@RestController
@RequestMapping("/poiData")
public class PoiDataController {

    @Autowired
    IPoiCollectInfoService poiCollectInfoService;

    @Autowired
    IPoiOriginalInfoService poiOriginalInfoService;

    @Autowired
    IPoiCollectInfo2Service poiCollectInfo2Service;

    @ApiOperation(value = "-db1-分页列表", notes = "-列表")
    @GetMapping(value = "/list")
    public IPage<PoiCollectInfo> queryList() {
        return poiCollectInfoService.page(new Page<PoiCollectInfo>(1, 10), null);
    }

    @ApiOperation(value = "-db1-列表", notes = "-列表955")
    @GetMapping(value = "/list45")
    public IPage<PoiOriginalInfo> queryList665() {
        return poiOriginalInfoService.page(new Page<PoiOriginalInfo>(1, 10), null);
    }

    @ApiOperation(value = "-db2-列表", notes = "-列表")
    @GetMapping(value = "/list2")
    public List<PoiCollectInfo> queryList2() {
        return poiCollectInfo2Service.list();
    }

    @ApiOperation(value = "-上传文件-db2数据同步至db1", notes = "-上传文件-db2数据同步至db1")
    @PostMapping(value = "/uploadFile")
    public boolean uploadFile(PoiDataUploadFileDto dto) {
        try {

            byte[] bytes = dto.getFile().getBytes();

            //获取当前项目目录
            String property = System.getProperty("user.dir");
            //获取当前操作系统分隔符
            String separator = FileSystems.getDefault().getSeparator();
            //文件路径
            String fileUrl = property + separator + "sqlite3" + separator + "huanbaoducha_db2.db";

            //保存上传的文件路径
            File uploadedFile = new File(fileUrl);
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
            stream.write(bytes);

            List<PoiCollectInfo> list = poiCollectInfo2Service.list();
            for (PoiCollectInfo tableTest : list) {
                System.out.println(tableTest);
            }

            //文件制空
            bytes = new byte[0];
            uploadedFile = new File(fileUrl);
            stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
            stream.write(bytes);
            stream.close();
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
        return true;
    }

}
