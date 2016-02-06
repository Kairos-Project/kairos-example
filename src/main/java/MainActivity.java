import org.kairos.core.Activity;

/**
 * Created by marconi on 28/01/16.
 */
public class MainActivity extends Activity {

    @Override
    public void onCreate() {
        super.onCreate();
        setContentView(getClass().getResource("main_activity.fxml"));
    }

    public void login(){
        startActivity(AppActivity.class);
    }
}
