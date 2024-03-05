package com.example.calculator;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculatorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView previousCalculation;
    private EditText display;

    public CalculatorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalculatorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalculatorFragment newInstance(String param1, String param2) {
        CalculatorFragment fragment = new CalculatorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    TextView tvExpression, tvResult;
    private void writeExpression (String value) {
        if (tmp == 1 && value != "÷" && value != "+" && value != "-" && value != "x"){
            clearScreen();
        }
        tmp = 0;
        String expression = tvResult.getText().toString();
        expression = expression + value;
        tvResult.setText(expression);
    }
    int tmp = 0;
    private void enterPress () {
        tmp = 1;
        String expression = tvResult.getText().toString();
        tvExpression.setText(expression);
        expression = expression.replaceAll(getResources().getString(R.string.divideHBtn), "/");
        expression = expression.replaceAll("x", "*");
        Object result = (double)Math.round(eval(expression) * 100000) / 100000;
        tvResult.setText(result.toString());
    }

    private void delScreen () {
        String result = tvResult.getText().toString();
        String expression = tvExpression.getText().toString();
        // Kiểm tra xem chuỗi có ít nhất một ký tự không
        if (!result.isEmpty() ) {
            if (!expression.isEmpty()){
                expression = expression.substring(0, expression.length() - 1);
                tvResult.setText(expression);
                tvExpression.setText("");
            }
            else {
                // Xóa đi ký tự cuối cùng bằng cách lấy một phần của chuỗi từ vị trí 0 đến độ dài chuỗi trừ đi 1
                result = result.substring(0, result.length() - 1);
                // Cập nhật lại hiển thị của tvResult sau khi xóa ký tự
                tvResult.setText(result);
            }
        }
        else {
            // Nếu chuỗi rỗng, set text của tvResult thành rỗng
            tvResult.setText("");
        }
    }

    private void clearScreen () {
        tvExpression.setText("");
        tvResult.setText("");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_calculator, container, false);

        Configuration configuration = getResources().getConfiguration();
        int orientation = configuration.orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            previousCalculation = rootView.findViewById(R.id.preCalHTextView);
            display = rootView.findViewById(R.id.displayHEditText);
            display.setShowSoftInputOnFocus(false);

            Button zeroBtn = rootView.findViewById(R.id.zeroHBtn);
            zeroBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText(getResources().getString(R.string.zeroHBtn));
                }
            });

            Button oneBtn = rootView.findViewById(R.id.oneHBtn);
            oneBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText(getResources().getString(R.string.oneHBtn));
                }
            });

            Button twoBtn = rootView.findViewById(R.id.twoHBtn);
            twoBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText(getResources().getString(R.string.twoHBtn));
                }
            });

            Button threeBtn = rootView.findViewById(R.id.threeHBtn);
            threeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText(getResources().getString(R.string.threeHBtn));
                }
            });

            Button fourBtn = rootView.findViewById(R.id.fourHBtn);
            fourBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText(getResources().getString(R.string.fourHBtn));
                }
            });

            Button fiveBtn = rootView.findViewById(R.id.fiveHBtn);
            fiveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText(getResources().getString(R.string.fiveHBtn));
                }
            });

            Button sixBtn = rootView.findViewById(R.id.sixHBtn);
            sixBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText(getResources().getString(R.string.sixHBtn));
                }
            });

            Button sevenBtn = rootView.findViewById(R.id.sevenHBtn);
            sevenBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText(getResources().getString(R.string.sevenHBtn));
                }
            });

            Button eightBtn = rootView.findViewById(R.id.eightHBtn);
            eightBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText(getResources().getString(R.string.eightHBtn));
                }
            });

            Button nineBtn = rootView.findViewById(R.id.nineHBtn);
            nineBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText(getResources().getString(R.string.nineHBtn));
                }
            });

            Button doubleZeroBtn = rootView.findViewById(R.id.doubleZeroHBtn);
            doubleZeroBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText(getResources().getString(R.string.doubleZeroHBtn));
                }
            });

            Button decimalBtn = rootView.findViewById(R.id.decimalHBtn);
            decimalBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText(getResources().getString(R.string.decimalHBtn));
                }
            });

            Button openParBtn = rootView.findViewById(R.id.openParHBtn);
            openParBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText(getResources().getString(R.string.parenthesesOpenHBtn));
                }
            });

            Button closeParBtn = rootView.findViewById(R.id.closeParHBtn);
            closeParBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText(getResources().getString(R.string.parenthesesCloseHBtn));
                }
            });

            Button addBtn = rootView.findViewById(R.id.addHBtn);
            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText(getResources().getString(R.string.addHBtn));
                }
            });

            Button subtractBtn = rootView.findViewById(R.id.subtractHBtn);
            subtractBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText(getResources().getString(R.string.subtractHBtn));
                }
            });

            Button multiplyBtn = rootView.findViewById(R.id.mulHBtn);
            multiplyBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText(getResources().getString(R.string.multiplyHBtn));
                }
            });

            Button divideBtn = rootView.findViewById(R.id.divideHBtn);
            divideBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText(getResources().getString(R.string.divideHBtn));
                }
            });

            Button clearBtn = rootView.findViewById(R.id.clearHBtn);
            clearBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    display.setText("");
                    previousCalculation.setText("");
                }
            });

            ImageButton backspaceBtn = rootView.findViewById(R.id.backspaceHBtn);
            backspaceBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int cursorPos = display.getSelectionStart();
                    int textLen = display.getText().length();

                    if (cursorPos != 0 && textLen != 0){
                        SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                        selection.replace(cursorPos-1, cursorPos, "");
                        display.setText(selection);
                        display.setSelection(cursorPos-1);
                    }
                }
            });

            Button equalBtn = rootView.findViewById(R.id.equalHBtn);
            equalBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String userExp = display.getText().toString();

                    previousCalculation.setText(userExp);

                    userExp = userExp.replaceAll(getResources().getString(R.string.divideHBtn), "/");
                    userExp = userExp.replaceAll(getResources().getString(R.string.multiplyHBtn), "*");

                    String result = String.valueOf(eval(userExp));

                    display.setText(result);
                    display.setSelection(result.length());
                }
            });

            Button expBtn = rootView.findViewById(R.id.expHBtn);
            expBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText("exp(");
                }
            });

            Button squareRootBtn = rootView.findViewById(R.id.squareRootHBtn);
            squareRootBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText("sqrt(");
                }
            });

            Button piBtn = rootView.findViewById(R.id.piHBtn);
            piBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText("π");
                }
            });

            Button eBtn = rootView.findViewById(R.id.eHBtn);
            eBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText("e");
                }
            });

            Button powerOfBtn = rootView.findViewById(R.id.xPowerYHBtn);
            powerOfBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText("^(");
                }
            });

            Button sinBtn = rootView.findViewById(R.id.sinHBtn);
            sinBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText("sin(");
                }
            });

            Button cosBtn = rootView.findViewById(R.id.cosHBtn);
            cosBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText("cos(");
                }
            });

            Button tanBtn = rootView.findViewById(R.id.tanHBtn);
            tanBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText("tan(");
                }
            });

            Button arcsinBtn = rootView.findViewById(R.id.arcSinHBtn);
            arcsinBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText("arcsin(");
                }
            });

            Button arccosBtn = rootView.findViewById(R.id.arcCosHBtn);
            arccosBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText("arccos(");
                }
            });

            Button arctanBtn = rootView.findViewById(R.id.arcTanHBtn);
            arctanBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText("arctan(");
                }
            });

            Button logBtn = rootView.findViewById(R.id.logHBtn);
            logBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText("log10(");
                }
            });

            Button lnBtn = rootView.findViewById(R.id.natureLogHBtn);
            lnBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText("ln(");
                }
            });

            Button log2Btn = rootView.findViewById(R.id.log2HBtn);
            log2Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText("log2(");
                }
            });

            Button cubeBtn = rootView.findViewById(R.id.cubeHBtn);
            cubeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText("^(3)");
                }
            });

            Button squareBtn = rootView.findViewById(R.id.squareHBtn);
            squareBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText("^(2)");
                }
            });

            Button absBtn = rootView.findViewById(R.id.absoluteHBtn);
            absBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText("abs(");
                }
            });

            Button percentageBtn = rootView.findViewById(R.id.percentageHBtn);
            percentageBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateText("%");
                }
            });

        } else {
            AppCompatButton btnOne, btnTwo, btnThree, btnFour, btnFive,
                    btnSix, btnSeven, btnEight, btnNine, btnZero, btnDoubleZero,
                    btnDecimal, btnClear, btnEqual, btnPercentage,btnDivide,
                    btnMultiply, btnMinus, btnAdd, btnSqrt, btnBracketLeft,
                    btnBracketRight,btnCaret;
            AppCompatImageButton btnDelete;

            btnZero = rootView.findViewById(R.id.btnZero);
            btnOne = rootView.findViewById(R.id.btnOne);
            btnTwo = rootView.findViewById(R.id.btnTwo);
            btnThree = rootView.findViewById(R.id.btnThree);
            btnFour = rootView.findViewById(R.id.btnFour);
            btnFive = rootView.findViewById(R.id.btnFive);
            btnSix = rootView.findViewById(R.id.btnSix);
            btnSeven = rootView.findViewById(R.id.btnSeven);
            btnEight = rootView.findViewById(R.id.btnEight);
            btnNine = rootView.findViewById(R.id.btnNine);
            btnDecimal = rootView.findViewById(R.id.btnDecimal);
            btnDoubleZero = rootView.findViewById(R.id.btnDoubleZero);

            /* Operator Buttons */
            btnClear = (AppCompatButton) rootView.findViewById(R.id.btnClear);
            btnPercentage = (AppCompatButton) rootView.findViewById(R.id.btnPercentage);
            btnDivide = (AppCompatButton) rootView.findViewById(R.id.btnDivide);
            btnMultiply = (AppCompatButton) rootView.findViewById(R.id.btnMultiply);
            btnMinus = (AppCompatButton) rootView.findViewById(R.id.btnMinus);
            btnAdd = (AppCompatButton) rootView.findViewById(R.id.btnAdd);
            btnEqual = (AppCompatButton) rootView.findViewById(R.id.btnEqual);
            btnDelete = (AppCompatImageButton) rootView.findViewById(R.id.btnDelete);
            btnBracketLeft = (AppCompatButton) rootView.findViewById(R.id.btnBracketLeft);
            btnBracketRight = (AppCompatButton) rootView.findViewById(R.id.btnBracketRight);
            btnCaret = (AppCompatButton) rootView.findViewById(R.id.btnCaret);
            btnSqrt = (AppCompatButton) rootView.findViewById(R.id.btnSqrt);
            /* Text View*/
            tvExpression = (TextView) rootView.findViewById(R.id.tvExpression);
            tvResult = (TextView) rootView.findViewById(R.id.tvResult);

            clearScreen();

            btnClear.setOnClickListener(v -> clearScreen());

            // Set click listeners
            btnZero.setOnClickListener(v -> writeExpression("0"));
            btnOne.setOnClickListener(v -> writeExpression("1"));
            btnTwo.setOnClickListener(v -> writeExpression("2"));
            btnThree.setOnClickListener(v -> writeExpression("3"));
            btnFour.setOnClickListener(v -> writeExpression("4"));
            btnFive.setOnClickListener(v -> writeExpression("5"));
            btnSix.setOnClickListener(v -> writeExpression("6"));
            btnSeven.setOnClickListener(v -> writeExpression("7"));
            btnEight.setOnClickListener(v -> writeExpression("8"));
            btnNine.setOnClickListener(v -> writeExpression("9"));
            btnDecimal.setOnClickListener(v -> writeExpression("."));
            btnDoubleZero.setOnClickListener(v -> writeExpression("00"));
            btnPercentage.setOnClickListener(v -> writeExpression("%"));
            btnDivide.setOnClickListener(v -> writeExpression("÷"));
            btnMultiply.setOnClickListener(v -> writeExpression("x"));
            btnMinus.setOnClickListener(v -> writeExpression("-"));
            btnAdd.setOnClickListener(v -> writeExpression("+"));
            btnSqrt.setOnClickListener(v -> writeExpression("sqrt("));
            btnBracketLeft.setOnClickListener(v -> writeExpression("("));
            btnBracketRight.setOnClickListener(v -> writeExpression(")"));
            btnCaret.setOnClickListener(v -> writeExpression("^"));
            btnEqual.setOnClickListener(v -> enterPress());
            btnDelete.setOnClickListener(v -> delScreen());
        }
        // Trả về rootView của fragment
        return rootView;
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();

        int cursorPos = display.getSelectionStart();
        String left = oldStr.substring(0, cursorPos);
        String right = oldStr.substring(cursorPos);

        display.setText(String.format("%s%s%s", left, strToAdd, right));
        display.setSelection(cursorPos + strToAdd.length());

    }

    //eval function
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if (ch == 'π') { // Ký tự Pi
                    nextChar();
                    x = Math.PI;
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("log")) x = Math.log10(x);
                    else if (func.equals("ln")) x = Math.log(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}