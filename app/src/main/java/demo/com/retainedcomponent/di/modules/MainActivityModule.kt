package demo.com.retainedcomponent.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import demo.com.retainedcomponent.MainFragment
import demo.com.retainedcomponent.di.scopes.PerFragment

@Module
abstract class MainActivityModule {

    @PerFragment
    @ContributesAndroidInjector(
        modules = [
            MainFragmentModule::class,
            MainFragmentModule.Injector::class
        ]
    )
    abstract fun mainFragmentInjector(): MainFragment


}
