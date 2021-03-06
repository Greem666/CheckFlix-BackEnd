package com.maciej.checkflix.watchlist.repository;

import com.maciej.checkflix.watchlist.domain.ProviderType;
import com.maciej.checkflix.watchlist.domain.ProviderWatchlist;
import com.maciej.checkflix.watchlist.service.util.SupportedCountries;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedNativeQuery;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ProviderWatchlistRepository extends CrudRepository<ProviderWatchlist, Long> {

    @Override
    List<ProviderWatchlist> findAll();

    Optional<ProviderWatchlist> findByEmailAndImdbIdAndCountryAndProviderType(
            String email, String imdbId,
            SupportedCountries country, ProviderType providerType);

    void deleteByEmailAndImdbId(String email, String imdbId);

    @Query(
            value = "SELECT a.providers_watchlist_id, a.email, a.imdb_id, a.username, a.country, a.provider_type " +
            "FROM providers_watchlist a " +
            "LEFT JOIN imdbid_tmdbid_map b ON a.imdb_id = b.imdb_id " +
            "WHERE a.username LIKE %:PHRASE% OR " +
                    "a.email LIKE %:PHRASE% OR " +
                    "b.title LIKE %:PHRASE%",
            nativeQuery = true
    )
    List<ProviderWatchlist> findBySearchPhrase(@Param("PHRASE") String phrase);
}