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
import org.miao.sha.utils.TUserConvertUtils;
import org.miao.sha.service.ITUserService;
import org.miao.sha.mapper.TUserDao;
import org.miao.sha.entity.TUser;
import org.miao.sha.vo.TUserVo;
import org.miao.sha.dto.TUserDto;


/**
 *  业务实现类
 * @author heshiyuan
 * @date 2020年11月26日 05:48:25
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class TUserServiceImpl implements ITUserService {

    @Autowired
    private TUserDao tUserDao;

    /**
     * findById
     * @param userId 主键
     * @return TUserDto  对外输出对象
     */
    @Override
    public TUserDto findById(String userId){
        return TUserConvertUtils.convert(tUserDao.findById(userId));
    }

    /**
     * findByParam
     * @param tUserVo 请求对象
     * @return TUserConvertUtils 实体转换对象
     */
    @Override
    public List<TUserDto> findByParam(TUserVo tUserVo){
        List<TUser> list = Optional.ofNullable(
                tUserDao.findList(TUserConvertUtils.convert(tUserVo)))
                .orElse(new ArrayList<>());
        return list.stream().map(entity -> TUserConvertUtils.convert(entity)).collect(Collectors.toList());
    }

    /**
     * findPageListByParam
     * @param tUserVo 请求对象
     * @return TUserDto 实体转换对象
     */
    @Override
    public PageInfo<List<TUserDto>> findPageListByParam(Integer page, Integer limit, String sort, TUserVo tUserVo){
        PageHelper.startPage(page, limit, sort);
        List<TUser> list = Optional.ofNullable(
                tUserDao.findList(TUserConvertUtils.convert(tUserVo)))
                .orElse(new ArrayList<>());
        return new PageInfo(list.stream().map(entity -> TUserConvertUtils.convert(entity)).collect(Collectors.toList()));
    }

    /**
     * create 单体创建
     * @param tUserVo 请求对象
     * @return Boolean 创建成功标识 true：成功 false：失败
     */
    @Override
    public Boolean create(TUserVo tUserVo){
        if(1 == tUserDao.insertTUser(TUserConvertUtils.convert(tUserVo))){
            return true;
        }
        return false;
    }

    /**
     * create 批量创建
     * @param tUserVoList 请求对象
     * @return TUserDto 实体转换对象
     */
    @Override
    public Integer create(List<TUserVo> tUserVoList){
        return tUserDao.insertBatch(
               tUserVoList.stream().map(entity ->
                    TUserConvertUtils.convert(entity)).collect(Collectors.toList()))
        ;
    }

    /**
     * update 单体更新
     * @param tUserVo 请求对象
     * @return Boolean true:更新成功， false：更新失败
     */
    @Override
    public Boolean update(TUserVo tUserVo){
        if(1 == tUserDao.updateTUser(TUserConvertUtils.convert(tUserVo))){
            return true;
        }
        return false;
    }

    /**
     * update 单体更新
     * @param tUserVoList 批量更新实体list
     * @return Integer 批量更新的条数
     */
    @Override
    public Integer updateBatch(List<TUserVo> tUserVoList){
        return tUserDao.updateBatch(
                tUserVoList.stream().map(entity ->
                TUserConvertUtils.convert(entity)).collect(Collectors.toList()))
        ;
    }

    /**
     * delete 单体删除
     * @param userId 主键
     * @return Boolean true:删除成功， false：删除失败
     */
    @Override
    public Boolean delete(String userId){
        if(1 == tUserDao.deleteById(userId)){
            return true;
        }
        return false;
    }

    /**
     * delete 批量删除
     * @param userIdList 主键
     * @return Integer 删除成功的条数
     */
    @Override
    public Integer delete(List<String> userIdList){
        return tUserDao.deleteBatch(userIdList);
    }
}