/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.lifecyclecallback;

import org.springframework.data.repository.CrudRepository;

public interface PrintEntityRepository extends CrudRepository<PrintEntity, Long> {}
