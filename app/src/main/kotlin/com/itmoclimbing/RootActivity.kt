package com.itmoclimbing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.itmoclimbing.internal.di.DI
import com.itmoclimbing.internal.di.Scopes
import com.itmoclimbing.internal.navigation.screens.root.RootScreenNavigation
import com.itmoclimbing.presentation.base.BaseActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class RootActivity : BaseActivity(R.layout.activity_root) {

    private val navigator: Navigator by lazy {
        SupportAppNavigator(this, R.id.rootContainer)
//                .apply { rootScreenNavigation.register(this) }
    }

    private val rootScreenNavigation: RootScreenNavigation by lazy {
        DI
                .getScope(Scopes.APP_SCOPE)
                .getInstance(RootScreenNavigation::class.java)
    }

    private val navigatorHolder: NavigatorHolder by lazy {
        DI
                .getScope(Scopes.APP_SCOPE)
                .getInstance(NavigatorHolder::class.java, RootScreenNavigation.NAME)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model = ViewModelProviders.of(this).get(RootViewModel::class.java)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun performOnBackPressed(): Boolean {
        finish()
        return true
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}