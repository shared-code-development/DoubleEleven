package org.miao.sha.service;
import java.util.List;
import com.github.pagehelper.PageInfo;
import org.miao.sha.vo.TGoodsVo;
import org.miao.sha.dto.TGoodsDto;


/**
 *  业务实现接口
 * @author heshiyuan
 * @date 2020年11月26日 05:48:25
 */
public interface ITGoodsService {

    /**
     * findById
     * @param goodsId 商品id
     * @return TGoodsDto 实体转换对象
     */
    TGoodsDto findById(String goodsId);

    /**
     * 理论上不应该存在此接口，所有的list返回都要做分页，方式巨型出参返回
     * findByParam
     * @param tGoodsVo 请求对象
     * @return TGoodsDto 实体转换对象
     */
    List<TGoodsDto> findByParam(TGoodsVo tGoodsVo);

    /**
     * findPageListByParam
     * @param page  当前页数
     * @param limit 每页条数
     * @param sort 排序字段
     * @param tGoodsVo 请求对象
     * @return TGoodsDto 实体转换对象
     */
    PageInfo<List<TGoodsDto>> findPageListByParam(Integer page, Integer limit, String sort, TGoodsVo tGoodsVo);

    /**
     * create 单体创建
     * @param tGoodsVo 请求对象
     * @return Boolean 创建成功标识 true：成功 false：失败
     */
     Boolean create(TGoodsVo tGoodsVo);

    /**
     * create 单体创建
     * @param tGoodsVoList 请求对象
     * @return TGoodsDto 实体转换对象
     */
    Integer create(List<TGoodsVo> tGoodsVoList);

    /**
     * update 单体更新
     * @param tGoodsVo 请求对象
     * @return Boolean true:更新成功， false：更新失败
     */
    Boolean update(TGoodsVo tGoodsVo);

    /**
     * update 单体更新
     * @param tGoodsVoList 批量更新实体list
     * @return Integer 批量更新的条数
     */
    Integer updateBatch(List<TGoodsVo> tGoodsVoList);

    /**
     * delete 单体删除
     * @param goodsId 商品id
     * @return Boolean true:删除成功， false：删除失败
     */
     Boolean delete(String goodsId);

    /**
     * delete 批量删除
     * @param goodsIdList 商品id
     * @return Integer 删除成功的条数
     */
    Integer delete(List<String> goodsIdList);
}