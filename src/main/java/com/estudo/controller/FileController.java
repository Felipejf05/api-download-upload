package com.estudo.controller;

import com.estudo.config.ApiBasicResponses;
import com.estudo.dtos.FileResponseDto;
import com.estudo.dtos.ListFilesResponseDto;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@ApiBasicResponses
@RequestMapping("/v1")
public interface FileController {

    @Tag(name = "Criação dos arquivos", description = "Inserção das info do file")
    @PostMapping("/create-file")
    @ApiResponse(responseCode = "201",
            description = "Arquivo criado com sucesso",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = FileResponseDto.class)))
    ResponseEntity<FileResponseDto> createFile();

    @Tag(name = "Lista todos os arquivos", description = "Consulta que retorna uma lista de arquivos")
    @GetMapping("/list-files")
    @ApiResponse(responseCode = "200",
            description = "Arquivos disponíveis listados com sucesso",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ListFilesResponseDto.class)))
    ResponseEntity<ListFilesResponseDto> getFiles();
}
