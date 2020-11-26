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
import org.miao.sha.service.ITGoodsService;
import org.miao.sha.mapper.TGoodsDao;
import org.miao.sha.entity.TGoods;
import org.miao.sha.vo.TGoodsVo;
import org.miao.sha.dto.TGoodsDto;

/**
 * @author heshiyuan
 * @date 2020年11月26日 05:48:25
 */
@Api(tags = {"TGoods"})
@RestController
@RequestMapping("/tGoods")
public class TGoodsController {

    @Autowired
    private ITGoodsService tGoodsService;

    @ApiOperation(value="查询", notes="查询接口")
    @GetMapping
    public ResponseEntity<TGoodsDto> get(@RequestParam String goodsId){
        return new ResponseEntity(tGoodsService.findById(goodsId), HttpStatus.OK);
    }

    @ApiOperation(value="列表查询", notes="列表查询接口")
    @GetMapping(value = "/list")
    public ResponseEntity list(@RequestBody TGoodsVo tGoodsVo){
        return new ResponseEntity(tGoodsService.findByParam(tGoodsVo), HttpStatus.OK);
    }

    @ApiOperation(value="单个创建", notes="单个创建接口")
    @PostMapping
    public ResponseEntity<Boolean> create(@Validated @RequestBody TGoodsVo tGoodsVo){
        return new ResponseEntity(tGoodsService.create(tGoodsVo), HttpStatus.CREATED);
    }

    @ApiOperation(value="单个更新", notes="单个更新接口")
    @PutMapping
    public ResponseEntity<Boolean> update(@Validated @RequestBody TGoodsVo tGoodsVo){
        return new ResponseEntity(tGoodsService.update(tGoodsVo), HttpStatus.OK);
    }

    @ApiOperation(value="单个删除", notes="单个删除接口")
    @DeleteMapping
    public ResponseEntity<Boolean> delete(@PathVariable String goodsId){
        return new ResponseEntity(tGoodsService.delete(goodsId), HttpStatus.OK);
    }

    @ApiOperation(value="批量删除", notes="批量删除接口")
    @DeleteMapping(value = "/batch")
    public ResponseEntity<Integer> delete(@RequestParam List<String> goodsIdList){
        return new ResponseEntity(tGoodsService.delete(goodsIdList), HttpStatus.OK);
    }
}