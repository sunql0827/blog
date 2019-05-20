package com.sunql.blog.entity;

import com.sunql.blog.base.BaseEntity;
import java.sql.Blob;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * <p>
 * 
 * </p>
 *
 * @author sunql
 * @since 2019-04-27
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Banner extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Integer id=0;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("图片路径")
    private String imgurl;
    @ApiModelProperty("添加时间")
    private Long addTime;
    @ApiModelProperty("更新时间")
    private Long updataTime;
    @ApiModelProperty("用户id")
    private String uid;
    @ApiModelProperty("类型")
    private Integer type;
    @ApiModelProperty("跳转路径")
    private String href;


}
