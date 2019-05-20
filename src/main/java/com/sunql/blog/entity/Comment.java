package com.sunql.blog.entity;

import com.sunql.blog.base.BaseEntity;
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
public class Comment extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Integer id=0;
    @ApiModelProperty("评论内容")
    private String content;
    @ApiModelProperty("评论用户")
    private String uid;
    @ApiModelProperty("文章作者")
    private String author;
    @ApiModelProperty("文章id")
    private Integer artId;
    @ApiModelProperty("添加时间")
    private Long addTime;


}
