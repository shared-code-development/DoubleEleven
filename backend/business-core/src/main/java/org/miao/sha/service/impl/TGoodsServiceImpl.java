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
import org.miao.sha.utils.TGoodsConvertUtils;
import org.miao.sha.service.ITGoodsService;
import org.miao.sha.mapper.TGoodsDao;
import org.miao.sha.entity.TGoods;
import org.miao.sha.vo.TGoodsVo;
import org.miao.sha.dto.TGoodsDto;


/**
 *  业务实现类
 * @author heshiyuan
 * @date 2020年11月26日 05:48:25
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class TGoodsServiceImpl implements ITGoodsService {

    @Autowired
    private TGoodsDao tGoodsDao;

    /**
     * findById
     * @param goodsId 商品id
     * @return TGoodsDto  对外输出对象
     */
    @Override
    public TGoodsDto findById(String goodsId){
        return TGoodsConvertUtils.convert(tGoodsDao.findById(goodsId));
    }

    /**
     * findByParam
     * @param tGoodsVo 请求对象
     * @return TGoodsConvertUtils 实体转换对象
     */
    @Override
    public List<TGoodsDto> findByParam(TGoodsVo tGoodsVo){
        List<TGoods> list = Optional.ofNullable(
                tGoodsDao.findList(TGoodsConvertUtils.convert(tGoodsVo)))
                .orElse(new ArrayList<>());
        return list.stream().map(entity -> TGoodsConvertUtils.convert(entity)).collect(Collectors.toList());
    }

    /**
     * findPageListByParam
     * @param tGoodsVo 请求对象
     * @return TGoodsDto 实体转换对象
     */
    @Override
    public PageInfo<List<TGoodsDto>> findPageListByParam(Integer page, Integer limit, String sort, TGoodsVo tGoodsVo){
        PageHelper.startPage(page, limit, sort);
        List<TGoods> list = Optional.ofNullable(
                tGoodsDao.findList(TGoodsConvertUtils.convert(tGoodsVo)))
                .orElse(new ArrayList<>());
        return new PageInfo(list.stream().map(entity -> TGoodsConvertUtils.convert(entity)).collect(Collectors.toList()));
    }

    /**
     * create 单体创建
     * @param tGoodsVo 请求对象
     * @return Boolean 创建成功标识 true：成功 false：失败
     */
    @Override
    public Boolean create(TGoodsVo tGoodsVo){
        if(1 == tGoodsDao.insertTGoods(TGoodsConvertUtils.convert(tGoodsVo))){
            return true;
        }
        return false;
    }

    /**
     * create 批量创建
     * @param tGoodsVoList 请求对象
     * @return TGoodsDto 实体转换对象
     */
    @Override
    public Integer create(List<TGoodsVo> tGoodsVoList){
        return tGoodsDao.insertBatch(
               tGoodsVoList.stream().map(entity ->
                    TGoodsConvertUtils.convert(entity)).collect(Collectors.toList()))
        ;
    }

    /**
     * update 单体更新
     * @param tGoodsVo 请求对象
     * @return Boolean true:更新成功， false：更新失败
     */
    @Override
    public Boolean update(TGoodsVo tGoodsVo){
        if(1 == tGoodsDao.updateTGoods(TGoodsConvertUtils.convert(tGoodsVo))){
            return true;
        }
        return false;
    }

    /**
     * update 单体更新
     * @param tGoodsVoList 批量更新实体list
     * @return Integer 批量更新的条数
     */
    @Override
    public Integer updateBatch(List<TGoodsVo> tGoodsVoList){
        return tGoodsDao.updateBatch(
                tGoodsVoList.stream().map(entity ->
                TGoodsConvertUtils.convert(entity)).collect(Collectors.toList()))
        ;
    }

    /**
     * delete 单体删除
     * @param goodsId 商品id
     * @return Boolean true:删除成功， false：删除失败
     */
    @Override
    public Boolean delete(String goodsId){
        if(1 == tGoodsDao.deleteById(goodsId)){
            return true;
        }
        return false;
    }

    /**
     * delete 批量删除
     * @param goodsIdList 商品id
     * @return Integer 删除成功的条数
     */
    @Override
    public Integer delete(List<String> goodsIdList){
        return tGoodsDao.deleteBatch(goodsIdList);
    }
}