package com.maciej.checkflix.tmdbservice.domain.providersearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProviderSearchOverviewDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("results")
    private SearchResultsDto results;
}
