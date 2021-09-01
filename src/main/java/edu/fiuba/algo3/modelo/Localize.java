package edu.fiuba.algo3.modelo;

public class Localize {
    protected final String esContent;
    protected final String usContent;

    public Localize(String esContent, String usContent) {
        this.esContent = esContent;
        this.usContent = usContent;
    }

    public String greet(String lang) {
        if (lang.equals("us")) {
            return usContent;
        }

        return esContent;
    }

}
