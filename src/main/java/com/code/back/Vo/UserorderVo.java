package com.code.back.Vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.code.back.pojo.Hotel;
import com.code.back.pojo.Roomtype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserorderVo {

    private Long id;

    private String  oid;

    private Date createTime;

    private Date checkinTime;

    private Date checkoutTime;

    private Date payTime;

    private float rating;

    private int state;

    private String review;

    private float totalPrice;

    private Long p1Tel;

    private String pname1;

    private Long p2Tel;

    private String pname2;

    private String rtname;

    private String breakfastTime;

    private String hname;

    private String alipayNo;

    @TableField(exist = false)
    private Hotel hotel;

    @TableField(exist = false)
    private Roomtype roomtype;
}
