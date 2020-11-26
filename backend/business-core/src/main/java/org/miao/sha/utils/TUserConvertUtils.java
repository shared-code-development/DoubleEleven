package org.miao.sha.utils;
import org.springframework.beans.BeanUtils;
import org.miao.sha.vo.TUserVo;
import org.miao.sha.dto.TUserDto;
import org.miao.sha.entity.TUser;


/**
 *  JavaBean转换工具
 * <pre>
 *  @author heshiyuan
 *  @date  2020年11月26日 05:48:25
 * </pre>
 */
public class TUserConvertUtils{

    public static TUser convert(TUserVo tUserVo){
        TUser entity = new TUser();
        BeanUtils.copyProperties(tUserVo, entity);
        return entity;
    }

    public static TUserDto convert(TUser tUser){
        TUserDto dto = new TUserDto();
        BeanUtils.copyProperties(tUser, dto);
        return dto;
    }
}