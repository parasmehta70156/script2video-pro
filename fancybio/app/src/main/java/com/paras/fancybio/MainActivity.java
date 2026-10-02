package com.paras.fancybio;

import android.app.*;import android.os.*;import android.content.*;import android.graphics.Color;import android.view.*;import android.widget.*;

public class MainActivity extends Activity {
 LinearLayout root, results; EditText input;
 @Override public void onCreate(Bundle b){super.onCreate(b); build();}
 TextView tv(String s,int size){TextView t=new TextView(this);t.setText(s);t.setTextColor(Color.WHITE);t.setTextSize(size);t.setPadding(18,14,18,14);return t;}
 void build(){
  root=new LinearLayout(this);root.setOrientation(LinearLayout.VERTICAL);root.setPadding(18,20,18,12);root.setBackgroundColor(Color.rgb(11,11,16));
  TextView title=tv("✨ FancyBio",28);title.setTypeface(null,1);root.addView(title);
  TextView sub=tv("Fancy Text • Instagram Bio • Gaming Names",14);sub.setTextColor(Color.LTGRAY);root.addView(sub);
  input=new EditText(this);input.setHint("Type your name or text…");input.setHintTextColor(Color.GRAY);input.setTextColor(Color.WHITE);input.setSingleLine(false);input.setBackgroundColor(Color.rgb(23,23,32));root.addView(input,new LinearLayout.LayoutParams(-1,110));
  LinearLayout buttons=new LinearLayout(this);buttons.setOrientation(LinearLayout.HORIZONTAL);
  Button gen=new Button(this);gen.setText("GENERATE");buttons.addView(gen,new LinearLayout.LayoutParams(0,60,1));
  Button clear=new Button(this);clear.setText("CLEAR");buttons.addView(clear,new LinearLayout.LayoutParams(0,60,1));root.addView(buttons);
  TextView section=tv("Popular Styles",19);section.setTypeface(null,1);root.addView(section);
  results=new LinearLayout(this);results.setOrientation(LinearLayout.VERTICAL);ScrollView sv=new ScrollView(this);sv.addView(results);root.addView(sv,new LinearLayout.LayoutParams(-1,0,1));
  gen.setOnClickListener(v->generate());clear.setOnClickListener(v->{input.setText("");results.removeAllViews();}); generate(); setContentView(root);
 }
 void generate(){results.removeAllViews();String s=input.getText().toString();if(s.trim().isEmpty())s="Your Name";
  String[] outs={"𝓕𝓪𝓷𝓬𝔂  "+s,"𝕲𝖆𝖒𝖎𝖓𝖌  "+s,"𝐁𝐨𝐥𝐝  "+s,"𝑰𝒕𝒂𝒍𝒊𝒄  "+s,"𝙎𝙩𝙮𝙡𝙞𝙨𝙝  "+s,"𝚆𝚒𝚍𝚎  "+s,"Sᴍᴀʟʟ Cᴀᴘs  "+s,"꧁༺ "+s+" ༻꧂","亗 "+s+" 亗","★彡 "+s+" 彡★"}; for(String o:outs) addResult(o);
 }
 void addResult(String text){LinearLayout row=new LinearLayout(this);row.setGravity(Gravity.CENTER_VERTICAL);row.setPadding(8,8,8,8);row.setBackgroundColor(Color.rgb(23,23,32));TextView t=tv(text,17);row.addView(t,new LinearLayout.LayoutParams(0,70,1));Button copy=new Button(this);copy.setText("COPY");row.addView(copy,new LinearLayout.LayoutParams(100,60));copy.setOnClickListener(v->{((android.content.ClipboardManager)getSystemService(CLIPBOARD_SERVICE)).setPrimaryClip(android.content.ClipData.newPlainText("FancyBio",text));Toast.makeText(this,"Copied!",Toast.LENGTH_SHORT).show();});results.addView(row);Space sp=new Space(this);results.addView(sp,new LinearLayout.LayoutParams(1,8));}
}
