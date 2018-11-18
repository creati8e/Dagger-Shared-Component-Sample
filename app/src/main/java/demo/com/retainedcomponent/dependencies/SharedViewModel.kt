package demo.com.retainedcomponent.dependencies

import androidx.lifecycle.ViewModel

/**
 * @author Sergey Chuprin
 */
class SharedViewModel(
    val fragmentDependency: FragmentDependency
) : ViewModel()