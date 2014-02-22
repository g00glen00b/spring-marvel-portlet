package be.g00glen00b.portal.service;

import be.g00glen00b.portal.model.ApiKeys;


public interface MarvelService {
    
    String getMarvelCharacters(ApiKeys keys, int offset, int size);
}
