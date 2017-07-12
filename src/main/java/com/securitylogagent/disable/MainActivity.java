package com.securitylogagent.disable;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chrisplus.rootmanager.RootManager;
import com.securitylogagentfix.disable.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonEnableSecurityLogAgent = (Button)findViewById(R.id.buttonEnableSecurityLogAgent);
        buttonEnableSecurityLogAgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(RootManager.getInstance().obtainPermission()) {
                    RootManager.getInstance().runCommand("pm enable com.samsung.android.securitylogagent");

                    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.this);
                    dlgAlert.setMessage("Securitylogagent is enable now.");
                    dlgAlert.setTitle("SecurityLogAgent Fix");
                    dlgAlert.setPositiveButton("Reboot",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    RootManager.getInstance().runCommand("reboot");
                                }
                            });
                    dlgAlert.setNegativeButton("Cancel", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();
                }
            }
        });

        Button buttonDisableSecurityLogAgent = (Button)findViewById(R.id.buttonDisableSecurityLogAgent);
        buttonDisableSecurityLogAgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(RootManager.getInstance().obtainPermission()) {
                    RootManager.getInstance().runCommand("pm disable com.samsung.android.securitylogagent");

                    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.this);
                    dlgAlert.setMessage("Securitylogagent is disabled now. Please reboot your phone if the notification persists.");
                    dlgAlert.setTitle("SecurityLogAgent Fix");
                    dlgAlert.setPositiveButton("Reboot",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    RootManager.getInstance().runCommand("reboot");
                                }
                            });
                    dlgAlert.setNegativeButton("Cancel", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();
                }
            }
        });

    }
}
