package com.example.secondhand_springboot.service.impl;

import com.example.secondhand_springboot.controller.request.CategorizePageRequest;
import com.example.secondhand_springboot.entity.Categorize;
import com.example.secondhand_springboot.exception.ServiceException;
import com.example.secondhand_springboot.mapper.CategorizeMapper;
import com.example.secondhand_springboot.service.ICategorizeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizeService implements ICategorizeService {
    @Autowired
    CategorizeMapper categorizeMapper;

    @Override
    public Object page(CategorizePageRequest categorizePageRequest) {
        PageHelper.startPage(categorizePageRequest.getPageNum(),categorizePageRequest.getPageSize());
        List<Categorize> categorize=categorizeMapper.listByCondition(categorizePageRequest);
        return new PageInfo<>(categorize);
    }

    @Override
    public void deleteById(Integer id) {
       categorizeMapper.deleteById(id);
    }

    @Override
    public void save(Categorize categorize) {
       Categorize c=categorizeMapper.saveAll(categorize.getC_name());
            if(c!=null){
                throw new ServiceException("已存在，请重新输入！");
            }else{
                categorizeMapper.save(categorize);
        }

    }

    @Override
    public Categorize getById(Integer id) {
        return categorizeMapper.getById(id);
    }

    @Override
    public void update(Categorize categorize) {
        Categorize c=categorizeMapper.saveAll(categorize.getC_name());
        if(c!=null){
            throw new ServiceException("修改失败，物品类别已存在！");
        }else {
            categorizeMapper.updateById(categorize);
        }
    }
}
