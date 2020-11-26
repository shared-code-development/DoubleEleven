package org.miao.sha.dto;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.ToString;
import java.io.Serializable;
/**
 *  @author heshiyuan
 *  @date  2020年11月26日 05:48:25
 */
@Data
@ToString
public class TGoodsDto implements Serializable {
    /**
     * 处理精度丢失问题
     * 商品id
     */
    private String goodsId;
    /**
     * 处理精度丢失问题
     * 秒杀价
     */
    private BigDecimal price;
    /**
     * 处理精度丢失问题
     * 原价
     */
    private BigDecimal originPrice;
    /**
     * 处理精度丢失问题
     * 库存
     */
    private Integer count;
    /**
     * 处理精度丢失问题
     * 开始时间
     */
    private Date startDate;
    /**
     * 处理精度丢失问题
     * 结束时间
     */
    private Date endDate;
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