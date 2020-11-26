package org.miao.sha.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import lombok.Data;
import lombok.ToString;
/**
 * 商品表vo
 * <pre>
 *  @author heshiyuan
 *  @date  2020年11月26日 05:48:25
 * </pre>
 */
@Data
@ToString
public class TGoodsVo implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**
	 * 商品id
	 */
	private String goodsId;

	/**
	 * 秒杀价
	 */
	private BigDecimal price;

	/**
	 * 原价
	 */
	private BigDecimal originPrice;

	/**
	 * 库存
	 */
	private Integer count;

	/**
	 * 开始时间
	 */
	private Date startDate;

	/**
	 * 结束时间
	 */
	private Date endDate;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 创建者
	 */
	private String creator;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 更新者
	 */
	private String updater;

	/**
	 * 版本号：乐观锁专用
	 */
	private Integer version;

	/**
	 * 删除标识： 0-未删除 1-已删除
	 */
	private Integer isDel;

}