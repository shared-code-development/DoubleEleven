package org.miao.sha.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.miao.sha.entity.TGoods;

/**
 * 商品表Dao
 * <pre>
 *  @author heshiyuan
 *  @date  2020年11月26日 05:48:25
 * </pre>
 */
@Mapper
public interface TGoodsDao{

    Integer insertTGoods(TGoods entity);
    
    Integer insertBatch(@Param("list") List<TGoods> list);
    
    Integer updateTGoods(TGoods entity);
    
    Integer updateBatch(@Param("list") List<TGoods> list);
    
    Integer deleteTGoods(TGoods entity);

    Integer deleteById(String goodsId);

    Integer deleteBatch(@Param("list") List<String> list);

    List<TGoods> findList(TGoods entity);

    TGoods getTGoods(TGoods entity);

    TGoods findById(String goodsId);

    /**
     * 通用单条记录查询  根据实体名称和字段名称和字段值获取唯一记录
     */
    //TGoods queryUniqueByProperty(@Param("propertyName") String propertyName, @Param("value") Object value);
}