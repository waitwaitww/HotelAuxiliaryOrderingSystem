package com.code.back.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * ????ͳ???
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Roomsum对象", description="酒店余量")
public class Roomsum implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "roomsum_id", type = IdType.ID_WORKER)
    private Long roomsumId;

    private Long hotHId;

    private Long hId;

    private Integer roomnum;


}
