package android.texttospeech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextToSpeech toSpeech;
    int result;
    EditText editText;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText =(EditText) findViewById(R.id.editText);
        toSpeech = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status==TextToSpeech.SUCCESS)
                {   Locale locale = new Locale("tr","TR");
                    result=toSpeech.setLanguage(locale);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Feature nor support",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public void TTS(View view)
    {   switch (view.getId())
    {
        case R.id.bspeak:

        if(result==TextToSpeech.LANG_MISSING_DATA || result==TextToSpeech.LANG_NOT_SUPPORTED)
        {
            Toast.makeText(getApplicationContext(),"Feature nor support",Toast.LENGTH_SHORT).show();
        }
        else
        {
            text=editText.getText().toString();
            toSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);

        }
        break;
        
        case R.id.bstop:
            if (toSpeech!=null)
            {
                toSpeech.stop();

            }
            break;

    }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(toSpeech!=null)
        {
            toSpeech.stop();
            toSpeech.shutdown();
        }
    }


}
