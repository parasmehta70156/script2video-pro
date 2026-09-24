package com.paras.videoeditor;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.graphics.Color;
import android.view.Gravity;

public class MainActivity extends Activity {
    private TextView status;
    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(32,48,32,32);
        root.setGravity(Gravity.CENTER_HORIZONTAL);
        TextView title = new TextView(this); title.setText("Paras AI Video Editor"); title.setTextSize(28); title.setTextColor(Color.WHITE);
        TextView sub = new TextView(this); sub.setText("Free Manual Editor  •  AI Pro: ₹299/month"); sub.setTextSize(16); sub.setTextColor(Color.LTGRAY);
        Button importBtn = new Button(this); importBtn.setText("Import Video");
        Button aiBtn = new Button(this); aiBtn.setText("AI Pro Edit — 20 videos/month");
        status = new TextView(this); status.setText("Select a video to start editing."); status.setTextColor(Color.WHITE); status.setTextSize(16);
        root.setBackgroundColor(Color.rgb(18,18,22)); root.addView(title); root.addView(sub); root.addView(importBtn); root.addView(aiBtn); root.addView(status);
        setContentView(root);
        importBtn.setOnClickListener(v -> { Intent i = new Intent(Intent.ACTION_OPEN_DOCUMENT); i.setType("video/*"); i.addCategory(Intent.CATEGORY_OPENABLE); startActivityForResult(i, 10); });
        aiBtn.setOnClickListener(v -> status.setText("AI Pro: Upload a video and the AI editing pipeline will create a short-form edit with cuts, captions, effects, filters and beat-sync.") );
    }
    @Override protected void onActivityResult(int r,int c,Intent d){ super.onActivityResult(r,c,d); if(r==10 && c==RESULT_OK && d!=null){ Uri u=d.getData(); status.setText("Video selected: " + u); } }
}
