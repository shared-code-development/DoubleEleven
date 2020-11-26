package org.miao.sha.utils;
import org.springframework.beans.BeanUtils;
import org.miao.sha.vo.TOrderVo;
import org.miao.sha.dto.TOrderDto;
import org.miao.sha.entity.TOrder;


/**
 *  JavaBean转换工具
 * <pre>
 *  @author heshiyuan
 *  @date  2020年11月26日 05:48:25
 * </pre>
 */
public class TOrderConvertUtils{

    public static TOrder convert(TOrderVo tOrderVo){
        TOrder entity = new TOrder();
        BeanUtils.copyProperties(tOrderVo, entity);
        return entity;
    }

    public static TOrderDto convert(TOrder tOrder){
        TOrderDto dto = new TOrderDto();
        BeanUtils.copyProperties(tOrder, dto);
        return dto;
    }
}