package com.example.pdp_meal.service.order;


import com.example.pdp_meal.dto.order.OrderCreateDto;
import com.example.pdp_meal.dto.order.OrderDto;
import com.example.pdp_meal.dto.order.OrderUpdateDto;
import com.example.pdp_meal.entity.MealOrder;
import com.example.pdp_meal.mapper.order.OrderMapper;
import com.example.pdp_meal.repository.OrderRepository;
import com.example.pdp_meal.service.AbstractService;
import com.example.pdp_meal.service.GenericCrudService;
import com.example.pdp_meal.validator.order.OrderValidator;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author Bakhodirov Azizbek, Wed 11:15 PM. 3/2/2022
 */

@Service
public class OrderService extends AbstractService<OrderRepository, OrderMapper, OrderValidator>
implements GenericCrudService<MealOrder, OrderDto, OrderCreateDto, OrderUpdateDto,Integer>
{
    protected OrderService(OrderRepository repository,
                           OrderMapper mapper,
                           OrderValidator validator) {
        super( repository, mapper, validator );
    }

    @Override
    public Integer create(OrderCreateDto createDto) {

        MealOrder mealOrder = mapper.fromCreateDto( createDto );
        repository.save( mealOrder );
        return null;
    }

    @Override
    public Void delete(Integer id) {

        repository.deleteById( id );
        return null;
    }

    @Override
    public Void update(OrderUpdateDto updateDto) {
        MealOrder mealOrder = mapper.fromUpdateDto( updateDto );
        repository.save( mealOrder );
        return null;
    }

    @Override
    public List<OrderDto> getAll() {
        List<MealOrder> all = repository.findAll();
       return mapper.toDto( all );

    }

    @Override
    public OrderDto get(Integer id) {
        return mapper.toDto(repository.findById(id).get());
    }
}
