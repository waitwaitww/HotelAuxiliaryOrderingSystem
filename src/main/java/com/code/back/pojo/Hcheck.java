package com.code.back.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * ??ס?
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
@ApiModel(value="Hcheck对象", description="??ס?")
public class Hcheck implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "check_id", type = IdType.ID_WORKER)
    private Long checkId;

    private Long hotHId;

    private Long hId;

    private String checkIn;

    private String checkOut;

    private Float ratesFrom;


}
