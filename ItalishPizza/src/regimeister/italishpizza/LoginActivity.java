package regimeister.italishpizza;

import java.util.List;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		MySQLiteHelper db = new MySQLiteHelper(this);

		GridLayout gl = (GridLayout) findViewById(R.id.GridLayoutLogin);

		
		List<String> staff = db.getAllStaffUsernames(); 
		
		
		
		
		for (int i = 0; i < staff.size(); i++) {
			LinearLayout ll = new LinearLayout(getApplicationContext());
			LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			
			final float scale = getResources().getDisplayMetrics().density;
			lp.width = (int) (125 * scale + 0.5f);
			lp.height = (int) (175 * scale + 0.5f);

			ll.setLayoutParams(lp);
			
			ll.setBackgroundResource(R.layout.cardbackground);
			ll.setOrientation(LinearLayout.VERTICAL);

			TextView tv = new TextView(getApplicationContext());
			tv.setText(staff.get(i));
			tv.setGravity(Gravity.CENTER);
			tv.setTextColor(Color.BLACK);
			tv.setBackgroundColor(Color.GRAY);
			
			ll.addView(tv);
			
			View v = new View(getApplicationContext());

			LayoutParams lp2 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			lp2.width = (int) (8 * scale + 0.5f);
			lp2.height = (int) (175 * scale + 0.5f);

			v.setLayoutParams(lp2);
		
			gl.addView(v);
			
			ll.setTag(staff.get(i));
			ll.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					MySQLiteHelper sql = new MySQLiteHelper(getApplicationContext());
					Toast.makeText(getApplicationContext(), sql.verifyUser("Ned", "passw01rd") + "", Toast.LENGTH_SHORT).show();
					
					
				}
			});
			gl.addView(ll);
			
			
			
			
		}
		
	
		
		
		

	     
		
		
		
	
		
		


	

	}

}
