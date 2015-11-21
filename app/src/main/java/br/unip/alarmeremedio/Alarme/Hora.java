package br.unip.alarmeremedio.Alarme;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Casa on 08/11/2015.
 */
public class Hora extends EditText {

    private boolean isUpdating;


    private int positioning[] = { 0, 1, 2, 3, 5, 6, 7, 9, 10, 11, 13, 14 };

    public Hora(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize();

    }

    public Hora(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();

    }

    public Hora(Context context) {
        super(context);
        initialize();

    }

    public String getCleanText() {
        String text = Hora.this.getText().toString();

        text.replaceAll("[^0-9]*", "");
        return text;

    }

    private void initialize() {

        final int maxNumberLength = 5;
        this.setKeyListener(keylistenerNumber);

        this.setText("  :  ");


        this.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                String current = s.toString();


                if (isUpdating) {
                    isUpdating = false;
                    return;

                }


                String number = current.replaceAll("[^0-9]*", "");
                if (number.length() > 4)
                    number = number.substring(0, 4);
                int length = number.length();


                String paddedNumber = padNumber(number, maxNumberLength);


                String part1 = paddedNumber.substring(0, 2);
                String part2 = paddedNumber.substring(3, 4);


                String hora = part1 + ":" + part2;


                isUpdating = true;
                Hora.this.setText(hora);

                Hora.this.setSelection(positioning[length]);

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }
        });
    }

    protected String padNumber(String number, int maxLength) {
        String padded = new String(number);
        for (int i = 0; i < maxLength - number.length(); i++)
            padded += "                 ";
        return padded;

    }

    private final KeylistenerNumber keylistenerNumber = new KeylistenerNumber();

    private class KeylistenerNumber extends NumberKeyListener {

        public int getInputType() {
            return InputType.TYPE_CLASS_NUMBER
                    | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS;

        }

        @Override
        protected char[] getAcceptedChars() {
            return new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8',
                    '9' };

        }
    }
}