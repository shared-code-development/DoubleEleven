package org.miao.sha.service;
import java.util.List;
import com.github.pagehelper.PageInfo;
import org.miao.sha.vo.TUserVo;
import org.miao.sha.dto.TUserDto;


/**
 *  业务实现接口
 * @author heshiyuan
 * @date 2020年11月26日 05:48:25
 */
public interface ITUserService {

    /**
     * findById
     * @param userId 主键
     * @return TUserDto 实体转换对象
     */
    TUserDto findById(String userId);

    /**
     * 理论上不应该存在此接口，所有的list返回都要做分页，方式巨型出参返回
     * findByParam
     * @param tUserVo 请求对象
     * @return TUserDto 实体转换对象
     */
    List<TUserDto> findByParam(TUserVo tUserVo);

    /**
     * findPageListByParam
     * @param page  当前页数
     * @param limit 每页条数
     * @param sort 排序字段
     * @param tUserVo 请求对象
     * @return TUserDto 实体转换对象
     */
    PageInfo<List<TUserDto>> findPageListByParam(Integer page, Integer limit, String sort, TUserVo tUserVo);

    /**
     * create 单体创建
     * @param tUserVo 请求对象
     * @return Boolean 创建成功标识 true：成功 false：失败
     */
     Boolean create(TUserVo tUserVo);

    /**
     * create 单体创建
     * @param tUserVoList 请求对象
     * @return TUserDto 实体转换对象
     */
    Integer create(List<TUserVo> tUserVoList);

    /**
     * update 单体更新
     * @param tUserVo 请求对象
     * @return Boolean true:更新成功， false：更新失败
     */
    Boolean update(TUserVo tUserVo);

    /**
     * update 单体更新
     * @param tUserVoList 批量更新实体list
     * @return Integer 批量更新的条数
     */
    Integer updateBatch(List<TUserVo> tUserVoList);

    /**
     * delete 单体删除
     * @param userId 主键
     * @return Boolean true:删除成功， false：删除失败
     */
     Boolean delete(String userId);

    /**
     * delete 批量删除
     * @param userIdList 主键
     * @return Integer 删除成功的条数
     */
    Integer delete(List<String> userIdList);
}