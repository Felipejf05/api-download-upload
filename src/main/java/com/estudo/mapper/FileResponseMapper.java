package com.estudo.mapper;


import com.estudo.domain.DocFile;
import com.estudo.dtos.FileResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FileResponseMapper {

    @Mapping(target = "name", source = "docFile.fileName")
    @Mapping(target = "statusName", source = "docFile.statusName")
    @Mapping(target = "inputTime", source = "docFile.businessDate")
    @Mapping(target = "fileSize", source = "docFile.fileSize")
    FileResponseDto toFileResponse(DocFile docFile);

}
