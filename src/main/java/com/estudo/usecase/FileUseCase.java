package com.estudo.usecase;

import com.estudo.domain.DocFile;
import com.estudo.dtos.FileResponseDto;
import com.estudo.mapper.FileResponseMapper;
import com.estudo.repository.FileRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileUseCase {

    private final FileRepository fileRepository;
    private final FileResponseMapper responseMapper;

    public DocFile addFile (){

        DocFile create =  new DocFile();
        create.setFileName("felipe.txt");
        create.setStatusName("teste");
        create.setBusinessDate(LocalDate.now());
        create.setFileSize(450L);

       return fileRepository.save(create);

    }

    public List<FileResponseDto> getFiles(){

        return getFileResponseDtos(fileRepository.findAll());
    }

    @NotNull
    private List<FileResponseDto> getFileResponseDtos (List<DocFile> repositoryResponse) {
        return repositoryResponse
                .stream()
                .map(responseMapper::toFileResponse).toList();
    }

}
