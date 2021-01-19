package com.example.pokeguesser;

public class QuizEntry {

    private String dexQuestion, pokeAnswer;
    private int pokePic;

    public QuizEntry(String dexQuestion, String pokeAnswer, int pokePic) {
        this.dexQuestion = dexQuestion;
        this.pokeAnswer = pokeAnswer;
        this.pokePic = pokePic;
    }

    public String getDexQuestion() {
        return dexQuestion;
    }

    public String getPokeAnswer() {
        return pokeAnswer;
    }

    public int getPokePic() {
       return pokePic;
    }
}
