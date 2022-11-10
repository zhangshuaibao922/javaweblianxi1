package com.atguigu.fruit.dao.com.atguigu.fruit.dao.impl;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.pojo.Fruit;
import com.myssm.basedao.BaseDAO;
import com.myssm.util.StringUtil;

import java.util.List;

/**
 * @author Ricardo
 * @create 2022-11-03 15:29
 */
public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {

    @Override
    public List<Fruit> getFruitList(String keyword,Integer pageNo) {
        return super.executeQuery("select * from t_fruit where fname like ? or remark like ? limit ?,5","%"+keyword+"%","%"+keyword+"%",(pageNo-1)*5);
    }

    @Override
    public Fruit getFruitById(Integer fid) {
        return super.load("select * from t_fruit where fid=?",fid);
    }

    @Override
    public void updateFruit(Fruit fruit) {
        String sql="update t_fruit set fname=?,price=?,fcount=?,remark=? where fid=?";
        super.executeUpdate(sql,fruit.getFname(),fruit.getPrice(),fruit.getFcount(),fruit.getRemark(),fruit.getFid());

    }

    @Override
    public void delFruit(int fid) {
        super.executeUpdate("delete from t_fruit where fid=?",fid);
    }

    @Override
    public void addFruit(Fruit fruit) {
        String sql="insert into t_fruit value(0,?,?,?,?)";
        super.executeUpdate(sql,fruit.getFname(),fruit.getPrice(),fruit.getFcount(),fruit.getRemark());
    }

    @Override
    public int getFruitCount(String keyword) {
        return Integer.parseInt(String.valueOf(super.executeComplexQuery("select count(*) from t_fruit where fname like ? or remark like ?","%"+keyword+"%","%"+keyword+"%")[0]));
    }

}
