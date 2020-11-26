package org.miao.sha.controller;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.miao.sha.service.ITUserService;
import org.miao.sha.mapper.TUserDao;
import org.miao.sha.entity.TUser;
import org.miao.sha.vo.TUserVo;
import org.miao.sha.dto.TUserDto;

/**
 * @author heshiyuan
 * @date 2020年11月26日 05:48:26
 */
@Api(tags = {"TUser"})
@RestController
@RequestMapping("/tUser")
public class TUserController {

    @Autowired
    private ITUserService tUserService;

    @ApiOperation(value="查询", notes="查询接口")
    @GetMapping
    public ResponseEntity<TUserDto> get(@RequestParam String userId){
        return new ResponseEntity(tUserService.findById(userId), HttpStatus.OK);
    }

    @ApiOperation(value="列表查询", notes="列表查询接口")
    @GetMapping(value = "/list")
    public ResponseEntity list(@RequestBody TUserVo tUserVo){
        return new ResponseEntity(tUserService.findByParam(tUserVo), HttpStatus.OK);
    }

    @ApiOperation(value="单个创建", notes="单个创建接口")
    @PostMapping
    public ResponseEntity<Boolean> create(@Validated @RequestBody TUserVo tUserVo){
        return new ResponseEntity(tUserService.create(tUserVo), HttpStatus.CREATED);
    }

    @ApiOperation(value="单个更新", notes="单个更新接口")
    @PutMapping
    public ResponseEntity<Boolean> update(@Validated @RequestBody TUserVo tUserVo){
        return new ResponseEntity(tUserService.update(tUserVo), HttpStatus.OK);
    }

    @ApiOperation(value="单个删除", notes="单个删除接口")
    @DeleteMapping
    public ResponseEntity<Boolean> delete(@PathVariable String userId){
        return new ResponseEntity(tUserService.delete(userId), HttpStatus.OK);
    }

    @ApiOperation(value="批量删除", notes="批量删除接口")
    @DeleteMapping(value = "/batch")
    public ResponseEntity<Integer> delete(@RequestParam List<String> userIdList){
        return new ResponseEntity(tUserService.delete(userIdList), HttpStatus.OK);
    }
}