package com.estudo.repository;

import com.estudo.domain.DocFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FileRepository extends JpaRepository<DocFile, Long> {
}
