package com.example.pdp_meal.controller.feedback;

import com.example.pdp_meal.controller.base.AbstractController;
import com.example.pdp_meal.dto.feedback.FeedBackCreateDto;
import com.example.pdp_meal.service.fedback.FeedBackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Panjiyev Javohir, чт 15:46. 03.03.2022
 */

@RestController
@RequestMapping("/api/feedback/*")

public class FeedBackController extends AbstractController<FeedBackService> {
    public FeedBackController(FeedBackService service) {
        super(service);
    }

    @RequestMapping("create")
    public ResponseEntity<Integer> create(@RequestBody FeedBackCreateDto dto) {
        return ResponseEntity.ok().body(service.create(dto));
    }
}
