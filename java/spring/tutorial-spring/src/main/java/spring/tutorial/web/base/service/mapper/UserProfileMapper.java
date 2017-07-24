package spring.tutorial.web.base.service.mapper;

import org.mapstruct.Mapper;
import spring.tutorial.orm.domain.UserProfile;
import spring.tutorial.web.base.service.dto.UserProfileDTO;

@Mapper(componentModel = "spring")
public interface UserProfileMapper extends EntityMapper<UserProfileDTO, UserProfile> {

}
