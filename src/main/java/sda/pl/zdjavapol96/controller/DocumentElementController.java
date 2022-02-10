package sda.pl.zdjavapol96.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.pl.zdjavapol96.dto.DocumentElementDto;
import sda.pl.zdjavapol96.mapper.DocumentElementMapper;
import sda.pl.zdjavapol96.model.DocumentElement;
import sda.pl.zdjavapol96.service.DocumentElementService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/documentelement")
public class DocumentElementController {

    private DocumentElementService documentElementService;

    @GetMapping("")
    public List<DocumentElementDto> findAll(){
        return documentElementService.findAll().stream()
                .map(DocumentElementMapper::mapToDto)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public Optional<DocumentElement> findById(@PathVariable long id){
        return documentElementService.findById(id);
    }
    @PostMapping("")
    public ResponseEntity<DocumentElement> add(@Valid @RequestBody DocumentElementDto dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(documentElementService.add(dto));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        documentElementService.deleteById(id);
    }



}