import org.kairos.core.Activity;

/**
 * Created by marconi on 31/01/16.
 */
public class AppActivity extends Activity{

    @Override
    public void onCreate() {
        super.onCreate();
        setContentView(getClass().getResource("app_activity.fxml"));
    }
}
