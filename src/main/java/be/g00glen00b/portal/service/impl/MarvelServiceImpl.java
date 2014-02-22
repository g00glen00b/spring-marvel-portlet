package be.g00glen00b.portal.service.impl;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.g00glen00b.portal.model.ApiKeys;
import be.g00glen00b.portal.service.MarvelService;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

@Service
public class MarvelServiceImpl implements MarvelService {

    @Autowired
    private WebResource restService;

    public String getMarvelCharacters(ApiKeys keys, int offset, int size) {
        MultivaluedMap<String, String> params = getAuthenticationParams(keys);
        params.add("offset", Integer.toString(offset));
        params.add("limit", Integer.toString(size));
        return restService.path("characters").queryParams(params).get(String.class);
    }

    private MultivaluedMap<String, String> getAuthenticationParams(ApiKeys keys) {
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        String ts = Long.toString(System.currentTimeMillis());
        queryParams.add("ts", ts);
        queryParams.add("hash", generateHash(keys, ts));
        queryParams.add("apikey", keys.getPublicKey());
        return queryParams;
    }

    private String generateHash(ApiKeys keys, String ts) {
        return DigestUtils.md5Hex(ts + keys.getPrivateKey() + keys.getPublicKey());
    }
}
