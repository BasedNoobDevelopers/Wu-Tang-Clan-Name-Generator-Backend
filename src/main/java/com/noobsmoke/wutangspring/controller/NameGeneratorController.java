package com.noobsmoke.wutangspring.controller;

import com.noobsmoke.wutangspring.dto.NameInputRequest;
import com.noobsmoke.wutangspring.dto.RandomNameResponseDTO;
import com.noobsmoke.wutangspring.service.NameGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/generator")
@AllArgsConstructor
public class NameGeneratorController {

    private final NameGeneratorService nameGeneratorService;

    @PostMapping("/random")
    public ResponseEntity<RandomNameResponseDTO> getRandomName(@RequestBody NameInputRequest nameInputRequest) {
        return ResponseEntity.ok(nameGeneratorService.generateNewName(nameInputRequest));
    }

}
