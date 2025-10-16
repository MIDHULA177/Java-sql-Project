package com.netflixtracker.netflix_tracker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    // You can add custom query methods here if needed, e.g.:
    // List<Movie> findByTitleContaining(String title);
}
