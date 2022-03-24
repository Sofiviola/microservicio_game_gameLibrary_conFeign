package com.dh.gamesLibraryService.model.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class LibraryWS {
    private String userTag;
    private List<GameWS> gameWS;

}
