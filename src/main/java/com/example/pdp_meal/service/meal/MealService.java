package com.example.pdp_meal.service.meal;

import com.example.pdp_meal.dto.meal.MealCreateDto;
import com.example.pdp_meal.dto.meal.MealDto;
import com.example.pdp_meal.dto.meal.MealUpdateDto;
import com.example.pdp_meal.entity.Meal;
import com.example.pdp_meal.mapper.MealMapper;
import com.example.pdp_meal.repository.MealRepository;
import com.example.pdp_meal.service.AbstractService;
import com.example.pdp_meal.service.GenericCrudService;
import com.example.pdp_meal.validator.meal.MealValidator;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bekpulatov Shoxruh, Wed 11:15 PM. 3/2/2022
 */

@Service
public class MealService extends AbstractService<MealRepository, MealMapper, MealValidator>
        implements GenericCrudService<Meal, MealDto, MealCreateDto, MealUpdateDto, Integer> {

    protected MealService(
            MealRepository repository,
            MealMapper mapper,
            MealValidator validator) {
        super(repository, mapper, validator);
    }


    @Override
    public Integer create(MealCreateDto createDto) {
        return null;
    }

    @Override
    public Void delete(Integer id) {
        return null;
    }

    @Override
    public Void update(MealUpdateDto updateDto) {
        return null;
    }

    @Override
    public List<MealDto> getAll() {
        return null;
    }

    @Override
    public MealDto get(Integer id) {
        return null;
    }
}
