package com.dh.gamesLibraryService.service;

import com.dh.gamesLibraryService.model.dto.LibraryWS;

public interface LibraryService {
    LibraryWS getUserLibrary(String userTag);
}
