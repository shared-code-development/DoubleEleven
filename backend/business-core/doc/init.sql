create database seckill;
use seckill;
create table t_user(
    user_id varchar(20) not null PRIMARY key comment '主键',
    user_name varchar(100) comment '用户名',
    nick_name varchar(100) comment '昵称',
    create_time timestamp comment '创建时间',
    creator varchar(20) comment '创建者',
    update_time timestamp not null ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
    updater varchar(20) not null comment '更新者',
    version int(10) not null comment '版本号：乐观锁专用',
    is_del tinyint(1) not null default 0 comment '删除标识： 0-未删除 1-已删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists goods;
CREATE TABLE t_goods (
  goods_id varchar(20) NOT NULL PRIMARY key comment '商品id',
  price decimal(10,2) NOT NULL comment '秒杀价',
  origin_price decimal(10,2) NOT NULL comment '原价',
  count int(11) NOT NULL comment '库存',
  start_date timestamp NOT NULL comment '开始时间',
  end_date timestamp NOT NULL comment '结束时间',
      create_time timestamp comment '创建时间',
    creator varchar(20) comment '创建者',
    update_time timestamp not null ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
    updater varchar(20) not null comment '更新者',
    version int(10) not null comment '版本号：乐观锁专用',
    is_del tinyint(1) not null default 0 comment '删除标识： 0-未删除 1-已删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '商品表';

CREATE TABLE t_order (
  id bigint(20) NOT NULL PRIMARY key comment '主键',
  user_id varchar(20) NOT NULL comment '用户表主键',
  goods_id varchar(20) NOT NULL comment '商品表主键', 
    create_time timestamp comment '创建时间',
    creator varchar(20) comment '创建者',
    update_time timestamp not null ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
    updater varchar(20) not null comment '更新者',
    version int(10) not null comment '版本号：乐观锁专用',
    is_del tinyint(1) not null default 0 comment '删除标识： 0-未删除 1-已删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '订单记录表';