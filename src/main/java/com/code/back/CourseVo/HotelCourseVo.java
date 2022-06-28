package com.code.back.CourseVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelCourseVo {
    private Long id;

    private String hname;

    private float star_rating;

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

    private List<String> url;

    private int numberOfReview;

    private float ratingAvg;

    private int roomnum;
}
