package demo.com.retainedcomponent.dependencies

import demo.com.retainedcomponent.di.scopes.PerChildFragment
import javax.inject.Inject

@PerChildFragment
class ChildFragmentDependency @Inject constructor()