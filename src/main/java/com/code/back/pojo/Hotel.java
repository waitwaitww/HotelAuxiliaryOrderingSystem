package com.code.back.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * ?Ƶ??
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
@ApiModel(value="Hotel对象", description="?Ƶ??")
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "h_id", type = IdType.ID_WORKER)
    private Long hid;

    private Long revReviewId;

    private Long roomsumId;

    private Roomsum roomsum;

    private Long hadAddressId;

    private Haddress haddress;

    private Long hchCheckId;

    private Hcheck hcheck;

    private String hname;

    private Float starRating;

    private String overview;

    private Long addressId;

    private Long checkId;

    private Long reviewId;

    private Review review;

    private List<Hphoto> hphotos;

    @TableLogic
    private Integer deleted;

    private float priceAvg;

    private float distance;

    @TableField(exist = false)
    private List<Roomtype> roomtypes;


}
