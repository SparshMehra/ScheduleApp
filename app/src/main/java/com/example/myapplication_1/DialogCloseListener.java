package com.example.myapplication_1;

import android.content.DialogInterface;
import android.os.Bundle;

public interface DialogCloseListener {
    void onCreate(Bundle savedInstanceState);

    void handleDialogClose(DialogInterface dialog);
}   public interface DialogCloseListener{
    public void handleDialogClose(DialogInterface dialog):
}
