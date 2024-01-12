/* CodingNomads (C)2024 */
package com.codingnomads.springweb.wrappingup.multipartdata.repositories;

import com.codingnomads.springweb.wrappingup.multipartdata.models.DatabaseFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, Long> {}
