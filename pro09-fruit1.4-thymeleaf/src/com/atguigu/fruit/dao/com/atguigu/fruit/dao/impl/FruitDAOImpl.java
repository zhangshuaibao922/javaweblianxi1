package com.atguigu.fruit.dao.com.atguigu.fruit.dao.impl;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.fruit.pojo.com.atguigu.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @author Ricardo
 * @create 2022-11-03 15:29
 */
public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {

    @Override
    public List<Fruit> getFruitList() {
        return super.executeQuery("select * from t_fruit");
    }
}
