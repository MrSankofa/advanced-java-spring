/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.dml.introducingrepositories.crudrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {}
