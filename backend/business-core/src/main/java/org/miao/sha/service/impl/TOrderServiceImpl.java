package org.miao.sha.service.impl;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.miao.sha.utils.TOrderConvertUtils;
import org.miao.sha.service.ITOrderService;
import org.miao.sha.mapper.TOrderDao;
import org.miao.sha.entity.TOrder;
import org.miao.sha.vo.TOrderVo;
import org.miao.sha.dto.TOrderDto;


/**
 *  业务实现类
 * @author heshiyuan
 * @date 2020年11月26日 05:48:25
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class TOrderServiceImpl implements ITOrderService {

    @Autowired
    private TOrderDao tOrderDao;

    /**
     * findById
     * @param id 主键
     * @return TOrderDto  对外输出对象
     */
    @Override
    public TOrderDto findById(Long id){
        return TOrderConvertUtils.convert(tOrderDao.findById(id));
    }

    /**
     * findByParam
     * @param tOrderVo 请求对象
     * @return TOrderConvertUtils 实体转换对象
     */
    @Override
    public List<TOrderDto> findByParam(TOrderVo tOrderVo){
        List<TOrder> list = Optional.ofNullable(
                tOrderDao.findList(TOrderConvertUtils.convert(tOrderVo)))
                .orElse(new ArrayList<>());
        return list.stream().map(entity -> TOrderConvertUtils.convert(entity)).collect(Collectors.toList());
    }

    /**
     * findPageListByParam
     * @param tOrderVo 请求对象
     * @return TOrderDto 实体转换对象
     */
    @Override
    public PageInfo<List<TOrderDto>> findPageListByParam(Integer page, Integer limit, String sort, TOrderVo tOrderVo){
        PageHelper.startPage(page, limit, sort);
        List<TOrder> list = Optional.ofNullable(
                tOrderDao.findList(TOrderConvertUtils.convert(tOrderVo)))
                .orElse(new ArrayList<>());
        return new PageInfo(list.stream().map(entity -> TOrderConvertUtils.convert(entity)).collect(Collectors.toList()));
    }

    /**
     * create 单体创建
     * @param tOrderVo 请求对象
     * @return Boolean 创建成功标识 true：成功 false：失败
     */
    @Override
    public Boolean create(TOrderVo tOrderVo){
        if(1 == tOrderDao.insertTOrder(TOrderConvertUtils.convert(tOrderVo))){
            return true;
        }
        return false;
    }

    /**
     * create 批量创建
     * @param tOrderVoList 请求对象
     * @return TOrderDto 实体转换对象
     */
    @Override
    public Integer create(List<TOrderVo> tOrderVoList){
        return tOrderDao.insertBatch(
               tOrderVoList.stream().map(entity ->
                    TOrderConvertUtils.convert(entity)).collect(Collectors.toList()))
        ;
    }

    /**
     * update 单体更新
     * @param tOrderVo 请求对象
     * @return Boolean true:更新成功， false：更新失败
     */
    @Override
    public Boolean update(TOrderVo tOrderVo){
        if(1 == tOrderDao.updateTOrder(TOrderConvertUtils.convert(tOrderVo))){
            return true;
        }
        return false;
    }

    /**
     * update 单体更新
     * @param tOrderVoList 批量更新实体list
     * @return Integer 批量更新的条数
     */
    @Override
    public Integer updateBatch(List<TOrderVo> tOrderVoList){
        return tOrderDao.updateBatch(
                tOrderVoList.stream().map(entity ->
                TOrderConvertUtils.convert(entity)).collect(Collectors.toList()))
        ;
    }

    /**
     * delete 单体删除
     * @param id 主键
     * @return Boolean true:删除成功， false：删除失败
     */
    @Override
    public Boolean delete(Long id){
        if(1 == tOrderDao.deleteById(id)){
            return true;
        }
        return false;
    }

    /**
     * delete 批量删除
     * @param idList 主键
     * @return Integer 删除成功的条数
     */
    @Override
    public Integer delete(List<Long> idList){
        return tOrderDao.deleteBatch(idList);
    }
}