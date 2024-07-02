package com.tsinghuan.springbootsqlite.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@ApiModel(value = "poi上传文件")
@Data
public class PoiDataUploadFileDto {


    @ApiModelProperty("db文件")
    private MultipartFile file;

}
