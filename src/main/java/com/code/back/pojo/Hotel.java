package com.code.back.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
    private Long hId;

    private Long revReviewId;

    private Long roomsumId;

    private Long hadAddressId;

    private Long hchCheckId;

    private String hname;

    private Float starRating;

    private String overview;

    private Long addressId;

    private Long checkId;

    private Long reviewId;

    @TableLogic
    private Integer deleted;


}
