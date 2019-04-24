package com.sunql.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sunql.blog.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author sunql
 * @since 2019-03-31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("设备")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName(value = "user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private Integer id;
    @ApiModelProperty("添加时间")
    private Long addTime;
    @ApiModelProperty("用户id")
    private String uid;
    @ApiModelProperty("更新时间")
    private Long updataTime;
    @ApiModelProperty("用户地址")
    private String userAddress;
    @ApiModelProperty("用户年龄")
    private Integer userAge;
    @ApiModelProperty("用户姓名")
    private String userName;
    @ApiModelProperty("用户电话")
    private Long userPhone;
    @ApiModelProperty("用户头像")
    private String userPhoto;
    @ApiModelProperty("登陆密码")
    private String userPwd;
    @ApiModelProperty("用户年龄")
    private Integer userSex;


}
