package com.code.back.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Userorder对象", description="")
public class Userorder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "o_id", type = IdType.ID_WORKER)
    private Long oId;

    private Long uId;

    private Long rId;

    @TableField(value = "Create_time", fill = FieldFill.INSERT)
    private Date createTime;

    private Date checkinTime;

    private Date checkoutTime;

    private Date payTime;

    private Integer state;

    private Float rating;

    private String review;

    private Float totalPrice;

    private Long p1Tel;

    private String pname1;

    private Long p2Tel;

    private String pname2;

    @TableLogic
    private Integer deleted;

    private String alipayNo;


}
