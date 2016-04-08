package apps.arusoft.com.followme;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;

import javax.inject.Inject;

import apps.arusoft.com.followme.managers.login.FacebookLoginApiImpl;
import apps.arusoft.com.followme.managers.login.LoginApiManager;

public class SecondLevelActivity extends AppCompatActivity implements FacebookLoginApiImpl.LoginListener {

    @Inject
    LoginApiManager loginApiManager;

    private static final String TAG = SecondLevelActivity.class.getSimpleName();
    ShareDialog shareDialog;
    AssetManager assetManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((CustomApplication)this.getApplication()).getAppComponent().inject(this);
        setContentView(R.layout.second_level_activity);
        shareDialog = new ShareDialog(this);
        assetManager = this.getAssets();

        findViewById(R.id.btn_share_something).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                shareLinkDialog();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        LoginManager.getInstance().logOut();
    }


    private void shareLinkDialog() {
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("https://m.facebook.com/StreetwiseDriversClub/"))
                //.setContentDescription("StreetWise Drivers Club")
                //.setContentTitle("Join us now!")
                //.setImageUrl(Uri.parse("https://scontent-lax3-1.xx.fbcdn.net/hphotos-xfp1/v/t1.0-9/11032409_10208953530978198_8670172930837845065_n.jpg?oh=e01f413034c61d6399568d08af792b50&oe=57BDE3DD"))
                .build();
        shareDialog.show(content);
    }
    private void shareDialog(){
        SharePhoto sharePhoto = null;
        try {
            sharePhoto = new SharePhoto.Builder().setBitmap(BitmapFactory.decodeStream(assetManager.open("fb/tesseract.png")))
                    .setCaption("https://www.facebook.com/StreetwiseDriversClub/")
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SharePhotoContent sharePhotoContent = new SharePhotoContent.Builder()
                .addPhoto(sharePhoto).build();
        shareDialog.show(sharePhotoContent);
    }

    private void shareImage(){
        FacebookLoginApiImpl facebookLoginApi = (FacebookLoginApiImpl)loginApiManager.getFacebookLogin(this);
        facebookLoginApi.requierePublishPermissions(this);

        JSONObject objPost = new JSONObject();
        try {
            objPost.put("message", "Hello AFI");
            objPost.put("link", "https://www.facebook.com/StreetwiseDriversClub/");
            objPost.put("picture", "https://scontent-lax3-1.xx.fbcdn.net/hphotos-xta1/v/t1.0-9/c0.12.851.315/p851x315/11036538_548684325282559_2427882488905784480_n.png?oh=57fa9a9c18e9d1f93a9fc7b867d41fd3&oe=578E0BAF" );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GraphRequest.newPostRequest(AccessToken.getCurrentAccessToken(), "me/feed", objPost,
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse graphResponse) {
                        if ( graphResponse != null) {
                            Log.i(TAG, "graphResponse.getJSONObject()::" + graphResponse);
                            //Toast.makeText(context, "Completed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).executeAsync();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onSuccess(Object result) {

    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onError(Exception exception) {

    }
}
