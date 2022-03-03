package com.example.pdp_meal.service.fedback;

import com.example.pdp_meal.dto.feedback.FeedBackCreateDto;
import com.example.pdp_meal.dto.feedback.FeedBackDto;
import com.example.pdp_meal.dto.feedback.FeedBackUpdateDto;
import com.example.pdp_meal.entity.FeedBack;
import com.example.pdp_meal.enums.FeedBackType;
import com.example.pdp_meal.mapper.FeedBackMapper;
import com.example.pdp_meal.repository.FeedBackRepository;
import com.example.pdp_meal.service.AbstractService;
import com.example.pdp_meal.service.GenericCrudService;
import com.example.pdp_meal.validator.feedback.FeedBackValidator;

import java.util.List;

/**
 * @author Panjiyev Javohir, чт 14:47. 03.03.2022
 */
public class FedBackService extends AbstractService<FeedBackRepository, FeedBackMapper, FeedBackValidator>
        implements GenericCrudService<FeedBack, FeedBackDto, FeedBackCreateDto, FeedBackUpdateDto, Integer> {

    private final FeedBackType feedBackType;

    protected FedBackService(FeedBackRepository repository,
                             FeedBackMapper mapper,
                             FeedBackValidator validator, FeedBackType feedBackType) {
        super(repository, mapper, validator);
        this.feedBackType = feedBackType;
    }


    @Override
    public Integer create(FeedBackCreateDto createDto) {
        return null;
    }

    @Override
    public Void delete(Integer id) {
        return null;
    }

    @Override
    public Void update(FeedBackUpdateDto updateDto) {
        return null;
    }

    @Override
    public List<FeedBackDto> getAll() {
        return null;
    }

    @Override
    public FeedBackDto get(Integer id) {
        return null;
    }
}
