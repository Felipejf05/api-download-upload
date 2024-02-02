package com.estudo.controller;


import com.estudo.dtos.FileResponseDto;
import com.estudo.dtos.ListFilesResponseDto;
import com.estudo.usecase.FileUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public final class FileControllerImpl implements  FileController{

    private final FileUseCase fileUseCase;

    @Override
    public ResponseEntity<FileResponseDto> createFile() {

      var create = fileUseCase.addFile();
      FileResponseDto fileResponseDto = new FileResponseDto(create);
      return new ResponseEntity<>(fileResponseDto, HttpStatus.CREATED);

    }
    @Override
    public ResponseEntity<ListFilesResponseDto> getFiles() {

        List<FileResponseDto> getFiles =fileUseCase.getFiles();
        ListFilesResponseDto listFilesResponseDto = new ListFilesResponseDto(getFiles);

        return new ResponseEntity<>(listFilesResponseDto, HttpStatus.OK);
    }
}
