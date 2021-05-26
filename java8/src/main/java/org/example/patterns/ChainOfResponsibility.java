package org.example.patterns;

interface AuthenticationProcessor {
    int authenticate(String person);
}

class Machine implements AuthenticationProcessor {
    private final AuthenticationProcessor authenticationProcessor;

    public Machine(final AuthenticationProcessor authenticationProcessor) {
        this.authenticationProcessor = authenticationProcessor;
    }

    @Override
    public int authenticate(String person) {
        if (person == null)
            return 0;
        if (person.toCharArray().length < 5 ) {
            return 1;
        }
        return authenticationProcessor.authenticate(person);
    }
}


public class ChainOfResponsibility {



}
