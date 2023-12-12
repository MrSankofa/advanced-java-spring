/* CodingNomads (C)2023 */
package com.codingnomads.springtest.lab.service;

import com.codingnomads.springtest.lab.entity.Movie;
import com.codingnomads.springtest.lab.repository.MovieRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
