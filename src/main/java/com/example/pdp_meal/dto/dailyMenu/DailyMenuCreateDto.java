package com.example.pdp_meal.dto.dailyMenu;

import com.example.pdp_meal.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DailyMenuCreateDto implements BaseDto {

    private Integer mealId;
    private Instant date;
}
