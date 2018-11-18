package demo.com.retainedcomponent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


/**
 * Created by Ruslan Arslanov on 12.08.2018.
 */
interface BaseViewModelFactory<VM : ViewModel> : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(modelClass)) {
            @Suppress("UNCHECKED_CAST")
            return buildViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    fun buildViewModel(): VM

}