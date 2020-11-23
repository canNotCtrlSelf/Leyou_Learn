package com.cncs.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "user") //表名
public class User implements Serializable {

    @Id
    //@KeySql(useGeneratedKeys = true) //主键回显，标识主键自增
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String username;

    private Date birthday;

    private String sex;

    private String address;

    @Transient//瞬时的，不会被持久化到数据库
    private String note; //备注
}