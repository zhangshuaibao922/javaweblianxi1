package com.atguigu.fruit.dao;

import com.atguigu.fruit.pojo.Fruit;

import java.util.List;

/**
 * @author Ricardo
 * @create 2022-11-03 15:27
 */
public interface FruitDAO {
    //获取所有的库存列表
    public List<Fruit> getFruitList(String keyword,Integer pageNo);

    //根据fid获取特定的fruit
    public Fruit getFruitById(Integer fid);
    //修改指定的库存记录
    void updateFruit(Fruit fruit);
    //根据fid删除对应库存记录
    void delFruit(int fid);
    //添加一条记录
    void addFruit(Fruit fruit);
    //查询总记录条数的方法
    int getFruitCount(String keyword);
}
