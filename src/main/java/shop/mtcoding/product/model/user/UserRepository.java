package shop.mtcoding.product.model.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.mtcoding.product.dto.User.JoinReqDto;
import shop.mtcoding.product.dto.User.LoginReqDto;

@Mapper
public interface UserRepository {
    public User login(LoginReqDto loginReqDto); 

    public User findById(int id);

    public List<User> findAll();

    public int insert(JoinReqDto joinReqDto);

    public int update(User user);
    
    public int delete(int id); 

}
    

   

    
    