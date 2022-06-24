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
 * ͼƬ?
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Photo对象", description="酒店图片")
public class Photo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "photo_id", type = IdType.ID_WORKER)
    private Long photoId;

    private Long hotHId;

    private Long hId;

    private String url;


}
