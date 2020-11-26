package org.miao.sha.dto;
import java.util.Date;

import lombok.Data;
import lombok.ToString;
import java.io.Serializable;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
/**
 *  @author heshiyuan
 *  @date  2020年11月26日 05:48:25
 */
@Data
@ToString
public class TOrderDto implements Serializable {
    /**
     * 处理精度丢失问题
     * 主键
     */
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;
    /**
     * 处理精度丢失问题
     * 用户表主键
     */
    private String userId;
    /**
     * 处理精度丢失问题
     * 商品表主键
     */
    private String goodsId;
    /**
     * 处理精度丢失问题
     * 创建时间
     */
    private Date createTime;
    /**
     * 处理精度丢失问题
     * 创建者
     */
    private String creator;
    /**
     * 处理精度丢失问题
     * 更新时间
     */
    private Date updateTime;
    /**
     * 处理精度丢失问题
     * 更新者
     */
    private String updater;
    /**
     * 处理精度丢失问题
     * 版本号：乐观锁专用
     */
    private Integer version;
    /**
     * 处理精度丢失问题
     * 删除标识： 0-未删除 1-已删除
     */
    private Integer isDel;
}