package com.code.back.Vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.code.back.pojo.Hphoto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class HotelCourseVo {
    private Long id;

    private Long h_id;

    private String hname;

    private float starRating;

    private String overview;

    private String city;

    private String state;

    private String country;

    private String longitude;

    private String latitude;

    private int cityNo;

    private int countryNo;

    private String checkIn;

    private String checkOut;

    private float ratesFrom;

//    @TableField(exist = false)
    private List<Hphoto> hphotos;

    private List<String> urls;

    private photos photos;

    private int numberOfReview;

    private float ratingAvg;

    private int roomnum;
}
