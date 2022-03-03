package com.example.pdp_meal.dto.order;

import com.example.pdp_meal.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto extends GenericDto {


    private Integer userId;

    private Integer mealId;

    private Instant createDate = Instant.now();
}
