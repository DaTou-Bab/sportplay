package com.tom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

//主导航
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainMenu {
    private int id;
    private String title;
    private String path;
    private List<SubMenu> sList;


    public MainMenu(String title, String path, List<SubMenu> sList) {
        this.title = title;
        this.path = path;
        this.sList = sList;
    }
}
