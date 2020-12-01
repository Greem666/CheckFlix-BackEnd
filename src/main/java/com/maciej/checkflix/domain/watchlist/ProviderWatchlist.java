package com.maciej.checkflix.domain.watchlist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maciej.checkflix.service.util.SupportedCountries;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PROVIDERS_WATCHLIST")
public class ProviderWatchlist {
    @Id
    @GeneratedValue
    @Column(name = "PROVIDERS_WATCHLIST_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "IMDB_ID")
    private String imdbId;

    @Column(name = "COUNTRY")
    private SupportedCountries country;

    public ProviderWatchlist(String username, String email, String imdbId) {
        this.username = username;
        this.email = email;
        this.imdbId = imdbId;
    }
}