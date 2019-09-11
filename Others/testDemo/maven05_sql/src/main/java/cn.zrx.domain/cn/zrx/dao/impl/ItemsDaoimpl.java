package cn.zrx.domain.cn.zrx.dao.impl;

import cn.zrx.domain.Items;
import cn.zrx.domain.cn.zrx.dao.ItemsDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemsDaoimpl implements ItemsDao {

    public List<Items> findAll() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");

        final Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ichiwan?serverTimezone=UTC","root","123456");

        final PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,name FROM entries");

        final ResultSet resultSet = preparedStatement.executeQuery();

        List<Items> list = new ArrayList<Items>();

        while (resultSet.next()){
            Items items = new Items();
            items.setId(resultSet.getInt("id"));
            items.setName(resultSet.getString("name"));

            list.add(items);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();


        return list;
    }
}
