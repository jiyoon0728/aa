package shop.mtcoding.product.model.orders;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.mtcoding.product.dto.orders.OrdersReqDto;



@Mapper
public interface OrdersRepository {

    public int insert(Orders orders);

    public Orders findById(Integer ordersId);

    public List<OrdersReqDto> findAll(Integer userId); // userId로 어떤 구매자의 구매 상품 목록을 보여줌

    public int update(Orders orders);

    public int delete(Integer ordersId);
}
