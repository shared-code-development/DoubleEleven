package org.miao.sha.service;
import java.util.List;
import com.github.pagehelper.PageInfo;
import org.miao.sha.vo.TOrderVo;
import org.miao.sha.dto.TOrderDto;


/**
 *  业务实现接口
 * @author heshiyuan
 * @date 2020年11月26日 05:48:25
 */
public interface ITOrderService {

    /**
     * findById
     * @param id 主键
     * @return TOrderDto 实体转换对象
     */
    TOrderDto findById(Long id);

    /**
     * 理论上不应该存在此接口，所有的list返回都要做分页，方式巨型出参返回
     * findByParam
     * @param tOrderVo 请求对象
     * @return TOrderDto 实体转换对象
     */
    List<TOrderDto> findByParam(TOrderVo tOrderVo);

    /**
     * findPageListByParam
     * @param page  当前页数
     * @param limit 每页条数
     * @param sort 排序字段
     * @param tOrderVo 请求对象
     * @return TOrderDto 实体转换对象
     */
    PageInfo<List<TOrderDto>> findPageListByParam(Integer page, Integer limit, String sort, TOrderVo tOrderVo);

    /**
     * create 单体创建
     * @param tOrderVo 请求对象
     * @return Boolean 创建成功标识 true：成功 false：失败
     */
     Boolean create(TOrderVo tOrderVo);

    /**
     * create 单体创建
     * @param tOrderVoList 请求对象
     * @return TOrderDto 实体转换对象
     */
    Integer create(List<TOrderVo> tOrderVoList);

    /**
     * update 单体更新
     * @param tOrderVo 请求对象
     * @return Boolean true:更新成功， false：更新失败
     */
    Boolean update(TOrderVo tOrderVo);

    /**
     * update 单体更新
     * @param tOrderVoList 批量更新实体list
     * @return Integer 批量更新的条数
     */
    Integer updateBatch(List<TOrderVo> tOrderVoList);

    /**
     * delete 单体删除
     * @param id 主键
     * @return Boolean true:删除成功， false：删除失败
     */
     Boolean delete(Long id);

    /**
     * delete 批量删除
     * @param idList 主键
     * @return Integer 删除成功的条数
     */
    Integer delete(List<Long> idList);
}