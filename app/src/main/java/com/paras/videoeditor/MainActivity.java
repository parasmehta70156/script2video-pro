package com.paras.videoeditor;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.*;

public class MainActivity extends Activity {
    private TextView status;
    private LinearLayout root;
    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        root=new LinearLayout(this); root.setOrientation(LinearLayout.VERTICAL); root.setPadding(28,42,28,28); root.setGravity(Gravity.CENTER_HORIZONTAL); root.setBackgroundColor(Color.rgb(15,15,20));
        TextView title=t("Paras AI Video Editor",28,Color.WHITE); TextView sub=t("Manual Editor + Free Auto Edit + AI Pro",16,Color.LTGRAY);
        Button importBtn=btn("🎬  Import Video"); Button autoBtn=btn("⚡  Free Auto Edit"); Button proBtn=btn("🤖  AI Pro — ₹299/month");
        status=t("Select a video to start.",15,Color.WHITE);
        root.addView(title); root.addView(sub); root.addView(importBtn); root.addView(autoBtn); root.addView(proBtn); root.addView(status); setContentView(root);
        importBtn.setOnClickListener(v->{Intent i=new Intent(Intent.ACTION_OPEN_DOCUMENT); i.setType("video/*"); i.addCategory(Intent.CATEGORY_OPENABLE); startActivityForResult(i,10);});
        autoBtn.setOnClickListener(v->{status.setText("Auto Edit ready: 9:16 • scene cuts • pause removal • beat-style cuts • transitions • zooms • filters • captions • 1080p render.");});
        proBtn.setOnClickListener(v->{status.setText("AI Pro: ₹299/month • 20 AI edits/month. Upload → automatic professional short-form edit.");});
    }
    TextView t(String s,float z,int c){TextView x=new TextView(this);x.setText(s);x.setTextSize(z);x.setTextColor(c);x.setPadding(0,12,0,12);return x;}
    Button btn(String s){Button b=new Button(this);b.setText(s);b.setTextSize(15);b.setAllCaps(false);return b;}
    @Override protected void onActivityResult(int r,int c,Intent d){super.onActivityResult(r,c,d);if(r==10&&c==RESULT_OK&&d!=null){Uri u=d.getData();status.setText("Video selected. Tap ⚡ Auto Edit to create the automatic edit.\n"+u);}}
}
