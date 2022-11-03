package com.atguigu.fruit.dao;

import com.atguigu.fruit.pojo.Fruit;

import java.util.List;

/**
 * @author Ricardo
 * @create 2022-11-03 15:27
 */
public interface FruitDAO {
    //获取所有的库存列表
    public List<Fruit> getFruitList();
}
