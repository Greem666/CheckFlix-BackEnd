package com.maciej.checkflix.watchlist.domain.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Mail {
    private final String mailFrom;
    private final String mailTo;
    private final String subject;
    private final String message;
    private String toCc;
}
