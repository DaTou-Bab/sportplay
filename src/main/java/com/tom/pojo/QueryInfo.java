package com.tom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QueryInfo {
    private String query;   //查询信息 username
    private int pageNum = 1;   // 当前页
    private int pageSize=1;    //  每页最大
}
