package edu.project1;

@SuppressWarnings({"regexpsinglelinejava", "multiplestringliterals"})
public sealed interface Request permits Defeat, FailedRequest, Repeat, SuccessfulRequest, Win {
    void message(char[] word);

}
