/* CodingNomads (C)2024 */
package com.codingnomads.springtest.lab.repository;

import com.codingnomads.springtest.lab.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {}
