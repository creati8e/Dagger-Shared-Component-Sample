package demo.com.retainedcomponent.di.modules

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import demo.com.retainedcomponent.MainChildFragment
import demo.com.retainedcomponent.MainFragment
import demo.com.retainedcomponent.buildViewModel
import demo.com.retainedcomponent.buildViewModelFactory
import demo.com.retainedcomponent.dependencies.FragmentDependency
import demo.com.retainedcomponent.dependencies.SharedViewModel
import demo.com.retainedcomponent.di.scopes.PerChildFragment
import demo.com.retainedcomponent.di.scopes.PerFragment

@Module
class MainFragmentModule {

    @Provides
    @PerFragment
    fun provideSharedViewModel(
        fragment: MainFragment
    ): SharedViewModel {
        val fragmentDependency = FragmentDependency("asd")
        val factory = buildViewModelFactory { SharedViewModel(fragmentDependency) }

        return fragment.buildViewModel { factory }
    }

    @Provides
    @PerFragment
    fun provideFragmentDependency(sharedViewModel: SharedViewModel): FragmentDependency {
        return sharedViewModel.fragmentDependency
    }

    @Module
    abstract class Injector {

        @PerChildFragment
        @ContributesAndroidInjector(modules = [MainChildFragmentModule::class])
        abstract fun mainChildFragmentInjector(): MainChildFragment

    }

}