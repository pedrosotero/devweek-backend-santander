package com.project.bootcamp.controller;

import com.project.bootcamp.model.dto.StockDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(dto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll(){

        StockDTO dto = new StockDTO();
        dto.setId(1L);
        dto.setName("Banco Inter");
        dto.setPrice(104.5);
        dto.setVariation(6.4);
        dto.setDate(LocalDate.now());

        StockDTO dto2 = new StockDTO();
        dto2.setId(2L);
        dto2.setName("Wiz");
        dto2.setPrice(14.5);
        dto2.setVariation(3.8);
        dto2.setDate(LocalDate.now());

        List<StockDTO> list = new ArrayList<>();
        list.add(dto);
        list.add(dto2);

        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){

        StockDTO dto = new StockDTO();
        dto.setId(1L);
        dto.setName("Banco Inter");
        dto.setPrice(104.5);
        dto.setVariation(6.4);
        dto.setDate(LocalDate.now());

        StockDTO dto2 = new StockDTO();
        dto2.setId(2L);
        dto2.setName("Wiz");
        dto2.setPrice(14.5);
        dto2.setVariation(3.8);
        dto2.setDate(LocalDate.now());

        List<StockDTO> list = new ArrayList<>();
        list.add(dto);
        list.add(dto2);

        list.removeIf(x -> !x.getId().equals(id));
        StockDTO selectedStock = list.get(0);

        return ResponseEntity.ok(selectedStock);

    }
}
