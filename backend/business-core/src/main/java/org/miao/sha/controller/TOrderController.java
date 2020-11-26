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
import org.miao.sha.service.ITOrderService;
import org.miao.sha.mapper.TOrderDao;
import org.miao.sha.entity.TOrder;
import org.miao.sha.vo.TOrderVo;
import org.miao.sha.dto.TOrderDto;

/**
 * @author heshiyuan
 * @date 2020年11月26日 05:48:25
 */
@Api(tags = {"TOrder"})
@RestController
@RequestMapping("/tOrder")
public class TOrderController {

    @Autowired
    private ITOrderService tOrderService;

    @ApiOperation(value="查询", notes="查询接口")
    @GetMapping
    public ResponseEntity<TOrderDto> get(@RequestParam Long id){
        return new ResponseEntity(tOrderService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value="列表查询", notes="列表查询接口")
    @GetMapping(value = "/list")
    public ResponseEntity list(@RequestBody TOrderVo tOrderVo){
        return new ResponseEntity(tOrderService.findByParam(tOrderVo), HttpStatus.OK);
    }

    @ApiOperation(value="单个创建", notes="单个创建接口")
    @PostMapping
    public ResponseEntity<Boolean> create(@Validated @RequestBody TOrderVo tOrderVo){
        return new ResponseEntity(tOrderService.create(tOrderVo), HttpStatus.CREATED);
    }

    @ApiOperation(value="单个更新", notes="单个更新接口")
    @PutMapping
    public ResponseEntity<Boolean> update(@Validated @RequestBody TOrderVo tOrderVo){
        return new ResponseEntity(tOrderService.update(tOrderVo), HttpStatus.OK);
    }

    @ApiOperation(value="单个删除", notes="单个删除接口")
    @DeleteMapping
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity(tOrderService.delete(id), HttpStatus.OK);
    }

    @ApiOperation(value="批量删除", notes="批量删除接口")
    @DeleteMapping(value = "/batch")
    public ResponseEntity<Integer> delete(@RequestParam List<Long> idList){
        return new ResponseEntity(tOrderService.delete(idList), HttpStatus.OK);
    }
}