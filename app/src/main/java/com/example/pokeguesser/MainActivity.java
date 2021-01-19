package com.example.pokeguesser;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    Button continue_button;
    Button exit_button;
    TextView pokedex_entry;
    EditText pokemon_answer;
    ImageView pokePic;

    List<QuizEntry> DexEntryQuestions;
    int curDexEntryQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continue_button = (Button) findViewById(R.id.continue_button);
        pokedex_entry = (TextView) findViewById(R.id.pokedex_entry);
        pokemon_answer = (EditText) findViewById(R.id.pokemon_answer);
        pokePic = (ImageView) findViewById(R.id.pokePic);

        continue_button.setVisibility(View.INVISIBLE);

        DexEntryQuestions = new ArrayList<>();
        for(int i = 0; i < DexEntryDatabase.DexEntryQuestions.length; i++){
            DexEntryQuestions.add(new QuizEntry(DexEntryDatabase.DexEntryQuestions[i], DexEntryDatabase.DexEntryAnswers[i],DexEntryDatabase.pokePic[i]));
        }

        Collections.shuffle(DexEntryQuestions);

        pokePic.setImageResource(DexEntryQuestions.get(curDexEntryQuestion).getPokePic());
        pokedex_entry.setText(DexEntryQuestions.get(curDexEntryQuestion).getDexQuestion());

        pokemon_answer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(pokemon_answer.getText().toString().equalsIgnoreCase((DexEntryQuestions.get(curDexEntryQuestion).getPokeAnswer()))){
                    continue_button.setVisibility(View.VISIBLE);
                }
                else{
                    continue_button.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(curDexEntryQuestion < DexEntryDatabase.DexEntryQuestions.length-1) {
                    curDexEntryQuestion++;
                    pokePic.setImageResource(DexEntryQuestions.get(curDexEntryQuestion).getPokePic());
                    pokedex_entry.setText(DexEntryQuestions.get(curDexEntryQuestion).getDexQuestion());
                    continue_button.setVisibility(View.INVISIBLE);
                    pokemon_answer.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "You are a Pokemon Master!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }
}