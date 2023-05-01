package shop.mtcoding.product.model.orders;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface OrdersRepository {

    public int insert(Orders orders);

   public Orders findById(Integer ordersId);

   public List<Orders> findAll();

   public int update(Orders orders);

   public int delete(Integer ordersId);
}


 

   