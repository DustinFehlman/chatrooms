package chat.chacharoom.chatrooms;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.chatsdk.core.session.ChatSDK;
import co.chatsdk.core.session.Configuration;
import co.chatsdk.firebase.FirebaseModule;
import co.chatsdk.firebase.file_storage.FirebaseFileStorageModule;
import co.chatsdk.ui.manager.InterfaceManager;
import co.chatsdk.ui.manager.UserInterfaceModule;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        Configuration.Builder builder = new Configuration.Builder(context);
        builder.firebaseRootPath("prod");
        ChatSDK.initialize(builder.build());
        UserInterfaceModule.activate(context);
        FirebaseModule.activate();
        FirebaseFileStorageModule.activate();
        InterfaceManager.shared().a.startLoginActivity(context, true);
    }
}
