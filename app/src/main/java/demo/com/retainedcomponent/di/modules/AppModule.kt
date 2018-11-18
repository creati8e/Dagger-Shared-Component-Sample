package demo.com.retainedcomponent.di.modules

import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector
import demo.com.retainedcomponent.MainActivity
import demo.com.retainedcomponent.di.scopes.PerActivity

@Module(includes = [AndroidInjectionModule::class])
abstract class AppModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivityInjector(): MainActivity

}