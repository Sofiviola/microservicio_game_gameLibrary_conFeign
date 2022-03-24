package com.dh.gamesLibraryService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.gamesLibraryService.model.Library;
import com.dh.gamesLibraryService.model.dto.GameWS;
import com.dh.gamesLibraryService.model.dto.LibraryWS;
import com.dh.gamesLibraryService.repository.GameFeignRepository;
import com.dh.gamesLibraryService.repository.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService {

    private LibraryRepository libraryRepository;
    
    private GameFeignRepository gameFeignRepository;
    
    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository, GameFeignRepository gameFeignRepository) {
        this.libraryRepository=libraryRepository;
        this.gameFeignRepository=gameFeignRepository;
    }
    @Override
    public LibraryWS getUserLibrary(String userTag) {
        // TODO Auto-generated method stub
        List<Library> libraryList = libraryRepository.findAllByUserTag(userTag);
        List<GameWS> gameList = libraryList.stream()
                .map(Library::getGameId)
                .map(gameId -> gameFeignRepository.getGameDetails(gameId))
                .toList();
        return LibraryWS.builder()
                .userTag(userTag)
                .gameWS(gameList)
                .build();
    }

}
