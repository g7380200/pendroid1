package com.faszallitok.nfl.MyBaseClasses.UI;

public class LabelInput extends MyLabel {
    public CharSequence origText = "";
    public CharSequence val = "";

    public LabelInput(CharSequence text, LabelStyle style) {
        super(text, style);
        origText = text;
        val = "(Katt)";

        setText(origText + ": "+val);

        setX(20);
    }
}
