package com.sunql.blog.entity;

import com.sunql.blog.base.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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

    private Integer id;

    private Long addTime;

    private Integer articleSize;

    private String title;

    private Long updataTime;

    private String userId;


}
