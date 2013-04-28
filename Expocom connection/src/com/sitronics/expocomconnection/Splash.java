package com.sitronics.expocomconnection;
import android.app.*;
import android.os.*;
import android.content.*;
import android.view.*;
import android.support.v4.app.*;
import android.widget.*;

public class Splash extends FragmentActivity
{
	private final int SPLASH_DISPLAY_LENGHT = 1000;
	private static Handler handler;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle)
	{
        super.onCreate(icicle);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);		
							  
		setContentView(R.layout.splash_screen);
		
        /* New Handler to start the Menu-Activity 
         * and close this Splash-Screen after some seconds.*/
		handler = new Handler();
        handler.postDelayed(new Runnable(){
				@Override
				public void run()
				{
					try
					{
						Intent mainIntent = new Intent(Splash.this, MainActivity.class);
						startActivity(mainIntent);
						finish();
					}
					catch (Exception ex)
					{
						handleException(ex.toString());
					}
				}
				

			}, SPLASH_DISPLAY_LENGHT);
    }
	private Activity getActivity()
	{
		return this;
	}

	private void handleException(final String errorMessage)
	{

		handler.post(new Runnable() {
				public void run()
				{
					Toast.makeText(getActivity(), errorMessage,
								   Toast.LENGTH_LONG).show();

				}
			});


	}
}
