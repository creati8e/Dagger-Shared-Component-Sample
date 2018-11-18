package demo.com.retainedcomponent

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders


/**
 * Created by Ruslan Arslanov on 12.08.2018.
 */

inline fun <VM : ViewModel> buildViewModelFactory(
    crossinline builder: () -> VM
): BaseViewModelFactory<VM> {
    return object : BaseViewModelFactory<VM> {
        override fun buildViewModel(): VM = builder()
    }
}

inline fun <reified VM : ViewModel> Fragment.buildViewModel(
    crossinline factory: () -> BaseViewModelFactory<VM>
): VM {
    return ViewModelProviders.of(this, factory.invoke()).get(VM::class.java)
}