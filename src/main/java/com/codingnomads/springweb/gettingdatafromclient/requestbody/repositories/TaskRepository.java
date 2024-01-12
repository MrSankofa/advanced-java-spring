/* CodingNomads (C)2024 */
package com.codingnomads.springweb.gettingdatafromclient.requestbody.repositories;

import com.codingnomads.springweb.gettingdatafromclient.requestbody.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}
