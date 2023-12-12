package com.codingnomads.springweb.springrestcontrollers.shortcutannotations.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codingnomads.springweb.springrestcontrollers.shortcutannotations.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
