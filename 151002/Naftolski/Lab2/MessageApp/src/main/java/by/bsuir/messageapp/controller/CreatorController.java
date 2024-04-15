package by.bsuir.messageapp.controller;

import by.bsuir.messageapp.model.request.CreatorRequestTo;
import by.bsuir.messageapp.model.response.CreatorResponseTo;
import by.bsuir.messageapp.service.CreatorService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/creators")
@Data
@RequiredArgsConstructor
public class CreatorController {
    private final CreatorService creatorService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CreatorResponseTo findById(@Valid @PathVariable("id") Long id) {
        return creatorService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CreatorResponseTo> findAll() {
        return creatorService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatorResponseTo create(@Valid @RequestBody CreatorRequestTo request) {
        return creatorService.create(request);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CreatorResponseTo update(@Valid @RequestBody CreatorRequestTo request) {
        return creatorService.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeById(@Valid @PathVariable("id") Long id) {
        creatorService.removeById(id);
    }
}
