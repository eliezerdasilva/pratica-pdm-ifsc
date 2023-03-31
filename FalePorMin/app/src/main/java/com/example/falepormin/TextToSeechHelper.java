package com.example.falepormin;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Toast;

import java.util.Locale;

public class TextToSeechHelper implements TextToSpeech.OnInitListener {
    private TextToSpeech tts;
    boolean loded = false;
    public TextToSeechHelper(Context context){
        tts = new TextToSpeech(context,this);
    }


    @Override
    public void onInit(int status) {
        if(status==TextToSpeech.SUCCESS) {
            tts.setLanguage(Locale.US);
            loded= true;
        }else{
            Log.d("TTS", "Sintetizador de voz não disponível ou configurado. ");
        }

    }
    public void speak(String text){

            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }


}
