package com.leyou.httpdemo.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    //@KeySql(useGeneratedKeys = true) //主键回显，标识主键自增
    private Integer id;

    private String username;

    private Date birthday;

    private String sex;

    private String address;

    private String note; //备注
}
