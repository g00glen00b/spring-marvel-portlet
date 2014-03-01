package be.optis.portal.service;

import be.optis.portal.model.ApiKeys;


public interface MarvelService {
    
    String getMarvelCharacters(ApiKeys keys, int offset, int size);
}
