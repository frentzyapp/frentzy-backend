package com.frentzy.backend.item;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemRepository repository;

    private final ItemResourceAssembler assembler;



    // Constructor
    ItemController(ItemRepository repository, ItemResourceAssembler assembler){
        this.repository = repository;
        this.assembler = assembler;

    }

    /*
    @GetMapping("/")
    List<Item> all(){
        System.out.println(repository.findAll());
        return repository.findAll();
    }
    */

    //Hateos, much more recommended as it conforms to REST standard
    /*@GetMapping("/{id}")
    Resource<Item> getItem(@PathVariable long id){
        Item item = repository.findById(id).orElseThrow(()-> new ItemNotFoundException(id));
        return new Resource<Item>(item,
                linkTo(methodOn(ItemController.class).getItem(id)).withSelfRel(),
                linkTo(methodOn(ItemController.class).getAll()).withRel("item"));

    }


    @GetMapping("/")
    Resources<Resource<Item>> getAll() {

        List<Resource<Item>> items = repository.findAll().stream()
                .map(item -> new Resource<>(item,
                linkTo(methodOn(ItemController.class).getItem(item.getId())).withSelfRel(),
                linkTo(methodOn(ItemController.class).getAll()).withRel("item"))).collect(Collectors.toList());

        return new Resources<>(items,linkTo(methodOn(ItemController.class).getAll()).withSelfRel());

    }

     */

    // Same as above two methods, but uses the resource assembler, and therefore, less code to type
    @GetMapping("/{id}")
    Resource<Item> getItem(@PathVariable long id) {
        Item item = repository.findById(id).orElseThrow(()-> new ItemNotFoundException(id));

        return assembler.toResource(item);
    }

    @GetMapping("/")
    Resources<Resource<Item>> getAll() {

        List<Resource<Item>> items = repository.findAll().stream()
                .map(assembler::toResource).collect(Collectors.toList());

        return new Resources<>(items,linkTo(methodOn(ItemController.class).getAll()).withSelfRel());

    }

}
