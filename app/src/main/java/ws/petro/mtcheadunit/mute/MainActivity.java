package ws.petro.mtcheadunit.mute;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

    private AudioManager am = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        am = ((AudioManager) getSystemService(Context.AUDIO_SERVICE));

        boolean currentMute = getMute();
        boolean newMute = !currentMute;

        Toast.makeText(this, "Set Mute: " + (newMute?"TRUE":"FALSE"), Toast.LENGTH_SHORT).show();
        setmute(newMute); // Inverse mute

        finish();
    }

    public boolean getMute() {
        return am.getParameters("av_mute=").equals("true");
    }

    public void setmute(boolean value) {
        am.setParameters("av_mute=" + value);
    }
}
