package com.cncs.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private Integer id;

    private String username;

    private Date birthday;

    private String sex;

    private String address;

    private String note; //备注
}
