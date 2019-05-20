package com.sunql.blog.entity;

import com.sunql.blog.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
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
 * @since 2019-04-04
 */
@Data
@Builder
@Entity
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Article extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @ApiModelProperty("文章id")
    private Integer id=0;
    @ApiModelProperty("创建时间")
    private Long addTime;
    @ApiModelProperty("内容")
    private String artDesc;
    @ApiModelProperty("标题")
    private String artTitle;
    @ApiModelProperty("文集")
    private Integer artType;
    @ApiModelProperty("评价条数")
    private Integer comment=0;
    @ApiModelProperty("喜欢人数")
    private Integer islike=0;
    @ApiModelProperty("阅读人数")
    private Integer isread=0;
    @ApiModelProperty("是否发布")
    private Integer isRelease;
    @ApiModelProperty("更新时间")
    private Long updataTime;
    @ApiModelProperty("作者id")
    private String userId;
    @ApiModelProperty("字节长度")
    private Integer words=0;
    @ApiModelProperty("简介")
    private String intro;
    @ApiModelProperty("类型 未发布 0  发布 1")
    private Integer type;

}
