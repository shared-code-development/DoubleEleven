package org.miao.sha.vo;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.ToString;
/**
 * 订单记录表vo
 * <pre>
 *  @author heshiyuan
 *  @date  2020年11月26日 05:48:25
 * </pre>
 */
@Data
@ToString
public class TOrderVo implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 用户表主键
	 */
	private String userId;

	/**
	 * 商品表主键
	 */
	private String goodsId;

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