package demo.com.retainedcomponent.dependencies

import demo.com.retainedcomponent.di.scopes.PerActivity
import javax.inject.Inject

@PerActivity
class ActivityDependency @Inject constructor()