package com.tom.mapper;

import com.tom.pojo.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    public List<MainMenu> getMenus();
}
