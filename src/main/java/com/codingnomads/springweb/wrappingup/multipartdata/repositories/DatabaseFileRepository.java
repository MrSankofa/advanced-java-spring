package com.codingnomads.springweb.wrappingup.multipartdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codingnomads.springweb.wrappingup.multipartdata.models.DatabaseFile;

public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, Long> {

}
