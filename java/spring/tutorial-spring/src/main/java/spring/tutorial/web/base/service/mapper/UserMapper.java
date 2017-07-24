package spring.tutorial.web.base.service.mapper;

import org.mapstruct.Mapper;
import spring.tutorial.orm.domain.User;
import spring.tutorial.web.base.service.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {

}
