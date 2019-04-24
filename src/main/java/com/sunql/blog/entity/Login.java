package com.sunql.blog.entity;

import com.sunql.blog.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
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
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Login extends BaseEntity {

    private static final long serialVersionUID = 1L;
//    private Integer id;
    @ApiModelProperty("登陆ip")
    private String ipaddress;
    @ApiModelProperty("登陆状态")
    private Integer loginstate;
    @ApiModelProperty("登陆时间")
    private String logintime;
    @ApiModelProperty("退出时间")
    private String outlogintime;
    @ApiModelProperty("登陆用户")
    private String uid;
    @ApiModelProperty("登陆标识")
    private String token;


}
