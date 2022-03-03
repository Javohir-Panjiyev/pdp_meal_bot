package com.example.pdp_meal.controller.feedback;

import com.example.pdp_meal.controller.base.AbstractController;
import com.example.pdp_meal.dto.feedback.FeedBackCreateDto;
import com.example.pdp_meal.dto.feedback.FeedBackDto;
import com.example.pdp_meal.dto.feedback.FeedBackUpdateDto;
import com.example.pdp_meal.exception.NotFoundException;
import com.example.pdp_meal.service.fedback.FeedBackService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class FeedbackController  extends AbstractController<FeedBackService>{


    public FeedbackController(FeedBackService service) {
        super(service);
    }


    @GetMapping
    public HttpEntity<?> getFeedBacks() {
        List<FeedBackDto> feedBacks = service.getAll();
        return ResponseEntity.ok( feedBacks );

    }

    @GetMapping("/{id}")
    public HttpEntity<?> getFeedBack(@PathVariable Integer id) {
        try {
            FeedBackDto feedBackDto = service.get( id );
            return ResponseEntity.ok( feedBackDto );
        } catch (NotFoundException e) {
            return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( e.getMessage() );
        }
    }
    @PostMapping
    public ResponseEntity<Integer> addFeedBack(@RequestBody FeedBackCreateDto createDto){
        Integer id = service.create( createDto );
        return new ResponseEntity<>( id,HttpStatus.OK );

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeedBack(@PathVariable Integer id){
        service.delete( id );
        return new ResponseEntity<>( null,HttpStatus.OK );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>updateFeedBack(@PathVariable(name = "id") Integer id,@RequestBody FeedBackUpdateDto feedBackUpdateDto){

        return new ResponseEntity<>(service.update(feedBackUpdateDto), HttpStatus.OK);


    }
}
