/* CodingNomads (C)2023 */
package com.codingnomads.springweb.springrestcontrollers.shortcutannotations.repostiory;

import com.codingnomads.springweb.springrestcontrollers.shortcutannotations.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}
