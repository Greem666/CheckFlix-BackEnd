package com.maciej.checkflix.omdbservice.client;

import com.maciej.checkflix.omdbservice.config.OmdbConfig;
import com.maciej.checkflix.omdbservice.domain.MovieDetailsDto;
import com.maciej.checkflix.omdbservice.domain.MovieNameSearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OmdbClient {

    private final RestTemplate restTemplate;
    private final OmdbConfig omdbConfig;

    public MovieNameSearchDto findMoviesByName(String movieName) {
        Optional<MovieNameSearchDto> movieSearchResult = Optional.ofNullable(
                restTemplate.getForObject(findMoviesByNameUri(movieName), MovieNameSearchDto.class)
        );

        return movieSearchResult.orElseGet(MovieNameSearchDto::new);
    }

    public MovieNameSearchDto findMoviesByNameAndYear(String movieName, String year) {
        Optional<MovieNameSearchDto> movieSearchResult = Optional.ofNullable(
                restTemplate.getForObject(findMoviesByNameAndYearUri(movieName, year), MovieNameSearchDto.class)
        );

        return movieSearchResult.orElseGet(MovieNameSearchDto::new);
    }

    public MovieNameSearchDto findMoviesByNameAndYearAndType(String movieName, String year, String type) {
        Optional<MovieNameSearchDto> movieSearchResult = Optional.ofNullable(
                restTemplate.getForObject(findMoviesByNameAndYearAndTypeUri(movieName, year, type), MovieNameSearchDto.class)
        );

        return movieSearchResult.orElseGet(MovieNameSearchDto::new);
    }

    public MovieNameSearchDto findMoviesByNameAndType(String movieName, String type) {
        Optional<MovieNameSearchDto> movieSearchResult = Optional.ofNullable(
                restTemplate.getForObject(findMoviesByNameAndTypeUri(movieName, type), MovieNameSearchDto.class)
        );

        return movieSearchResult.orElseGet(MovieNameSearchDto::new);
    }

    private URI findMoviesByNameUri(String movieName) {
        return UriComponentsBuilder.fromHttpUrl(omdbConfig.getApiUrl())
                .queryParam("apikey", omdbConfig.getApiKey())
                .queryParam("s", movieName)
                .encode()
                .build()
                .toUri();
    }

    private URI findMoviesByNameAndYearUri(String movieName, String year) {
        return UriComponentsBuilder.fromHttpUrl(omdbConfig.getApiUrl())
                .queryParam("apikey", omdbConfig.getApiKey())
                .queryParam("s", movieName)
                .queryParam("y", year)
                .encode()
                .build()
                .toUri();
    }

    private URI findMoviesByNameAndYearAndTypeUri(String movieName, String year, String type) {
        return UriComponentsBuilder.fromHttpUrl(omdbConfig.getApiUrl())
                .queryParam("apikey", omdbConfig.getApiKey())
                .queryParam("s", movieName)
                .queryParam("y", year)
                .queryParam("type", type)
                .encode()
                .build()
                .toUri();
    }

    private URI findMoviesByNameAndTypeUri(String movieName, String type) {
        return UriComponentsBuilder.fromHttpUrl(omdbConfig.getApiUrl())
                .queryParam("apikey", omdbConfig.getApiKey())
                .queryParam("s", movieName)
                .queryParam("type", type)
                .encode()
                .build()
                .toUri();
    }

    public MovieDetailsDto findMovieDetailsBy(String movieImdbId) {
        Optional<MovieDetailsDto> movieSearchResult = Optional.ofNullable(
                restTemplate.getForObject(findMovieDetailsByUri(movieImdbId), MovieDetailsDto.class)
        );

        return movieSearchResult.orElseGet(MovieDetailsDto::new);
    }

    private URI findMovieDetailsByUri(String movieImdbId) {
        return UriComponentsBuilder.fromHttpUrl(omdbConfig.getApiUrl())
                .queryParam("apikey", omdbConfig.getApiKey())
                .queryParam("i", movieImdbId)
                .queryParam("plot", "full")
                .encode()
                .build()
                .toUri();
    }
}
