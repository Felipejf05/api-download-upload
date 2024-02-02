package com.estudo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DocFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Column(name = "file_name")
    private String fileName;

    @JsonIgnore
    @Column(name = "status_name")
    private String statusName;

    @Column(name = "status_id")
    private Integer statusId;

    @Column(name = "business_date")
    private LocalDate businessDate;

    @JsonIgnore
    @Column(name = "start_process_time")
    private LocalDateTime startProcessTime;

    @JsonIgnore
    @Column(name = "end_process_time")
    private LocalDateTime endProcessTime;

    @JsonIgnore
    @Column(name = "file_size")
    private Long fileSize;

    @JsonIgnore
    @Column(name = "download_counter")
    private Integer downloadCounter;

    @JsonIgnore
    @Column(name = "last_download_time")
    private LocalDateTime lastDownloadTime;

    public DocFile(final String fileName, final Long fileSize, final Integer statusId, final LocalDate businessDate,
                   final LocalDateTime startProcessTime
    ) {
        this.fileName = fileName;
        this.statusId = statusId;
        this.businessDate = businessDate;
        this.startProcessTime = startProcessTime;
        this.fileSize = fileSize;

        this.endProcessTime = null;
        this.lastDownloadTime = null;
    }
}
