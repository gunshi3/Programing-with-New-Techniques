package cn.edu.heuet.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import cn.edu.heuet.login.R;

/**
 * 展示用户信息
 */
public class InfoActivity extends AppCompatActivity {
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        tv1=findViewById(R.id.info_welcome);
        Intent getData=getIntent();
        Bundle bundle=getData.getExtras();//.getExtras()得到intent所附带的值
        String userName=bundle.getString("userName");//通过key获取相应的value
        tv1.setText("欢迎您：" +userName);//给页面赋值
        Button button = findViewById(R.id.info_button);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(InfoActivity.this,LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
        );
    }
}

