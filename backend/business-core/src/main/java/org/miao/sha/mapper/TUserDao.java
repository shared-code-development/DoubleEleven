package org.miao.sha.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.miao.sha.entity.TUser;

/**
 * Dao
 * <pre>
 *  @author heshiyuan
 *  @date  2020年11月26日 05:48:25
 * </pre>
 */
@Mapper
public interface TUserDao{

    Integer insertTUser(TUser entity);
    
    Integer insertBatch(@Param("list") List<TUser> list);
    
    Integer updateTUser(TUser entity);
    
    Integer updateBatch(@Param("list") List<TUser> list);
    
    Integer deleteTUser(TUser entity);

    Integer deleteById(String userId);

    Integer deleteBatch(@Param("list") List<String> list);

    List<TUser> findList(TUser entity);

    TUser getTUser(TUser entity);

    TUser findById(String userId);

    /**
     * 通用单条记录查询  根据实体名称和字段名称和字段值获取唯一记录
     */
    //TUser queryUniqueByProperty(@Param("propertyName") String propertyName, @Param("value") Object value);
}