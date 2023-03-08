package com.example.secondhand_springboot.service.impl;

import com.example.secondhand_springboot.entity.Collects;
import com.example.secondhand_springboot.entity.Goods;
import com.example.secondhand_springboot.entity.Orders;
import com.example.secondhand_springboot.entity.Users;
import com.example.secondhand_springboot.exception.ServiceException;
import com.example.secondhand_springboot.mapper.MineMapper;
import com.example.secondhand_springboot.service.IMineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MineService implements IMineService {
    @Autowired
    MineMapper mineMapper;

    @Override
    public Users getByName(Integer u_id) {
        return mineMapper.getByName(u_id);
}

    @Override
    public Users getMessageId(Integer u_id) {
        return mineMapper.getMessageId(u_id);
    }

    @Override
    public void update(Users users) {
        Users  u=mineMapper.MessageAll(users.getEmail());
        if(u!=null){
            if (u.getEmail().equals(users.getEmail())&u.getU_id().equals(users.getU_id())) {
                mineMapper.updateById(users);

            }else{
                throw new ServiceException("邮箱已存在，请重新输入！");
            }
        }else{
            mineMapper.updateById(users);
        }

    }

    @Override
    public List<Collects> collects_list(Integer u_id) {
        return mineMapper.collects_list(u_id);
    }

    @Override
    public List<Goods> goods_list(Integer u_id) {
        return mineMapper.goods_list(u_id);
    }

    @Override
    public Goods getGoodsId(Integer g_id) {
        return mineMapper.getGoodsId(g_id);
    }

    @Override
    public void updateByGoodsId(Goods goods) {
          mineMapper.updateByGoodsId(goods);
    }

    @Override
    public void deleteByGoodsId(Integer g_id) {
        mineMapper.deleteByGoodsId(g_id);
    }

    @Override
    public List<Orders> orders_list(Integer u_id) {
        return mineMapper.orders_list(u_id);
    }

    @Override
    public Orders getOrders(Integer o_id) {
        return mineMapper.getOrders(o_id);
    }

    @Override
    public void deleteOrders(Integer o_id) {
         mineMapper.deleteOrders(o_id);
    }

    @Override
    public void updateOrders(Orders orders) {
        orders.setO_state("交易完成");
        orders.setEnd_time(new Date());
        mineMapper.updateOrders(orders);
    }
}
