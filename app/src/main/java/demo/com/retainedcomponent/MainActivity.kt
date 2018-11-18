package demo.com.retainedcomponent

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import demo.com.retainedcomponent.dependencies.ActivityDependency
import demo.com.retainedcomponent.dependencies.AppDependency
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var appDependency: AppDependency // same object from App

    @Inject
    lateinit var activityDependency: ActivityDependency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, MainFragment())
                .commit()
        }
    }

}