package shop.mtcoding.product.model.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.mtcoding.product.dto.user.JoinReqDto;
import shop.mtcoding.product.dto.user.LoginReqDto;

@Mapper
public interface UserRepository {
    public User login(LoginReqDto loginReqDto);

    public User findById(Integer id);

    public List<User> findAll();

    public int insert(JoinReqDto joinReqDto);

    public int update(User user);

    public int delete(Integer id);

}
