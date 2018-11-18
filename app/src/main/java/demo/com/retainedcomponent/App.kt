package demo.com.retainedcomponent

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import demo.com.retainedcomponent.di.DaggerAppComponent

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

}