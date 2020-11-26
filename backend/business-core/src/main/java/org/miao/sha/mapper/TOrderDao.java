package org.miao.sha.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.miao.sha.entity.TOrder;

/**
 * 订单记录表Dao
 * <pre>
 *  @author heshiyuan
 *  @date  2020年11月26日 05:48:25
 * </pre>
 */
@Mapper
public interface TOrderDao{

    Integer insertTOrder(TOrder entity);
    
    Integer insertBatch(@Param("list") List<TOrder> list);
    
    Integer updateTOrder(TOrder entity);
    
    Integer updateBatch(@Param("list") List<TOrder> list);
    
    Integer deleteTOrder(TOrder entity);

    Integer deleteById(Long id);

    Integer deleteBatch(@Param("list") List<Long> list);

    List<TOrder> findList(TOrder entity);

    TOrder getTOrder(TOrder entity);

    TOrder findById(Long id);

    /**
     * 通用单条记录查询  根据实体名称和字段名称和字段值获取唯一记录
     */
    //TOrder queryUniqueByProperty(@Param("propertyName") String propertyName, @Param("value") Object value);
}