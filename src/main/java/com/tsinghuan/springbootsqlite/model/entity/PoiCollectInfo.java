package com.tsinghuan.springbootsqlite.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@ApiModel(value = "poi收集信息")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("poi_collect_info")
public class PoiCollectInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "生产线id")
    @TableField(value = "name")
    private String name;

    @ApiModelProperty(value = "经度")
    @TableField(value = "lon")
    private Double lon;

    @ApiModelProperty(value = "纬度")
    @TableField(value = "lat")
    private Double lat;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time")
    private String createTime;
}
