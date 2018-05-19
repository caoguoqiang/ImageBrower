package top.smallc.picturebrower.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.tencent.bugly.beta.Beta;

import top.smallc.picturebrower.R;
import top.smallc.picturebrower.view.tools.HeaderTools;
import top.smallc.picturebrower.view.tools.PreferenceUtils;

/**
 * @author small.cao
 * @date 2018/5/16
 */
public class SetActivity extends BaseActivity {
    private LinearLayout root;
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(R.layout.activity_set);
        initView();
        initData();
    }
    ImageView selectIv;
    private void initView(){
        root = super.findViewById(R.id.ll_root);
        HeaderTools.setTitle(this,R.string.set);
        super.findViewById(R.id.rl_check_update).setOnClickListener(view -> {
            Beta.checkUpgrade(true,false);
        });
        RelativeLayout haveReadRL = super.findViewById(R.id.rl_hidden_have_read);
        selectIv = super.findViewById(R.id.iv_arrow_right);
        haveReadRL.setOnClickListener(v -> {
            boolean isS = PreferenceUtils.getBoolean(context,"isStar",false);
            if(isS){
                PreferenceUtils.putBoolean(context,"isStar",false);
            } else {
                PreferenceUtils.putBoolean(context,"isStar",true);
            }
            initSelectStatus();
        });

        super.findViewById(R.id.rl_about).setOnClickListener(v->{
            AboutActivity.start(context);
        });
    }

    private void initSelectStatus(){
        boolean isStar =PreferenceUtils.getBoolean(context,"isStar",false);
        if(isStar){
            selectIv.setImageResource(R.mipmap.select_press);
        } else {
            selectIv.setImageResource(R.mipmap.select_normal);
        }
    }

    private void initData(){
        initSelectStatus();
    }
}