package com.codingnomads.springweb.gettingdatafromclient.handlingmultipartdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codingnomads.springweb.gettingdatafromclient.handlingmultipartdata.models.DatabaseFile;

public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, Long> { }
