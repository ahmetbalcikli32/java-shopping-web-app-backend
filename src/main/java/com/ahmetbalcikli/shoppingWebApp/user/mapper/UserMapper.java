package com.ahmetbalcikli.shoppingWebApp.user.mapper;

import com.ahmetbalcikli.shoppingWebApp.dto.CategoryDTO;
import com.ahmetbalcikli.shoppingWebApp.entity.Category;
import com.ahmetbalcikli.shoppingWebApp.user.dto.UserDto;
import com.ahmetbalcikli.shoppingWebApp.user.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "cart.id", target = "cartId")
    UserDto convertToDTO(User user);

    @InheritInverseConfiguration(name = "convertToDTO")
    User convertToEntity(UserDto userDto);
}
