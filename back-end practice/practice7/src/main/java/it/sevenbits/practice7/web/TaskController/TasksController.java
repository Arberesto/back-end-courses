package it.sevenbits.practice7.web.TaskController;

import it.sevenbits.practice7.core.Repository.Item;
import it.sevenbits.practice7.core.Repository.ItemsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

@Controller
@RequestMapping("/tasks")
public class TasksController {

    private final ItemsRepository itemsRepository;

    public TasksController(ItemsRepository newItemsRepository) {
        this.itemsRepository = newItemsRepository;
        itemsRepository.create("Do homework");
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ArrayList<Item>> getAllTasks() {
        ArrayList<Item> itemsList = itemsRepository.getAllTasks();
        URI location = UriComponentsBuilder.fromPath("/tasks/")
                .build().toUri();
        return ResponseEntity.status(HttpStatus.OK).location(location).
                contentType(MediaType.APPLICATION_JSON).body(itemsList);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Item> create(@RequestParam String text) {
        Item createdItem = itemsRepository.create(text);
        if (createdItem == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    contentType(MediaType.APPLICATION_JSON).build();
        }
        URI location = UriComponentsBuilder.fromPath("/tasks/")
                .path(String.valueOf(createdItem.getId()))
                .build().toUri();
        return ResponseEntity.status(HttpStatus.CREATED).location(location).
                contentType(MediaType.APPLICATION_JSON).body(createdItem);
    }


}
