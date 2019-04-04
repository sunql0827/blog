package com.sunql.blog.entity;

import com.sunql.blog.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author sunql
 * @since 2019-04-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Article extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long addTime;

    private String artDesc;

    private String artTitle;

    private Integer artType;

    private Integer comment;

    private Integer islike;

    private Integer isread;

    private Integer isRelease;

    private Long updataTime;

    private String userId;

    private Integer words;

    private String intro;


}
