package com.example.secondhand_springboot.mapper;

import com.example.secondhand_springboot.controller.request.CategorizePageRequest;
import com.example.secondhand_springboot.entity.Categorize;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategorizeMapper {
    List<Categorize> listByCondition(CategorizePageRequest categorizePageRequest);
    void deleteById(Integer id);

    Categorize  saveAll(String c_name);
    void   save(Categorize categorize);

    Categorize getById(Integer id);
    void updateById(Categorize  categorize);
}
