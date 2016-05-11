package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/5/11.
 */
public class Activity2 extends AppCompatActivity{
    TextView tv;
    Button b;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity2_layout);
        tv = (TextView) findViewById(R.id.textView2);
        b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue mQueue = Volley.newRequestQueue(Activity2.this);
                StringRequest stringRequest = new StringRequest("http://www.sohu.com",
                        new Response.Listener<String>() {

                            @Override
                            public void onResponse(String response) {//Response:响应。
                                tv.setText(response.toString());
                            }

                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Activity2.this,"主活动错误",Toast.LENGTH_LONG).show();
                    }
                });
                mQueue.add(stringRequest);
            }
        });
    }
    //带参数的Request，当请求为Post时，StringRequest的getParams()方法会被调用。
/*StringRequest stringRequest = new StringRequest(Method.POST, url,  listener, errorListener) {
    　　@Override
    　　protected Map<String, String> getParams() throws AuthFailureError {
        　　Map<String, String> map = new HashMap<String, String>();
        　　map.put("params1", "value1");
        　　map.put("params2", "value2");
        　　return map;
        　　}
};
*/
}
