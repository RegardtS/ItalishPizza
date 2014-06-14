package regimeister.italishpizza;

import java.util.List;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		MySQLiteHelper db = new MySQLiteHelper(this);

		GridLayout gl = (GridLayout) findViewById(R.id.GridLayoutLogin);

		
		List<String> staff = db.getAllStaff(); 
		
		
		for (int i = 0; i < staff.size(); i+=3) {

			LinearLayout ll = new LinearLayout(getApplicationContext());

			LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

			lp.width = 125;
			lp.height = 175;
			lp.setMargins(8, 8, 8, 8);

			ll.setLayoutParams(lp);

			ll.setBackgroundResource(R.layout.cardbackground);
			ll.setOrientation(LinearLayout.VERTICAL);

			TextView tv = new TextView(getApplicationContext());
			tv.setText(staff.get(i));
			tv.setGravity(Gravity.CENTER);
			tv.setTextColor(Color.BLACK);
			
			ll.addView(tv);

			gl.addView(ll);
			
		}
		
		
		Intent x = new Intent(LoginActivity.this,	MainActivity.class);
		startActivity(x);
		
		
		

		/*
		 * 
		 * <LinearLayout android:layout_width="125dp"
		 * android:layout_height="175dp" android:layout_margin="8dp"
		 * android:background="@layout/cardbackground"
		 * android:orientation="vertical" android:onClick="test1" > <TextView
		 * android:layout_width="wrap_content"
		 * android:layout_height="wrap_content" android:layout_gravity="center"
		 * android:text="Management" > </TextView>
		 * 
		 * </LinearLayout>
		 */

	

	}

}
