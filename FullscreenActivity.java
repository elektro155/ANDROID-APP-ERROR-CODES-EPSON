package com.example.komputer.myapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);


        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
            }
        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);
    }

    public void onButtonClick(View w)
    {
        EditText e2 = (EditText)findViewById(R.id.editText2); //czytanie z pola tekstowego
        TextView t1 = (TextView)findViewById(R.id.textView2); //ti obiekt od wyswietlania
        String s = (e2.getText().toString()); //rzutowanie tego co wpisał uzytkownik do stringa
        switch(s)
        {
            case "00000101": {
                t1.setText("The CR Motor reached its end of life");
                break;
            }
            case "00010000": {
                t1.setText("PF Encoder check error");
                break;
            }
            case "00010001": {
                t1.setText("The PF Motor is out of step.");
                break;
            }
            case "00010002": {
                t1.setText("Overcurrent occurred on the PF Motor.");
                break;
            }
            case "00010003": {
                t1.setText("The PF Motor out of position time-out error");
                break;
            }
            case "00010004": {
                t1.setText("CR Encoder check error");
                break;
            }
            case "00010005": {
                t1.setText("CR Motor is out of step.");
                break;
            }
            case "00010007": {
                t1.setText("The CR Motor out of position time-out error");
                break;
            }
            case "00010008": {
                t1.setText("Servo interrupt watchdog time-out error");
                break;
            }
            case "00010009": {
            t1.setText("System interrupt watchdog time-out error");
            break;
            }
            case "0001000A": {
            t1.setText("Carriage home position detection error");
            break;
            }
            case "0001000a": {
            t1.setText("Carriage home position detection error");
            break;
            }
            case "0001000C": {
            t1.setText("PG home position detection error");
            break;
            }
            case "0001000c": {
                t1.setText("PG home position detection error");
                break;
            }
            case "00010014": {
            t1.setText("Failure of pressurizing");
            break;
            }
            case "0001001B": {
            t1.setText("Head driver (TG) temperature error");
            break;
            }
            case "0001001b": {
                t1.setText("Head driver (TG) temperature error");
                break;
            }
            case "0001001D": {
                t1.setText("CR servo parameter error");
                break;
            }
            case "0001001d": {
                t1.setText("CR servo parameter error");
                break;
            }
            case "0001001E": {
            t1.setText("PF servo parameter error");
            break;
            }
            case "0001001e": {
                t1.setText("PF servo parameter error");
                break;
            }
            case "00010020": {
                t1.setText("CSIC reading/writing error");
                break;
            }
            case "00010023": {
                t1.setText("RTC analyzing error");
                break;
            }
            case "00010026": {
            t1.setText("RTC communication error");
            break;
            }
            case "00010027": {
                t1.setText("Pressure pump micro air-leak error");
                break;
            }
            case "00010028": {
                t1.setText("Head error");
                break;
            }
            case "0001002A": {
                t1.setText("CR ASIC ECU error");
                break;
            }
            case "0001002a": {
                t1.setText("CR ASIC ECU error");
                break;
            }
            case "0001002D": {
                t1.setText("The Cleaning Unit reached its end of life.");
                break;
            }
            case "0001002d": {
                t1.setText("The Cleaning Unit reached its end of life.");
                break;
            }
            case "00010035": {
                t1.setText("Pump phase detection error");
                break;
            }
            case "000010036": {
                t1.setText("Type-B board installation error");
                break;
            }
            case "00010037": {
                t1.setText("Head thermistor error");
                break;
            }
            case "00010038": {
                t1.setText("Transistor thermistor error");
                break;
            }
            case "0001003E": {
                t1.setText("Pressure Sensor failure");
                break;
            }
            case "0001003e": {
                t1.setText("Pressure Sensor failure");
                break;
            }
            case "0001003F": {
                t1.setText("The Pressure Motor reached its end of life.");
                break;
            }
            case "0001003f": {
                t1.setText("The Pressure Motor reached its end of life.");
                break;
            }
            case "00010040": {
                t1.setText("Printing position error");
                break;
            }
            case "00020000": {
                t1.setText("NVRAM error");
                break;
            }
            case "00020002": {
                t1.setText("SDRAM error");
                break;
            }
            case "00020003": {
                t1.setText("Boot program sum error");
                break;
            }
            case "0002000A": {
                t1.setText("Program load error");
                break;
            }
            case "0002000a": {
                t1.setText("Program load error");
                break;
            }
            case "0002000B": {
                t1.setText("The internal memory is insufficient.");
                break;
            }
            case "0002000b": {
                t1.setText("The internal memory is insufficient.");
                break;
            }
            case "100000E0": {
                t1.setText("CPU address error (load)");
                break;
            }
            case "100000e0": {
                t1.setText("CPU address error (load)");
                break;
            }
            case "10000100": {
                t1.setText("CPU address error (store)");
                break;
            }
            case "10000180": {
                t1.setText("CPU reserved command code exception error");
                break;
            }
            case "100001A0": {
                t1.setText("CPU slot undefined command exception error");
                break;
            }
            case "100001a0": {
                t1.setText("CPU slot undefined command exception error");
                break;
            }
            case "100001C0": {
                t1.setText("The AC power is shut off.");
                break;
            }
            case "100001c0": {
                t1.setText("The AC power is shut off.");
                break;
            }
            case "100005C0": {
                t1.setText("CPU DMA address error");
                break;
            }
            case "100005c0": {
                t1.setText("CPU DMA address error");
                break;
            }
            default:
                t1.setText("BRAK TAKIEGO BLEDU/THERE IS NO SUCH ERROR");
                break;

        }
        //t1.setText(s);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }
}
