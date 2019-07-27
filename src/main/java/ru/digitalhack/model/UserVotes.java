package ru.digitalhack.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class UserVotes {

    @JsonAlias("0")
    String zero;

    @JsonAlias("1")
    String one;

    @JsonAlias("2")
    String two;

    @JsonAlias("3")
    String three;

    @JsonAlias("4")
    String four;

    @JsonAlias("5")
    String five;
}
