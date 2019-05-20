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
 * @since 2019-04-11
 */
@Data
@Builder
@Entity
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Anthology extends BaseEntity {

    private static final long serialVersionUID = 1L;

    public Anthology(Long addTime, Integer articleSize, String title, Long updataTime, String userId) {
        this.addTime = addTime;
        this.articleSize = articleSize;
        this.title = title;
        this.updataTime = updataTime;
        this.userId = userId;
    }

    public Anthology(Integer id, Long addTime, Integer articleSize, String title, Long updataTime, String userId) {
        this.id = id;
        this.addTime = addTime;
        this.articleSize = articleSize;
        this.title = title;
        this.updataTime = updataTime;
        this.userId = userId;
    }
    @Id
    @GeneratedValue
    private Integer id=0;
    @ApiModelProperty("添加时间")
    private Long addTime;
    @ApiModelProperty("文集文章数")
    private Integer articleSize;
    @ApiModelProperty("文集标题")
    private String title;
    @ApiModelProperty("更新时间")
    private Long updataTime;
    @ApiModelProperty("用户ID")
    private String userId;


}
