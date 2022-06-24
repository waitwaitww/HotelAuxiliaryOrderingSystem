package com.code.back.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * ??ס?
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="HCheck对象", description="酒店签到签退时间")
public class HCheck implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "check_id", type = IdType.ID_WORKER)
    private Long checkId;

    private Long hotHId;

    private Long hId;

    private Date checkIn;

    private Date checkOut;

    private Float ratesFrom;


}
