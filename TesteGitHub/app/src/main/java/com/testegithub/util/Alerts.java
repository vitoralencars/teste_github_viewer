package com.testegithub.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.testegithub.R;

/**
 * Created by vitoralencars on 07/09/17.
 */

public class Alerts {

    private static AlertDialog dialog;
    private static AlertDialog.Builder builder;

    public static void displayConnectionErrorAlert(Context context){
        builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.no_connection_title);
        builder.setMessage(R.string.no_connection_message);
        builder.setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog = builder.create();
        dialog.show();
    }

    public static void displayNotFoundAlert(Context context){
        builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.not_found_title);
        builder.setMessage(R.string.not_found_message);
        builder.setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog = builder.create();
        dialog.show();
    }

}
