package com.estudo.dtos;

import com.estudo.domain.DocFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileResponseDto {

    private String name;
    private String statusName;
    private LocalDate inputTime;
    private Long fileSize;

    public FileResponseDto(DocFile create) {
        this.name = create.getFileName();
        this.statusName = create.getStatusName();
        this.inputTime = create.getBusinessDate();
        this.fileSize = create.getFileSize();
    }
}
