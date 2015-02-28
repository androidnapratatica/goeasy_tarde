package br.com.goeasy.views;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

import br.com.goeasy.R;
import br.com.goeasy.interactors.MainInteractor;
import hugo.weaving.DebugLog;

/**
 * Created by biliboss on 28/02/2015.
 */
@EFragment(R.layout.fragment_main)
public class MainFragment extends Fragment {

    @Bean
    MainInteractor interactor;

    //Show this Fragment
    public static void show(Activity activity) {
        FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();
        //transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right);
        MainFragment_ fragment = new MainFragment_();
        transaction.replace(R.id.place_holder, fragment, MainFragment_.class.getName());
        transaction.commit();
    }

    @AfterInject
    void afterInject(){
        interactor.setActivity(getActivity());
    }

    @DebugLog
    @Click(R.id.request_ride)
    public void requestRide(){
        interactor.requestRide();
    }

    @Click(R.id.become_driver)
    public void becomeDriver(){
        interactor.becomeDriver();
    }
}
