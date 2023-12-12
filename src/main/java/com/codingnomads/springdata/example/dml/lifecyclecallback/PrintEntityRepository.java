/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.dml.lifecyclecallback;

import org.springframework.data.repository.CrudRepository;

public interface PrintEntityRepository extends CrudRepository<PrintEntity, Long> {}
