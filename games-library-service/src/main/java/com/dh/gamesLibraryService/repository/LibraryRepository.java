package com.dh.gamesLibraryService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dh.gamesLibraryService.model.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
    public List<Library> findAllByUserTag(String userTag);

}
