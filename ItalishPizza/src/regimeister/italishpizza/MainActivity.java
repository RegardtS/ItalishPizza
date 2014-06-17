package regimeister.italishpizza;


import android.support.v4.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends Activity {

	MySQLiteHelper db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		db = new MySQLiteHelper(this);
		
	}
	
	public void test1(View v){
		
	}
	public void test2(View v){
		db.addStaffMember("Ned", "passw01rd", "Zero");
	}
	


}
