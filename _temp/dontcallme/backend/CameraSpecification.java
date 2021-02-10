package com.practice.dontcallme.backend;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class CameraSpecification {

    @Id
    private String company_model = "com_practice";

    @NotBlank
    private String price_currency;

    // 위의 price_currency 에 종속되게 어떻게?
//    @Temporal(TemporalType.TIMESTAMP)
//    @LastModifiedDate
//    @NotBlank
//    private Date updatedAtForPrice;


}