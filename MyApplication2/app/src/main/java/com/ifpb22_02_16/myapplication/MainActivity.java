package com.ifpb22_02_16.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    @Bind(R.id.textView_x)
    private TextView mTextView_x;
    @Bind(R.id.text_View_y)
    private TextView mTextView_y;
    @Bind(R.id.text_View_z)
    private TextView mTextView_z;
    @Bind(R.id.text_View_detail)
    private TextView mTextView_detail;

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Float x = event.values[0];
        Float y = event.values[1];
        Float z = event.values[2];

         /*
        Os valores ocilam de -10 a 10.
        X representa a orientação do dispositivo em relação de direita e esquerda:
        quanto maior o valor de X mais para esquerda ele está, quanto menor mais para direita ele está
        Se o valor de  X for 0 então o celular ta em pé - Nem Direita Nem Esquerda
        Y representa se o dispositivo está em pé ou de cabeça para baixo
        Se o valor de Y for 0 então o cel ta "deitado"
        Se o valor de Y for negativo então ta de cabeça pra baixo, então quanto menor y mais ele ta inclinando pra ir pra baixo
        Z indicará se o dispositivo esta inclinado para frente ou para traz.
        Se o valor de Z for 0 então o dispositivo esta reto na horizontal.
        Quanto maioro o valor de Z Mais ele esta inclinado para frente
        Quanto menor o valor de Z Mais ele esta inclinado para traz.
        */
        mTextView_x.setText("Posição X: " + x.intValue() + " Float: " + x);
        mTextView_y.setText("Posição Y: " + y.intValue() + " Float: " + y);
        mTextView_z.setText("Posição Z: " + z.intValue() + " Float: " + z);

        if (y < 0) { // O dispositivo esta de cabeça pra baixo
            if (x > 0)
                mTextView_detail.setText("Virando para ESQUERDA ficando INVERTIDO");
            if (x < 0)
                mTextView_detail.setText("Virando para DIREITA ficando INVERTIDO");
        } else {
            if (x > 0)
                mTextView_detail.setText("Virando para ESQUERDA ");
            if (x < 0)
                mTextView_detail.setText("Virando para DIREITA ");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
