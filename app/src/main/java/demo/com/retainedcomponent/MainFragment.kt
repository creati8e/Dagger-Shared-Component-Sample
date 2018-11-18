package demo.com.retainedcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import demo.com.retainedcomponent.dependencies.ActivityDependency
import demo.com.retainedcomponent.dependencies.AppDependency
import demo.com.retainedcomponent.dependencies.FragmentDependency
import javax.inject.Inject

class MainFragment : DaggerFragment() {

    @Inject
    lateinit var appDependency: AppDependency // same object from App

    @Inject
    lateinit var activityDependency: ActivityDependency // same object from MainActivity

    @Inject
    lateinit var fragmentDependency: FragmentDependency

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            childFragmentManager
                .beginTransaction()
                .add(R.id.mainFragmentContainer, MainChildFragment())
                .commit()
        }
    }

}