/* CodingNomads (C)2023 */
package com.codingnomads.springweb.gettingdatafromclient.handlingmultipartdata.repositories;

import com.codingnomads.springweb.gettingdatafromclient.handlingmultipartdata.models.DatabaseFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, Long> {}
