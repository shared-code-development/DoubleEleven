package org.miao.sha.utils;
import org.springframework.beans.BeanUtils;
import org.miao.sha.vo.TGoodsVo;
import org.miao.sha.dto.TGoodsDto;
import org.miao.sha.entity.TGoods;


/**
 *  JavaBean转换工具
 * <pre>
 *  @author heshiyuan
 *  @date  2020年11月26日 05:48:25
 * </pre>
 */
public class TGoodsConvertUtils{

    public static TGoods convert(TGoodsVo tGoodsVo){
        TGoods entity = new TGoods();
        BeanUtils.copyProperties(tGoodsVo, entity);
        return entity;
    }

    public static TGoodsDto convert(TGoods tGoods){
        TGoodsDto dto = new TGoodsDto();
        BeanUtils.copyProperties(tGoods, dto);
        return dto;
    }
}